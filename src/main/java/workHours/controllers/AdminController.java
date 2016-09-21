package workHours.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import workHours.entities.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import workHours.entities.User;
import workHours.entities.UserDAO;
import workHours.entities.UserRole;
import workHours.entities.UserRoleDAO;


@Controller
@RequestMapping(value="/admin/")
public class AdminController {

    private final JobSeekerDAO jobSeekerDAO;
    private final AdminDAO adminDAO;                                     // DAO provide some specific data operations without exposing details of the database
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;
    private final PasswordEncoder passwordEncoder;


    public AdminController( AdminDAO adminDAO, JobSeekerDAO jobSeekerDAO, TimeSheetTrackerDAO timeSheetTrackerDAO, UserDAO userDAO, UserRoleDAO userRoleDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
        this.passwordEncoder = passwordEncoder;
        Assert.notNull(adminDAO, "AdminDAO must not be null!");
        this.adminDAO = adminDAO;
        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null!");  //Assert extends object validates method arguments...it will not be if you do not meet my criteria
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
        Assert.notNull(jobSeekerDAO, "JobSeekerDAO must not be null!");
        this.jobSeekerDAO = jobSeekerDAO;
    }

    @RequestMapping(value="/")    //Annotation for mapping web requests onto specific handler classes and/or handler methods
    public String allUsers(ModelMap model) {
        Iterable<User> users = userDAO.findAll();
        model.addAttribute("users",users);
        model.addAttribute("roleTypes", RoleType.values());

        Iterable<JobSeeker> jobSeekers = jobSeekerDAO.findAll();  //pulling information to the same home page need logic for all db objects
        model.addAttribute("jobSeekers", jobSeekers);
        return "admin/adminHomePage";
    }

    @RequestMapping(value="addNewUser")
    public String addNewUser(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("roleTypes", RoleType.values());
        return "admin/addNewUser";
    }

    @RequestMapping(value="/securePage")
    public String securePage() {
        return "secure/securePage";
    }


    @RequestMapping(value="/saveNewUser")
    public String saveUser(Long userId, String username, String password, String email, String firstName, String lastName, String phone, String Address, double Salary ) {
        User user = new User(username,passwordEncoder.encode(password),1,email);
        userDAO.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserid(user.getUserId());
        userRole.setRole("USER");
        userRoleDAO.save(userRole);
//        return new RedirectView("/securePage");
        return "admin/adminHomePage";
    }


    @RequestMapping(value="editUser")
    public String editUser(Long userId,ModelMap model) {
//        System.out.println("Employee ID is: " + employeeID); //used for debugging
        User user = userDAO.findOne(Long.valueOf(userId));  //changes string empID to long
        model.addAttribute("user",user);
        model.addAttribute("roleTypes", RoleType.values());
        return "/admin/editUser";
    }

    @RequestMapping(value="deleteUser")
    public View deleteUser(Long id) {                       //this method is to delete question
        User user = userDAO.findOne(id);
        userDAO.delete(user);  //going to the dao, deleting that particular question
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="saveEditedUser")
    public View saveEditedUser(User user) {
        userDAO.save(user);
        return new RedirectView("/admin/");
    }

    @RequestMapping("uploadUsers")
    public String uploadUsers() {       //passing string on to a jsp to view
        return "admin/uploadUsers";
    }

    @RequestMapping("saveUploadedUsers")
    public View saveUploadedUsers(MultipartFile UsersFile) {
        String returnView = "";
        if (!UsersFile.isEmpty()) {
            try {
                String pathString = "/Users/perrythomson/UPLOADS_Capstone_Users/";
                Files.write(Paths.get(pathString+UsersFile.getOriginalFilename()),UsersFile.getBytes());
                System.out.println("-------- File Upload Successful");
                addUploadToDatabase(pathString+UsersFile.getOriginalFilename()); //passing the file location which need to be the same as 2 lines above
            } catch (IOException | RuntimeException e) {                    //two exceptions at once J8 short code
                e.printStackTrace();
            }
        } else {
            System.out.println("-------- File Is EMPTY!");
        }
        return new RedirectView("/admin/");
    }

    private void addUploadToDatabase(String filePath) {
        try {
            Path userUploadedFilePath = Paths.get(filePath);
            ObjectMapper mapper = new ObjectMapper();  //map json to entities
            List<User> uploadedUsers = mapper.readValue(Files.newInputStream(userUploadedFilePath), new TypeReference<List<User>>(){});
            for(User uploadedUser : uploadedUsers) {  //creating new id's so that it doesn't barf and error
                User user = new User();
                user.setFirstName(uploadedUser.getFirstName());
                user.setLastName(uploadedUser.getLastName());
                user.setPhone(uploadedUser.getPhone());
                user.setAddress(uploadedUser.getAddress());
                user.setSalary(uploadedUser.getSalary());
                userDAO.save(user);
            }
        } catch (IOException ioe) {
            System.out.println("Issue reading List from JSON file");
            ioe.printStackTrace();
        }
    }

    @RequestMapping("uploadTimeSheet")         //jsp needs to be created TODO
    public String uploadTimeSheet() {       //passing string on to a jsp to view
        return "admin/viewAllTimeSheets";
    }

    @RequestMapping("saveUploadedTimeSheet")
    public View saveUploadedTimeSheet(MultipartFile TimeSheetsFile) {  //multipartfile is one of the types of things I can pass from the method
        //can be a json file or image, etc, anything that has its own stuff
        //TODO research View from signature
        String returnView = "";
        if (!TimeSheetsFile.isEmpty()) {
            try {//(below) get current file name...get contents
                String pathString = "/Users/perrythomson/UPLOADS_Capstone_TimeSheets/"; //TODO create string for the try statement
                Files.write(Paths.get(pathString+TimeSheetsFile.getOriginalFilename()),TimeSheetsFile.getBytes());
                System.out.println("-------- File Upload Successful");
                addUploadTimeSheetToDatabase(pathString+TimeSheetsFile.getOriginalFilename()); //passing the file location which need to be the same as 2 lines above
            } catch (IOException | RuntimeException e) {                    //two exceptions at once J8 short code
                e.printStackTrace();
            }
        } else {
            System.out.println("-------- File Is EMPTY!");
        }
        return new RedirectView("/admin/");
    }

    private void addUploadTimeSheetToDatabase(String filePath) {
        try {
            Path timeSheetUploadedFilePath = Paths.get(filePath);
            ObjectMapper mapper = new ObjectMapper();  //map json to entities
            List<TimeSheetTracker> uploadedEmployeeTimeSheets = mapper.readValue(Files.newInputStream(timeSheetUploadedFilePath), new TypeReference<List<TimeSheetTracker>>(){});
            for(TimeSheetTracker uploadedEmployeeTimeSheet : uploadedEmployeeTimeSheets) {  //creating new id's so that it doesn't barf and error
                TimeSheetTracker timeSheetTracker = new TimeSheetTracker();
                timeSheetTracker.setStartTime(uploadedEmployeeTimeSheet.getStartTime());
                timeSheetTracker.setEndTime(uploadedEmployeeTimeSheet.getEndTime());
                timeSheetTracker.setLunchStart(uploadedEmployeeTimeSheet.getLunchStart());
                timeSheetTracker.setLunchEnd(uploadedEmployeeTimeSheet.getLunchEnd());
                timeSheetTracker.setTask(uploadedEmployeeTimeSheet.getTask());
                timeSheetTracker.setTotalDayHours(uploadedEmployeeTimeSheet.getTotalDayHours());
                timeSheetTrackerDAO.save(timeSheetTracker);
            }
        } catch (IOException ioe) {
            System.out.println("Issue reading List from JSON file");
            ioe.printStackTrace();
        }
    }


}
//    @RequestMapping(value="addNewEmployee")
//    public String addNewEmployee(ModelMap model) {
//        model.addAttribute("user", new Employee());
//        model.addAttribute("roleTypes", RoleType.values());
//        return "admin/addNewEmployee";
//    }

//    @RequestMapping(value="saveNewEmployee")
//    public View saveNewEmployee(Employee user) {
//        employeeDAO.save(user);
//        return new RedirectView("/admin/");
//    }

//    @RequestMapping(value="editEmployee")
//    public String editEmployee(String employeeID,ModelMap model) {
////        System.out.println("Employee ID is: " + employeeID); //used for debugging
//        Employee user = employeeDAO.findOne(Long.valueOf(employeeID));  //changes string empID to long
//        model.addAttribute("user",user);
//        model.addAttribute("roleTypes", RoleType.values());
////        Admin admin = adminDAO.findOne(employeeID);
////        adminModel.addAttribute("admin",admin);
////        return "/admin/editEmployee";
//        return "/admin/editEmployee";
//    }
//    //this routes from EDIT user
//    @RequestMapping(value="viewEmployee")
//    public View viewEmployee(Long employeeID,ModelMap model, Long adminID, ModelMap adminModel) {
//        Employee user = employeeDAO.findOne(employeeID);
//        model.addAttribute("user",user);
////        Admin admin = adminDAO.findOne(employeeID);
////        adminModel.addAttribute("admin",admin);
////        return "/admin/editEmployee";
//        return new RedirectView("/admin/editEmployee");
//    }