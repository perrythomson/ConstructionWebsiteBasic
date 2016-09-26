package workHours.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import workHours.entities.InterestedParty;
import workHours.entities.InterestedPartyDAO;

@Controller
public class InterestedPartyController {

    private final InterestedPartyDAO interestedPartyDAO;

    public InterestedPartyController(InterestedPartyDAO interestedPartyDAO){
        Assert.notNull(interestedPartyDAO, "InterestedPartyDAO must not be null.");
        this.interestedPartyDAO = interestedPartyDAO;
    }

    @RequestMapping(value="/home/contactUs")
    public String contactUs(ModelMap model) {
        model.addAttribute("interestedParty", new InterestedParty());
        return "home/contactUs";
    }

    @RequestMapping(value="/home/interestedParty")
    public String saveNewInterestedParty(InterestedParty interestedParty) {
        interestedPartyDAO.save(interestedParty);
        return "/home/thankYou";
    }
}
