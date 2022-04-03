package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class User {
    private Long userId;

    private String userPhone;

    private String userName;

    private String userPassword;

    private String userInfo;

    private Byte userRole;

    private Date gmtCreate;

    private Date gmtModified;

}