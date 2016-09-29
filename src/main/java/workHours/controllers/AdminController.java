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
import workHours.entities.JobSeeker;
import workHours.entities.JobSeekerDAO;
import workHours.entities.AdminDAO;
import workHours.entities.RoleType;
import workHours.entities.InterestedParty;
import workHours.entities.InterestedPartyDAO;


@Controller
@RequestMapping(value="/admin/")
public class AdminController {

    private final JobSeekerDAO jobSeekerDAO;
    private final AdminDAO adminDAO;                                     // DAO provide some specific data operations without exposing details of the database
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleDAO userRoleDAO;
    private final InterestedPartyDAO interestedPartyDAO;


    public AdminController(InterestedPartyDAO interestedPartyDAO, UserRoleDAO userRoleDAO, PasswordEncoder passwordEncoder, AdminDAO adminDAO, JobSeekerDAO jobSeekerDAO, TimeSheetTrackerDAO timeSheetTrackerDAO, UserDAO userDAO) {
        Assert.notNull(userDAO, "UserDAO must not be null!");
        this.userDAO = userDAO;
        Assert.notNull(adminDAO, "AdminDAO must not be null!");
        this.adminDAO = adminDAO;
        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null!");  //Assert extends object validates method arguments...it will not be if you do not meet my criteria
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
        Assert.notNull(jobSeekerDAO, "JobSeekerDAO must not be null!");
        this.jobSeekerDAO = jobSeekerDAO;
        Assert.notNull(passwordEncoder, "PasswordEncoder must not be null!");
        this.passwordEncoder = passwordEncoder;
        Assert.notNull(userRoleDAO, "UserRoleDAO must not be null!");
        this.userRoleDAO = userRoleDAO;
        Assert.notNull(interestedPartyDAO, "InterestedPartyDAO must not be null!");
        this.interestedPartyDAO = interestedPartyDAO;
    }

    @RequestMapping(value="/")    //Annotation for mapping web requests onto specific handler classes and/or handler methods
    public String allUsers(ModelMap model) {
        Iterable<User> users = userDAO.findAll();
        model.addAttribute("users",users);
        model.addAttribute("roleTypes", RoleType.values());

        Iterable<JobSeeker> jobSeekers = jobSeekerDAO.findAll();  //pulling information to the same home page need logic for all db objects
        model.addAttribute("jobSeekers", jobSeekers);
//        return "admin/adminHomePage"; //anything after the return statement makes it unreachable

        Iterable<InterestedParty> interestedParties = interestedPartyDAO.findAll();
        model.addAttribute("interestedParties", interestedParties);


        return "admin/adminHomePage";
    }

//    @RequestMapping(value="addNewUser")
//    public String addNewUser(ModelMap model) {
//        model.addAttribute("user", new User());
//        model.addAttribute("roleTypes", RoleType.values());
//        return "admin/addNewUser";
//    }


    @RequestMapping(value="viewAllUsers")
    public String allEmployees(ModelMap model) {
        Iterable<User> users = userDAO.findAll();
        model.addAttribute("users",users);
        model.addAttribute("roleTypes", RoleType.values());
        return "admin/viewAllUsers";
    }

    @RequestMapping(value="deleteUser")
    public View deleteUser(Long id) {                       //this method is to delete question
        User user = userDAO.findOne(id);
        userDAO.delete(user);  //going to the dao, deleting that particular question
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="addNewUser")
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value="saveNewUser")
    public View saveUser(String username, String password, String email) {
        User user = new User(username,passwordEncoder.encode(password),1,email);
        userDAO.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserid(user.getUserId());
        userRole.setRole("USER");
        userRoleDAO.save(userRole);
//        model.addAttribute("roleTypes", RoleType.values());

        return new RedirectView("/admin/");
    }

    @RequestMapping(value="editUser")
    public String editUser(String userId,ModelMap model) {
//        System.out.println("User ID is: " + userId); //used for debugging
        User user = userDAO.findOne(Long.valueOf(userId));  //changes string empID to long
        model.addAttribute("user",user);
        model.addAttribute("roleTypes", RoleType.values());
//        Admin admin = adminDAO.findOne(userId);
//        adminModel.addAttribute("admin",admin);
//        return "/admin/editUser";
        return "/admin/editUser";
    }
    @RequestMapping(value="saveEditedUser")
    public View saveEditedUser(User user) {
        userDAO.save(user);
        return new RedirectView("/admin/");
    }

//    @RequestMapping("uploadUsers")
//    public String uploadUsers() {       //passing string on to a jsp to view
//        return "admin/uploadUsers";
//    }
//
//    @RequestMapping("saveUploadedUsers")
//    public View saveUploadedUsers(MultipartFile UsersFile) {
//        String returnView = "";
//        if (!UsersFile.isEmpty()) {
//            try {
//                String pathString = "/Users/perrythomson/UPLOADS_Capstone_Users/";
//                Files.write(Paths.get(pathString+UsersFile.getOriginalFilename()),UsersFile.getBytes());
//                System.out.println("-------- File Upload Successful");
//                addUploadToDatabase(pathString+UsersFile.getOriginalFilename()); //passing the file location which need to be the same as 2 lines above
//            } catch (IOException | RuntimeException e) {                    //two exceptions at once J8 short code
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("-------- File Is EMPTY!");
//        }
//        return new RedirectView("/admin/");
//    }
//
//    private void addUploadToDatabase(String filePath) {
//        try {
//            Path userUploadedFilePath = Paths.get(filePath);
//            ObjectMapper mapper = new ObjectMapper();  //map json to entities
//            List<User> uploadedUsers = mapper.readValue(Files.newInputStream(userUploadedFilePath), new TypeReference<List<User>>(){});
//            for(User uploadedUser : uploadedUsers) {  //creating new id's so that it doesn't barf and error
//                User user = new User();
//                user.setFirstName(uploadedUser.getFirstName());
//                user.setLastName(uploadedUser.getLastName());
//                user.setPhone(uploadedUser.getPhone());
//                user.setAddress(uploadedUser.getAddress());
//                user.setSalary(uploadedUser.getSalary());
//                userDAO.save(user);
//            }
//        } catch (IOException ioe) {
//            System.out.println("Issue reading List from JSON file");
//            ioe.printStackTrace();
//        }
//    }
//
//    @RequestMapping("uploadTimeSheet")         //jsp needs to be created TODO
//    public String uploadTimeSheet() {       //passing string on to a jsp to view
//        return "admin/viewAllTimeSheets";
//    }
//
//    @RequestMapping("saveUploadedTimeSheet")
//    public View saveUploadedTimeSheet(MultipartFile TimeSheetsFile) {
//        String returnView = "";
//        if (!TimeSheetsFile.isEmpty()) {
//            try {//(below) get current file name...get contents
//                String pathString = "/Users/perrythomson/UPLOADS_Capstone_TimeSheets/"; //TODO create string for the try statement
//                Files.write(Paths.get(pathString+TimeSheetsFile.getOriginalFilename()),TimeSheetsFile.getBytes());
//                System.out.println("-------- File Upload Successful");
//                addUploadTimeSheetToDatabase(pathString+TimeSheetsFile.getOriginalFilename()); //passing the file location which need to be the same as 2 lines above
//            } catch (IOException | RuntimeException e) {                    //two exceptions at once J8 short code
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("-------- File Is EMPTY!");
//        }
//        return new RedirectView("/admin/");
//    }
//
//    private void addUploadTimeSheetToDatabase(String filePath) {
//        try {
//            Path timeSheetUploadedFilePath = Paths.get(filePath);
//            ObjectMapper mapper = new ObjectMapper();  //map json to entities
//            List<TimeSheetTracker> uploadedUserTimeSheets = mapper.readValue(Files.newInputStream(timeSheetUploadedFilePath), new TypeReference<List<TimeSheetTracker>>(){});
//            for(TimeSheetTracker uploadedUserTimeSheet : uploadedUserTimeSheets) {  //creating new id's so that it doesn't barf and error
//                TimeSheetTracker timeSheetTracker = new TimeSheetTracker();
//                timeSheetTracker.setStartTime(uploadedUserTimeSheet.getStartTime());
//                timeSheetTracker.setEndTime(uploadedUserTimeSheet.getEndTime());
//                timeSheetTracker.setLunchStart(uploadedUserTimeSheet.getLunchStart());
//                timeSheetTracker.setLunchEnd(uploadedUserTimeSheet.getLunchEnd());
//                timeSheetTracker.setTask(uploadedUserTimeSheet.getTask());
//                timeSheetTracker.setTotalDayHours(uploadedUserTimeSheet.getTotalDayHours());
//                timeSheetTrackerDAO.save(timeSheetTracker);
//            }
//        } catch (IOException ioe) {
//            System.out.println("Issue reading List from JSON file");
//            ioe.printStackTrace();
//        }
//    }


}

//    //this routes from EDIT user
//    @RequestMapping(value="viewUser")
//    public View viewUser(Long userId,ModelMap model, Long adminID, ModelMap adminModel) {
//        User user = userDAO.findOne(userId);
//        model.addAttribute("user",user);
////        Admin admin = adminDAO.findOne(userId);
////        adminModel.addAttribute("admin",admin);
////        return "/admin/editUser";
//        return new RedirectView("/admin/editUser");
//    }