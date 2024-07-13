package com.raj.SpringSrc.Service;

import com.raj.SpringSrc.Model.Student;
import com.raj.SpringSrc.Model.User;
import com.raj.SpringSrc.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepo repo;


    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    public User getUserByName(String userName){
        return repo.findByUserName(userName);
    }

    public User save(User user) {
        user.setUserPass(bCryptPasswordEncoder.encode(user.getUserPass()));
        return repo.save(user);
    }
}
