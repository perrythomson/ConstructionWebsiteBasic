package workHours.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import workHours.entities.EmployeeDAO;
import workHours.entities.TimeSheetTracker;
import workHours.entities.TimeSheetTrackerDAO;

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

    @RequestMapping(value="/")
    public String defaultPage(ModelMap model) {
        return timeEntry(model);
    }


    @RequestMapping(value="timeEntry")
    public String timeEntry(ModelMap model) {
        return "employee/employeeTimeEntry";
        }

    @RequestMapping(value="updateContactInfo")
    public String updateContactInfo(ModelMap model) {
        return updateContactInfo(model);
    }
}
