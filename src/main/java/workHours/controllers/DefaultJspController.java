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
import workHours.entities.User;
import workHours.entities.UserDAO;
import workHours.entities.UserRole;
import workHours.entities.UserRoleDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if(request.isUserInRole("ADMIN")) {
            return "redirect:/admin/";
        }
        return "redirect:/user/";
    }

    @RequestMapping(value="/addNewUser")
    public String addUser() {
        return "addUser";
    }

    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;
    private final PasswordEncoder passwordEncoder;

    public DefaultJspController(UserDAO userDAO, UserRoleDAO userRoleDAO, PasswordEncoder passwordEncoder) {
        Assert.notNull(userDAO, "UserDAO must not be null!");
        Assert.notNull(userRoleDAO, "UserRolesDAO must not be null!");
        Assert.notNull(passwordEncoder, "PasswordEncoder must not be null!");
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
        this.passwordEncoder = passwordEncoder;
    }
    @RequestMapping(value="/saveNewUser")
    public View saveUser(String username, String password, String email) {
        User user = new User(username,passwordEncoder.encode(password),1,email);
        userDAO.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserid(user.getUserId());
        userRole.setRole("USER");
        userRoleDAO.save(userRole);
        return new RedirectView("/securePage");
    }
}
