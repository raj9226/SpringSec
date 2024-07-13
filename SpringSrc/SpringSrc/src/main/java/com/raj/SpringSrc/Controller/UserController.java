package com.raj.SpringSrc.Controller;

import com.raj.SpringSrc.Model.User;
import com.raj.SpringSrc.Service.JwtService;
import com.raj.SpringSrc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService sev;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("register")
    public User register(@RequestBody User user){

        return  sev.save(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(),user.getUserPass()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUserName());
        else
            return "failed";
    }
}
