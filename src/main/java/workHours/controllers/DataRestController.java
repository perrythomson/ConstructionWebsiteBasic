package workHours.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workHours.entities.Employee;
import workHours.entities.EmployeeDAO;
import workHours.entities.TimeSheetTracker;
import workHours.entities.TimeSheetTrackerDAO;

/**
 * Created by perrythomson on 9/6/16.
 */
@RestController
@RequestMapping("/restData/")
public class DataRestController {


    private final EmployeeDAO employeeDAO;
    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

    @Autowired
    public DataRestController(EmployeeDAO employeeDAO, TimeSheetTrackerDAO timeSheetTrackerDAO) {
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
        Assert.notNull(timeSheetTrackerDAO, "timeSheetTrackerDAO must not be null!");

        this.employeeDAO = employeeDAO;
        Assert.notNull(employeeDAO, "EmployeeDAO must not be null!");

    }

    @RequestMapping("getAllEmployees")
    public Iterable<Employee> getAllEmployees() {  //Iterable stack of quiz questions from DAO
        return employeeDAO.findAll();
    }

    @RequestMapping("getAllTimeSheets")
    public Iterable<TimeSheetTracker> getAllTimeSheets() {
        return timeSheetTrackerDAO.findAll();
    }
}


