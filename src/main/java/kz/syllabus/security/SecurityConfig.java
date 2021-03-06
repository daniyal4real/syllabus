package kz.syllabus.security;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
@NoArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/dean/**").hasRole("DEAN")
                .antMatchers("/api/teacher/**").hasRole("TEACHER")
                .antMatchers("/api/student/**").hasRole("STUDENT")
                .antMatchers("/api/teacher/syllabuses").hasRole("TEACHER")
                .antMatchers("/api/auth/**","api/register/**").permitAll()
                .antMatchers("/api/create/syllabus/disciplineinfo").hasRole("TEACHER")
                .antMatchers("/api/create/syllabus").hasRole("TEACHER")
                .antMatchers("/api","/api/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
