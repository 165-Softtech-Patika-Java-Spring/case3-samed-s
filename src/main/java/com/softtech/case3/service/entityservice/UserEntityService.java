package com.softtech.case3.service.entityservice;

import com.softtech.case3.dao.UserDao;
import com.softtech.case3.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {
    private final UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    /**
     * This method finds user by id with control.
     * If there is no user related to the id, an exception appears.
     */
    public User findByIdWithControl(Long id) {
        Optional<User> userOptional = findById(id);
        User user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
        }
        else {
            throw new RuntimeException("User not found!");
        }
        return user;
    }

    /**
     * This method finds user by username with control.
     * If there is no user related to the username, an exception appears.
     */
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        if(user == null) {
            throw new RuntimeException("User not found!");
        }
        return user;
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public User findByUsernameAndPhoneNumber(String username, String phoneNumber) {
        return userDao.findByUsernameAndPhoneNumber(username, phoneNumber);
    }

    public void delete(User user) {
        userDao.delete(user);
    }
}
