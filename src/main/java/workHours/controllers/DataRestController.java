package workHours.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import workHours.entities.Employee;
//import workHours.entities.EmployeeDAO;
import workHours.entities.TimeSheetTracker;
import workHours.entities.TimeSheetTrackerDAO;
import workHours.entities.UserDAO;

/**
 * Created by perrythomson on 9/6/16.
 */
@RestController
@RequestMapping("/restData/")
public class DataRestController {


    private final UserDAO userDAO;
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

    @Autowired
    public DataRestController(UserDAO userDAO, TimeSheetTrackerDAO timeSheetTrackerDAO) {
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
        Assert.notNull(timeSheetTrackerDAO, "timeSheetTrackerDAO must not be null!");

        this.userDAO = userDAO;
        Assert.notNull(userDAO, "UserDAO must not be null!");

    }

    @RequestMapping("getAllUsers")
    public Iterable<workHours.entities.User> getAllUsers() {  //Iterable stack of quiz questions from DAO
        return userDAO.findAll();
    }

    @RequestMapping("getAllTimeSheets")
    public Iterable<TimeSheetTracker> getAllTimeSheets() {
        return timeSheetTrackerDAO.findAll();
    }
}


