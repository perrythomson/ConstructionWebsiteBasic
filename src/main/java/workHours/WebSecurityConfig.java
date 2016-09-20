package workHours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/", "/home/*",  "/frontEndFiles/css/*", "/frontEndFiles/pictures/*").permitAll()
//                .antMatchers("/admin/*", "/employee/*")
//                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/default") //this routes to the defaultController to assess roleType
                .permitAll()
                .and()
                .logout().permitAll();
//        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("bob").password("pass").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("sally").password("pass").roles("EMPLOYEE");
    }


}