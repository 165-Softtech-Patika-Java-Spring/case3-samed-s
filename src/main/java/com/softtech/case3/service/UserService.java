package com.softtech.case3.service;

import com.softtech.case3.converter.UserMapper;
import com.softtech.case3.dto.UserDto;
import com.softtech.case3.entity.User;
import com.softtech.case3.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityService userEntityService;

    public List<UserDto> findAll() {
        List<User> userList = userEntityService.findAll();
        List<UserDto> userDtoList = UserMapper.INSTANCE.convertToUserDtoList(userList);
        return userDtoList;
    }

    public UserDto findById(Long id) {
        User user = userEntityService.findByIdWithControl(id);
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
        return userDto;
    }

    /**
     * This method finds user by username with control.
     * If there is no user related to the username, an exception appears.
     */
    public UserDto findByUsername(String username) {
        User user = userEntityService.findByUsername(username);
        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);
        return userDto;
    }

    public UserDto save(UserDto userDto) {
        User user = UserMapper.INSTANCE.convertToUser(userDto);
        user = userEntityService.save(user);
        UserDto resultUserDto = UserMapper.INSTANCE.convertToUserDto(user);
        return resultUserDto;
    }

    public UserDto update(Long id, UserDto userDto) {
        User user = userEntityService.findByIdWithControl(id);
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUserType(userDto.getUserType());

        user = userEntityService.save(user);

        UserDto resultUserDto = UserMapper.INSTANCE.convertToUserDto(user);
        return resultUserDto;
    }

    public String delete(String username, String phoneNumber) {
        User user = userEntityService.findByUsernameAndPhoneNumber(username, phoneNumber);
        if (user == null) {
            return "Username " + username + " and phone number " + phoneNumber + " do not match!";
        }
        userEntityService.delete(user);
        return String.valueOf(Void.TYPE);
    }
}
