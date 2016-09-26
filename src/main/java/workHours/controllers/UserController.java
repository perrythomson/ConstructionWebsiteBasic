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
@RequestMapping(value="/user/")
public class UserController {

    private final UserDAO userDAO;
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

    @Autowired
    public UserController(UserDAO userDAO, TimeSheetTrackerDAO timeSheetTrackerDAO) {
        Assert.notNull(userDAO, "UserDAO must not be null!");
        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null!");

        this.userDAO = userDAO;
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
    }
    @RequestMapping(value="/")
    public String defaultPage(ModelMap model) {
        return "user/userHomePage";
    }
    //TODO This method prevents userHomePage from working error 500
//    @RequestMapping(value="/")
//    public String userHomePage(String userId, ModelMap model) {
//        User user = userDAO.findOne(Long.valueOf(userId));  //this is going to have username/password info rather than find by empID
//        model.addAttribute("user",user);
//        model.addAttribute("roleTypes", RoleType.values());
//
//        Iterable<TimeSheetTracker> timeSheetTrackers = timeSheetTrackerDAO.findAll();
//        model.addAttribute("timeSheetTrackers", timeSheetTrackers);
//        return "user/userHomePage";
//    }

    @RequestMapping(value="viewAllCoworkers")
    public String allUsers(ModelMap model) {
        Iterable<User> users = userDAO.findAll();
        model.addAttribute("users", users);
        model.addAttribute("roleTypes", RoleType.values());

        return "user/viewAllCoworkers";
    }

    @RequestMapping(value="userHomePage")
    public String timeEntry(ModelMap model) {
        return "user/userHomePage";
        }



    @RequestMapping(value="editUserContactInfo")
    public String editUser(String userId,ModelMap model) {
//        System.out.println("User ID is: " + userId);
        User user = userDAO.findOne(Long.valueOf(userId));  //changes string empID to long
        model.addAttribute("user",user);
        model.addAttribute("roleTypes", RoleType.values());
//        Admin admin = adminDAO.findOne(userId);
//        adminModel.addAttribute("admin",admin);
//        return "/admin/editUser";
        return "/user/editUserContactInfo";
    }

    @RequestMapping(value="userContactInfo")
    public String viewContactInfo(ModelMap model) {
        return viewContactInfo(model);
    }

    @RequestMapping(value = "updateUser")
    public String updateUser(ModelMap model) {
        return "/user/";
    }
}
