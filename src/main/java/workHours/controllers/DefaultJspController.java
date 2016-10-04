package workHours.controllers;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import workHours.entities.*;
import workHours.security.CustomUserDetails;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Timestamp;

@Controller
public class DefaultJspController {

//    @RequestMapping(value="/")
//    public String homePage() {
//        return "index";
//    }

    @RequestMapping(value="/")
    public String homePage() {
        return "home/homePage";
    }


    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        request.setAttribute("logout","logout");
        return "home/homePage";
    }

    //this handles the role Type can put in foreman later
//    @RequestMapping("/default")
//    public String defaultAfterLogin(HttpServletRequest request) {
//        if(request.isUserInRole("ADMIN")) {
//            return "redirect:/admin/";
//        }
//        return "redirect:/user/";
//    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
        if(user.getRoles().contains(RoleType.ADMIN)) {
            return "redirect:/admin/";
        }
        if(user.getRoles().contains(RoleType.EMPLOYEE)) {
            return "redirect:/user/userHomePage";
        }
        return "home/homePage";
    }

//    @RequestMapping(value="/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        request.setAttribute("logout","logout");
//        return "login";
//    }

}
