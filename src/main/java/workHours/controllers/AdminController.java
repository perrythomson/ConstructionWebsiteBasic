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
import java.util.HashSet;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import workHours.entities.User;
import workHours.entities.UserDAO;
import workHours.entities.JobSeeker;
import workHours.entities.JobSeekerDAO;
import workHours.entities.AdminDAO;
import workHours.entities.RoleType;
//import workHours.entities.RoleTypeDAO;
import workHours.entities.InterestedParty;
import workHours.entities.InterestedPartyDAO;


    @Controller
    @RequestMapping(value = "/admin/")
    public class AdminController {

        private final JobSeekerDAO jobSeekerDAO;
        private final AdminDAO adminDAO;                                     // DAO provide some specific data operations without exposing details of the database
        private final TimeSheetTrackerDAO timeSheetTrackerDAO;
        private final UserDAO userDAO;
        private final PasswordEncoder passwordEncoder;
        private final UserRoleDAO userRoleDAO;
        private final InterestedPartyDAO interestedPartyDAO;


        public AdminController( InterestedPartyDAO interestedPartyDAO, UserRoleDAO userRoleDAO, PasswordEncoder passwordEncoder, AdminDAO adminDAO, JobSeekerDAO jobSeekerDAO, TimeSheetTrackerDAO timeSheetTrackerDAO, UserDAO userDAO) {
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

        @RequestMapping(value = "/")
        //Annotation for mapping web requests onto specific handler classes and/or handler methods
        public String allUsers(ModelMap model) {
            Iterable<User> users = userDAO.findAll();
            model.addAttribute("users", users);


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


        @RequestMapping(value = "viewAllUsers")
        public String allEmployees(ModelMap model) {
            Iterable<User> users = userDAO.findAll();
            model.addAttribute("users", users);


            return "admin/viewAllUsers";
        }

        @RequestMapping(value = "deleteUser")
        public View deleteUser(Long id) {
            User user = userDAO.findOne(id);
            userDAO.delete(user);


            return new RedirectView("/admin/");
        }


        //Update/Edit Contact Info Admin Side
        @RequestMapping(value = "editUser")
        public String editUser(String RoleT, String userId, ModelMap model) {
//        System.out.println("User ID is: " + userId); //used for debugging
            User user = userDAO.findOne(Long.valueOf(userId));  //changes string empID to long
            model.addAttribute("user", user);
            model.addAttribute("roleTypes", RoleType.values());


            return "/admin/editUser";
        }

        @RequestMapping(value = "saveEditedUser")
        public View saveEditedUser(User user, RoleType roleType) {
            HashSet<RoleType> newRoles = new HashSet<RoleType>();
            newRoles.add(roleType);
            user.setRoles(newRoles);
            userDAO.save(user);

            return new RedirectView("/admin/");
        }


        //Initial Add New User - HomePage
        @RequestMapping(value = "addNewUser")
        public String addUser(ModelMap model) {
            model.addAttribute("roleTypes", RoleType.values());
            return "addUser";
        }

        @RequestMapping(value = "saveNewUser")
        public View saveUser(String username, String password, String email, String firstName, String lastName, String phone, String address, double salary, RoleType roleType) {

            User user = new User(username, passwordEncoder.encode(password), 1, email, firstName, lastName, phone, address, salary, roleType);
            userDAO.save(user);

//            UserRole userRole = new UserRole();
//            userRole.setUserid(user.getUserId());
//            userRole.setRole("USER");
//            userRoleDAO.save(userRole);




            return new RedirectView("/admin/");
        }
    }
