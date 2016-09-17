package workHours.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import workHours.entities.JobSeeker;
import workHours.entities.JobSeekerDAO;

/**
 * Created by perrythomson on 9/16/16.
 */
@Controller
public class JobSeekerController {

    private final JobSeekerDAO jobSeekerDAO;

    public JobSeekerController(JobSeekerDAO jobSeekerDAO) {
        Assert.notNull(jobSeekerDAO, "JobSeekerDAO must not be null.");
        this.jobSeekerDAO = jobSeekerDAO;
    }

    @RequestMapping(value="/home/employmentOpportunities")
    public String employmentOpportunities(ModelMap model) {
        model.addAttribute("jobSeeker", new JobSeeker());
        return "home/employmentOpportunities";
    }

    @RequestMapping(value="/home/jobSeeker")
    public String saveNewJobSeeker(JobSeeker jobSeeker) {
        jobSeekerDAO.save(jobSeeker);
        return "/home/thankYou";
    }

}
