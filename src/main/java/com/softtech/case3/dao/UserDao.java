package com.softtech.case3.dao;

import com.softtech.case3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameAndPhoneNumber(String username, String phoneNumber);


}
