package com.raj.SpringSrc.Repo;

import com.raj.SpringSrc.Model.Student;
import com.raj.SpringSrc.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUserName(String userName);
}
