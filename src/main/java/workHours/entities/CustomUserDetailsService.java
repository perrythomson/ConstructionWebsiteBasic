package workHours.entities;


import core.entities.User;
import core.entities.UserDAO;
import core.entities.UserRolesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDAO userDAO;
    private final UserRolesDAO userRolesDAO;

    @Autowired
    public CustomUserDetailsService(UserDAO userDAO, UserRolesDAO userRolesDAO) {
        this.userDAO = userDAO;
        this.userRolesDAO = userRolesDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userDAO.findByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            List<String> userRoles= userRolesDAO.findRoleByUserName(username);
            return new CustomUserDetails(user,userRoles);
        }
    }
}
