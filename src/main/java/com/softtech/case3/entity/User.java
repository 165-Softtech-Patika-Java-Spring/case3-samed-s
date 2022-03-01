package com.softtech.case3.entity;

import com.softtech.case3.enums.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class User {

    @Id
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User")
    private Long id;

    @Column(name = "USERNAME", length = 100, unique = true)
    private String username;

    @Column(name = "EMAIL", length = 150, unique = true)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 20, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 30)
    private UserType userType;

}
