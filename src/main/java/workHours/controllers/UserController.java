//package workHours.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.method.P;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.util.Assert;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.View;
//import workHours.entities.*;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by perrythomson on 9/1/16.
// */
//
//@Controller
//@RequestMapping(value="/employee/")
//public class UserController {
//
//    private final UserDAO userDAO;
//    private final TimeSheetTrackerDAO timeSheetTrackerDAO;
//
//    @Autowired
//    public UserController(UserDAO userDAO, TimeSheetTrackerDAO timeSheetTrackerDAO) {
//        Assert.notNull(userDAO, "UserDAO must not be null!");
//        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null!");
//
//        this.userDAO = userDAO;
//        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
//    }
//    @RequestMapping(value="/")
//    public String defaultPage(ModelMap model) {
//        return "employee/userHomePage";
//    }
//    //TODO This method prevents employeeHomePage from working error 500
////    @RequestMapping(value="/")
////    public String employeeHomePage(String employeeID, ModelMap model) {
////        Employee employee = employeeDAO.findOne(Long.valueOf(employeeID));  //this is going to have username/password info rather than find by empID
////        model.addAttribute("employee",employee);
////        model.addAttribute("roleTypes", RoleType.values());
////
////        Iterable<TimeSheetTracker> timeSheetTrackers = timeSheetTrackerDAO.findAll();
////        model.addAttribute("timeSheetTrackers", timeSheetTrackers);
////        return "employee/employeeHomePage";
////    }
//
//    @RequestMapping(value="viewAllCoworkers")
//    public String allUsers(ModelMap model) {
//        Iterable<User> users = userDAO.findAll();
//        model.addAttribute("users", users);
//        model.addAttribute("roleTypes", RoleType.values());
//
//        return "employee/viewAllCoworkers";
//    }
//
//    @RequestMapping(value="userHomePage")
//    public String timeEntry(ModelMap model) {
//        return "employee/userHomePage";
//        }
//
//
//
//    @RequestMapping(value="editUserContactInfo")
//    public String editUser(String userid,ModelMap model) {
//        System.out.println("User ID is: " + userid);
//        User employee = userDAO.findOne(Long.valueOf(userid));  //changes string empID to long
//        model.addAttribute("employee",employee);
//        model.addAttribute("roleTypes", RoleType.values());
////        Admin admin = adminDAO.findOne(employeeID);
////        adminModel.addAttribute("admin",admin);
////        return "/admin/editEmployee";
//        return "/employee/editUserContactInfo";
//    }
//
//    @RequestMapping(value="userContactInfo")
//    public String viewContactInfo(ModelMap model) {
//        return viewContactInfo(model);
//    }
//
//    @RequestMapping(value = "updateUser")
//    public String updateEmployee(ModelMap model) {
//        return "/employee/";
//    }
//}
