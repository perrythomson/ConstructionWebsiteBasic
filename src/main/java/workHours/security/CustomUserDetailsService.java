package workHours.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import workHours.entities.User;
import workHours.entities.UserDAO;
import workHours.entities.UserRoleDAO;


import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDAO userDAO;
    private final UserRoleDAO userRoleDAO;

    @Autowired
    public CustomUserDetailsService(UserDAO userDAO, UserRoleDAO userRoleDAO) {
        this.userDAO = userDAO;
        this.userRoleDAO = userRoleDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userDAO.findByUserName(username);
        if(null == user){
            throw new UsernameNotFoundException("No user present with username: "+username);
        }else{
            List<String> userRoles= userRoleDAO.findRoleByUserName(username);
            return new CustomUserDetails(user,userRoles);
        }
    }


}