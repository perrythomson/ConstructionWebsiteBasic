package workHours.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import workHours.entities.Employee;
import workHours.entities.EmployeeDAO;
import workHours.entities.TimeSheetTrackerDAO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping(value="/admin/")
public class AdminController {

    private final EmployeeDAO employeeDAO;  //DAO is an object that provides an abstract interface to some type of database or other persistence mechanism. By mapping application calls to the persistence layer,
                                            // DAO provide some specific data operations without exposing details of the database
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

    @Autowired
    //marks a constructor, field, setter method or config  to be autowired by springs dependency injection
    public AdminController(EmployeeDAO employeeDAO, TimeSheetTrackerDAO timeSheetTrackerDAO) {
        Assert.notNull(employeeDAO, "EmployeeDAO must not be null!");  //Assert extends object validates method arguments
        this.employeeDAO = employeeDAO;
        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null!");  //Assert extends object validates method arguments...it will not be if you do not meet my criteria
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
    }

    @RequestMapping(value="/")    //Annotation for mapping web requests onto specific handler classes and/or handler methods
    public String allEmployees(ModelMap model) {
        Iterable<Employee> employeess = employeeDAO.findAll();
        model.addAttribute("employees",employeess);
        return "admin/viewAllEmployees";
    }

    @RequestMapping(value="addNewEmployee")
    public String addNewEmployee(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "admin/addNewEmployee";
    }

    @RequestMapping(value="saveNewEmployee")
    public String saveNewEmployee(Employee employee) {
        employeeDAO.save(employee);
        return "/admin/";
    }

    @RequestMapping(value="viewEmployee")                   //TODO can edit too
    public String viewEmployee(long id,ModelMap model) {
        Employee employee = employeeDAO.findOne(id);
        model.addAttribute("employee",employee);  //(Object attributeValue)
        return "admin/editEmployee";
    }

    @RequestMapping(value="deleteEmployee")
    public View deleteEmployee(long id) {                       //this method is to delete question
        Employee employee = employeeDAO.findOne(id);
        employeeDAO.delete(employee);  //going to the dao, deleting that particular question
        return new RedirectView("/admin/");
    }

    @RequestMapping(value="saveEditedEmployee")
    public View saveEditedEmployee(Employee employee) {
        employeeDAO.save(employee);
        return new RedirectView("/admin/");
    }

    @RequestMapping("uploadEmployees")         //jsp needs to be created TODO
    public String uploadEmployees() {       //passing string on to a jsp to view
        return "admin/uploadEmployees";
    }

    @RequestMapping("saveUploadedEmployees")
    public View saveUploadedEmployees(MultipartFile EmployeesFile) {  //multipartfile is one of the types of things I can pass from the method
        //can be a json file or image, etc, anything that has its own stuff
        //TODO research View from signature
        String returnView = "";
        if (!EmployeesFile.isEmpty()) {
            try {//(below) get current file name...get contents
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

}

