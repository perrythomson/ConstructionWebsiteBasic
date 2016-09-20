package workHours.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import workHours.entities.UserDAO;
import workHours.entities.UserRolesDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Timestamp;

/**
 * Created by perrythomson on 9/6/16.
 */
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

//    @RequestMapping(value="/")
//    public View jspHomePage() {
//        return new RedirectView("/home/homePage");
//    }

//    @RequestMapping(value="/")
//    String homePage() {
//        return "home/homePage";
//    }

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
        return "redirect:/employee/";
    }



//[12:40]
    private final PasswordEncoder passwordEncoder;

//[1:43]
    public RegisterController(AccountDAO accountDAO, ApiKeyDAO apiKeyDAO, UserDAO userDAO, UserRolesDAO userRolesDAO, PasswordEncoder passwordEncoder) {
        Assert.notNull(accountDAO, "AccountDAO must not be null!");
        Assert.notNull(apiKeyDAO, "ApiKeyDAO must not be null!");
        Assert.notNull(userDAO, "UserRepository must not be null!");
        Assert.notNull(userRolesDAO, "UserRolesRepository must not be null!");
        Assert.notNull(passwordEncoder, "PasswordEncoder must not be null!");
        this.accountDAO = accountDAO;
        this.apiKeyDAO = apiKeyDAO;
        this.userDAO = userDAO;
        this.userRolesDAO = userRolesDAO;
        this.passwordEncoder = passwordEncoder;
    }

//[1:44]
    private void createAccount(String accountName, Account.Type accountType, String userName, String password, String email) {
        Account account = new Account();
        account.setName(accountName);
        account.setType(accountType);
        account.setActive(true);
        account.setCreated(new Timestamp(System.currentTimeMillis()));
        accountDAO.save(account);
        ApiKey apiKey = new ApiKey();
        apiKey.setAccountId(account.getId());
        apiKey.setApiKey(GenerateAPIKey.generateSafeKey(apiKeyDAO,accountName));
        if(accountType == Account.Type.SYSTEM_ADMIN) {
            apiKey.setSystemAdmin(true);
        } else {
            apiKey.setSystemAdmin(false);
        }
        apiKey.setActive(true);
        apiKey.setCreated(new Timestamp(System.currentTimeMillis()));
        apiKeyDAO.save(apiKey);
        User user = new User();
        user.setAccountId(account.getId());
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setEnabled(1);
        user.setEmailVerified(false);
        user.setCreated(new Timestamp(System.currentTimeMillis()));
        userDAO.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserid(user.getUserid());
        if(accountType == Account.Type.SYSTEM_ADMIN) {
            userRole.setRole("SYSTEM_ADMIN");
        } else {
            userRole.setRole("ACCOUNT_ADMIN");
        }
        userRolesDAO.save(userRole);
    }

//[1:44]
    @RequestMapping(value = "/register")
    public String register(String accountName, String userName, String password, String email) {
        // TODO: Validate
        // TODO: check account name
        // TODO: check email
        // TODO: check password rules
        createAccount(accountName,Account.Type.CLIENT,userName,password,email);
        return "portal";
    }
}
