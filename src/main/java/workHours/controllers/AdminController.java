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

@Controller
@RequestMapping(value="/admin/")
public class AdminController {

    private final JobSeekerDAO jobSeekerDAO;
    private final EmployeeDAO employeeDAO;  //DAO is an object that provides an abstract interface to some type of database or other persistence mechanism. By mapping application calls to the persistence layer,
    private final AdminDAO adminDAO;                                     // DAO provide some specific data operations without exposing details of the database
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

//    @Autowired  //could be destroying my constructor only used to bring in beans
    //marks a constructor, field, setter method or config  to be autowired by springs dependency injection
    public AdminController(EmployeeDAO employeeDAO, AdminDAO adminDAO, JobSeekerDAO jobSeekerDAO, TimeSheetTrackerDAO timeSheetTrackerDAO) {
        Assert.notNull(adminDAO, "AdminDAO must not be null!");
        this.adminDAO = adminDAO;
        Assert.notNull(employeeDAO, "EmployeeDAO must not be null!");  //Assert extends object validates method arguments
        this.employeeDAO = employeeDAO;
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

    @RequestMapping(value="saveNewEmployee")
    public View saveNewEmployee(Employee employee) {
        employeeDAO.save(employee);
        return new RedirectView("/admin/");
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

    @RequestMapping(value="editEmployee")
    public String editEmployee(String employeeID,ModelMap model) {
//        System.out.println("Employee ID is: " + employeeID); //used for debugging
        Employee employee = employeeDAO.findOne(Long.valueOf(employeeID));  //changes string empID to long
        model.addAttribute("employee",employee);
        model.addAttribute("roleTypes", RoleType.values());
//        Admin admin = adminDAO.findOne(employeeID);
//        adminModel.addAttribute("admin",admin);
//        return "/admin/editEmployee";   //TODO find out why I cannot retrieve username password upon addition of new employee
        return "/admin/editEmployee";
    }

    @RequestMapping(value="deleteEmployee")
    public View deleteEmployee(Long id) {                       //this method is to delete question
        Employee employee = employeeDAO.findOne(id);
        employeeDAO.delete(employee);  //going to the dao, deleting that particular question
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="saveEditedEmployee")
    public View saveEditedEmployee(Employee employee) {
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
                String pathString = "/Users/perrythomson/UPLOADS_Capstone_Employees/"; //TODO create string for the try statement
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
            Path employeeUploadedFilePath = Paths.get(filePath);
            ObjectMapper mapper = new ObjectMapper();  //map json to entities
            List<Employee> uploadedEmployees = mapper.readValue(Files.newInputStream(employeeUploadedFilePath), new TypeReference<List<Employee>>(){});
            for(Employee uploadedEmployee : uploadedEmployees) {  //creating new id's so that it doesn't barf and error
                Employee employee = new Employee();
                employee.setFirstName(uploadedEmployee.getFirstName());
                employee.setLastName(uploadedEmployee.getLastName());
                employee.setPhone(uploadedEmployee.getPhone());
                employee.setAddress(uploadedEmployee.getAddress());
                employee.setSalary(uploadedEmployee.getSalary());
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

