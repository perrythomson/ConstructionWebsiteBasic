package workHours.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by perrythomson on 9/6/16.
 */
@Controller
@RequestMapping(value="/home/")
public class HomeController {

//    @RequestMapping(value="/")
//    public String index() {
//        return "index";
//    }

     @RequestMapping(value="/")
     public String homePage(ModelMap model) {
            return "home/homePage";
     }

     @RequestMapping(value="/contactUs")
     public String contactUs(ModelMap model) {
            return "home/contactUs";
     }

     @RequestMapping(value="/employmentOpportunities")
     public String employmentOpportunities() {
         return "home/employmentOpportunities";
     }

     @RequestMapping(value="/pastProjects")
     public String pastProjects() {
        return "home/pastProjects";
     }
}
