package workHours.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import workHours.entities.JobSeeker;
import workHours.entities.JobSeekerDAO;
import workHours.entities.TimeSheetTracker;
import workHours.entities.TimeSheetTrackerDAO;

/**
 * Created by perrythomson on 9/19/16.
 */
@Controller
public class TimeSheetTrackerController {

    private final TimeSheetTrackerDAO timeSheetTrackerDAO;

    public TimeSheetTrackerController(TimeSheetTrackerDAO timeSheetTrackerDAO) {
        Assert.notNull(timeSheetTrackerDAO, "TimeSheetTrackerDAO must not be null.");
        this.timeSheetTrackerDAO = timeSheetTrackerDAO;
    }

//    @RequestMapping(value="/user/employeeHomePage")
//    public String hoursWorked(ModelMap model) {
//        model.addAttribute("timeSheetTracker", new TimeSheetTracker());
//        return "employeeHomePage";
//    }

    @RequestMapping(value="/employee/employeeTimeSheet")
    public String saveNewTimeSheet(TimeSheetTracker timeSheetTracker){
        timeSheetTrackerDAO.save(timeSheetTracker);
        return "user/employeeHomePage";
    }

}
