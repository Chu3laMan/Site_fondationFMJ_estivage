package org.baeldung.spring;

import org.baeldung.persistence.dao.UserRepository;
import org.baeldung.security.CustomRememberMeServices;
import org.baeldung.security.google2fa.CustomAuthenticationProvider;
import org.baeldung.security.google2fa.CustomWebAuthenticationDetailsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configuration
@ComponentScan(basePackages = { "org.baeldung.security" })
 //@ImportResource({ "classpath:webSecurityConfig.xml" })
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${extern.resources.Dir}")
	private String resourceDir;
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private LogoutSuccessHandler myLogoutSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private CustomWebAuthenticationDetailsSource authenticationDetailsSource;

    @Autowired
    private UserRepository userRepository;

    public SecSecurityConfig() {
        super();
    }

    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**","/webjars/**",
        		"/email_templates/**",
                "/resources/**",
                "/img/**",
                "/contactform/**",
                "/font/**",
                "/ico/**",
                "/css/**",
                "/images/**",
                "/docs/**",
                "/fonts/**",
                "/vendor/**",
                "/video/**",
                "/css1/**",
                "/vendor/**",
                "/img1/**",
                "/font-awesome/**",
                "/scss/**",
                "/js1/**",
                "/skins/**","/Admin/**","/css1/**","/plugins/**","/patterns/**",
                "/js/**","/api/**","/plugins","/"+resourceDir+"/**"
                );
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
       http
            .csrf().disable()
                .authorizeRequests()
                .antMatchers("/Admin/**").hasAuthority("WRITE_PRIVILEGE")
                ///.anyRequest().authenticated() 
                .antMatchers("/","/expiredAccount1*","/icons*","/icon-variations*","/animations*","/typography*","/components*","/table*","/index-alt3*","/index-alt2*","/","/404*","/testimonials*","/pricingbox*","/index-alt2*","/index*","/index","/login*","/login*", "/logout*", "/signin/**", "/signup/**", "/customLogin",
                		"/access-denied*","/post-right-sidebar*","/post-left-sidebar*","/blog-right-sidebar*","/blog-left-sidebar*","/contact*","/portfolio-detail*","/portfolio-4cols*","/portfolio-3cols*","/portfolio-2cols*","/testimonials*","/pricingbox*","/about*","/user/registration*", "/registrationConfirm*", "/expiredAccount*", "/registration*",
                        "/badUser*", "/user/resendRegistrationToken*" ,"/forgetPassword*", "/user/resetPassword*",
                        "/user/changePassword*", "/emailError*", "/resources/**","/resources/static/**","/resources/static/Admin**","/old/user/registration*","/successRegister*","/qrcode*","/webjars/**").permitAll()
                ///.antMatchers("/home.html").anonymous()///invalidSession*
                .antMatchers("/home.html","/3omra.html","/about.html","/akhbar.html",
                		"/assurances.html","/bourse.html","/centre-été.html",
                		"/contact.html","/divertissement1.html","/fondation-is.html",
                		"/fondation-ma.html","/fondation-na.html","/fondation-vm.html",
                		"/galerie_photos.html","/galerie_photos/getImages/**","/hebergem.html","/idara1.html",
                		"/idara2.html","/idara3.html","/press1.html","/publication1.html",
                		"/publication2.html","/publication3.html","/publication4.html","/addChikaya",
                		"/publication5.html","/préts1.html","/santé.html","/transport1.html","/videos.html","/addContact").permitAll()///added           
                
                .antMatchers("/resources/static/Admin/js1/api/**","/index").access("hasRole('ADMIN')")///added
                .antMatchers("/user/updatePassword*","/user/savePassword*","/updatePassword*","/changePassword*","/console*").hasAuthority("CHANGE_PASSWORD_PRIVILEGE")
                .anyRequest().hasAuthority("READ_PRIVILEGE")
                ///.antMatchers(HttpMethod.POST, "/addContact").permitAll().anyRequest().anonymous()/// added
                ///.antMatchers(HttpMethod.POST, "/addChikaya").permitAll().anyRequest().anonymous()///added
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/Admin/index")
                .failureUrl("/login?error=true")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .authenticationDetailsSource(authenticationDetailsSource)
            .permitAll()
                .and()
            .sessionManagement()
                .invalidSessionUrl("/invalidSession.html")
                .maximumSessions(1).sessionRegistry(sessionRegistry()).and()
                .sessionFixation().none()
            .and()
            .logout()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .invalidateHttpSession(false)
                .logoutSuccessUrl("/logout.html?logSucc=true")
                .deleteCookies("JSESSIONID")
                .permitAll()
             .and()
                .rememberMe().rememberMeServices(rememberMeServices()).key("theKey");
             
    // @formatter:on 
    }

    // beans

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final CustomAuthenticationProvider authProvider = new CustomAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        CustomRememberMeServices rememberMeServices = new CustomRememberMeServices("theKey", userDetailsService, new InMemoryTokenRepositoryImpl());
        return rememberMeServices;
    }
}