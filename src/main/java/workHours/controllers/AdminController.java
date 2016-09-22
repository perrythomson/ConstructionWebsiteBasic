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
import workHours.entities.Employee;
import workHours.entities.EmployeeDAO;
import workHours.entities.JobSeeker;
import workHours.entities.JobSeekerDAO;
import workHours.entities.Admin;
import workHours.entities.AdminDAO;
import workHours.entities.RoleType;
import workHours.entities.JobSeeker;
import workHours.entities.JobSeekerDAO;


@Controller
@RequestMapping(value="/admin/")
public class AdminController {

    private final JobSeekerDAO jobSeekerDAO;
    private final AdminDAO adminDAO;                                     // DAO provide some specific data operations without exposing details of the database
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;
    private final EmployeeDAO employeeDAO;

//    private final UserDAO userDAO;
//    private final UserRoleDAO userRoleDAO;
//    private final PasswordEncoder passwordEncoder;


    public AdminController( AdminDAO adminDAO, JobSeekerDAO jobSeekerDAO, TimeSheetTrackerDAO timeSheetTrackerDAO, EmployeeDAO employeeDAO) {
        Assert.notNull(employeeDAO, "EmployeeDAO must not be null!");
        this.employeeDAO = employeeDAO;
        Assert.notNull(adminDAO, "AdminDAO must not be null!");
        this.adminDAO = adminDAO;
        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null!");  //Assert extends object validates method arguments...it will not be if you do not meet my criteria
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
        Assert.notNull(jobSeekerDAO, "JobSeekerDAO must not be null!");
        this.jobSeekerDAO = jobSeekerDAO;
    }

    @RequestMapping(value="/")    //Annotation for mapping web requests onto specific handler classes and/or handler methods
    public String allEmployees(ModelMap model) {
        Iterable<Employee> employees = employeeDAO.findAll();
        model.addAttribute("employees",employees);
        model.addAttribute("roleTypes", RoleType.values());

        Iterable<JobSeeker> jobSeekers = jobSeekerDAO.findAll();  //pulling information to the same home page need logic for all db objects
        model.addAttribute("jobSeekers", jobSeekers);
        return "admin/adminHomePage";
    }

    @RequestMapping(value="addNewEmployee")
    public String addNewEmployee(ModelMap model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("roleTypes", RoleType.values());
        return "admin/addNewEmployee";
    }

    @RequestMapping(value="deleteEmployee")
    public View deleteEmployee(Long id) {                       //this method is to delete question
        Employee employee = employeeDAO.findOne(id);
        employeeDAO.delete(employee);  //going to the dao, deleting that particular question
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="saveNewEmployee")
    public View saveNewEmployee(Employee user) {
        employeeDAO.save(user);
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="editEmployee")
    public String editEmployee(String employeeID,ModelMap model) {
//        System.out.println("Employee ID is: " + employeeID); //used for debugging
        Employee user = employeeDAO.findOne(Long.valueOf(employeeID));  //changes string empID to long
        model.addAttribute("employee",user);
        model.addAttribute("roleTypes", RoleType.values());
//        Admin admin = adminDAO.findOne(employeeID);
//        adminModel.addAttribute("admin",admin);
//        return "/admin/editEmployee";
        return "/admin/editEmployee";
    }
    @RequestMapping(value="saveEditedEmployee")
    public View saveEditedUser(Employee employee) {
        employeeDAO.save(employee);
        return new RedirectView("/admin/");
    }

    @RequestMapping("uploadEmployees")
    public String uploadEmployees() {       //passing string on to a jsp to view
        return "admin/uploadEmployees";
    }

    @RequestMapping("saveUploadedEmployees")
    public View saveUploadedEmployees(MultipartFile EmployeesFile) {
        String returnView = "";
        if (!EmployeesFile.isEmpty()) {
            try {
                String pathString = "/Users/perrythomson/UPLOADS_Capstone_Employees/";
                Files.write(Paths.get(pathString+EmployeesFile.getOriginalFilename()),EmployeesFile.getBytes());
                System.out.println("-------- File Upload Successful");
                addUploadToDatabase(pathString+EmployeesFile.getOriginalFilename()); //passing the file location which need to be the same as 2 lines above
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
            List<Employee> uploadedEmployees = mapper.readValue(Files.newInputStream(userUploadedFilePath), new TypeReference<List<Employee>>(){});
            for(Employee uploadedUser : uploadedEmployees) {  //creating new id's so that it doesn't barf and error
                Employee employee = new Employee();
                employee.setFirstName(uploadedUser.getFirstName());
                employee.setLastName(uploadedUser.getLastName());
                employee.setPhone(uploadedUser.getPhone());
                employee.setAddress(uploadedUser.getAddress());
                employee.setSalary(uploadedUser.getSalary());
                employeeDAO.save(employee);
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
    public View saveUploadedTimeSheet(MultipartFile TimeSheetsFile) {
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

//    //this routes from EDIT employee
//    @RequestMapping(value="viewEmployee")
//    public View viewEmployee(Long employeeID,ModelMap model, Long adminID, ModelMap adminModel) {
//        Employee employee = employeeDAO.findOne(employeeID);
//        model.addAttribute("employee",employee);
////        Admin admin = adminDAO.findOne(employeeID);
////        adminModel.addAttribute("admin",admin);
////        return "/admin/editEmployee";
//        return new RedirectView("/admin/editEmployee");
//    }