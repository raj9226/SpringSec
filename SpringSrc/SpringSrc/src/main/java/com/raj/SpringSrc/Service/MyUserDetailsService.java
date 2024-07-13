package com.raj.SpringSrc.Service;

import com.raj.SpringSrc.Model.User;
import com.raj.SpringSrc.Model.UserServicePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService ser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=ser.getUserByName(username);
        if(user==null){
            System.out.println("response 404 !!");
            throw new UsernameNotFoundException("user not found");
        }
        UserDetails userDetails=new UserServicePrincipal(user);


        return userDetails;

    }
}
