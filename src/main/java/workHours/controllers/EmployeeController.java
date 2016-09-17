package workHours.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import workHours.entities.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by perrythomson on 9/1/16.
 */

@Controller
@RequestMapping(value="/employee/")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO, TimeSheetTrackerDAO timeSheetTrackerDAO) {
        Assert.notNull(employeeDAO, "EmployeeDAO must not be null!");
        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null!");

        this.employeeDAO = employeeDAO;
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
    }

//    TODO understand mapping and code to get info from db for signin person
    @RequestMapping(value="/")
    public String defaultPage(ModelMap model) {
        return timeEntry(model);
    }

    @RequestMapping(value="employeeHomePage")
    public String timeEntry(ModelMap model) {
        return "employee/employeeHomePage";
        }

//    @RequestMapping(value="editEmployeeContactInfo")
//    public String editEmployeeContactInformation(ModelMap model) {
//        return editEmployeeContactInformation(model);
//    }

    @RequestMapping(value="editEmployeeContactInfo")
    public String editEmployee(String employeeID,ModelMap model) {
        System.out.println("Employee ID is: " + employeeID);
        Employee employee = employeeDAO.findOne(Long.valueOf(employeeID));  //changes string empID to long
        model.addAttribute("employee",employee);
        model.addAttribute("roleTypes", RoleType.values());
//        Admin admin = adminDAO.findOne(employeeID);
//        adminModel.addAttribute("admin",admin);
//        return "/admin/editEmployee";   //TODO find out why I cannot retrieve username password upon addition of new employee
        return "/employee/editEmployeeContactInfo";
    }

    @RequestMapping(value="employeeContactInfo")
    public String viewContactInfo(ModelMap model) {
        return viewContactInfo(model);
    }

    @RequestMapping(value = "updateEmployee")
    public String updateEmployee(ModelMap model) {
        return "/employee/";
    }
}
