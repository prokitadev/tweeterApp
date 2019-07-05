package pl.tweeter.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/")
                .hasAnyAuthority("admin", "user", "moderator", "observer")
                .antMatchers("/users")
                .hasAnyAuthority("admin")
                .anyRequest().permitAll()
                .and().csrf().disable()
                .headers().frameOptions().disable()
                .and().formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/index")
                .and().logout().logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.login, u.password, 1 FROM t_users u where u.login=?")
                .authoritiesByUsernameQuery("SELECT u.login, u.role, 1 FROM t_users u where u.login=?")
                .dataSource(jdbcTemplate.getDataSource());
    }
}
