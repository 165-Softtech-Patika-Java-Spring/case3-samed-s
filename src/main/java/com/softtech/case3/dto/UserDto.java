package com.softtech.case3.dto;

import com.softtech.case3.enums.UserType;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
    private String phoneNumber;
    private UserType userType;
}
