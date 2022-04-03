package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class Address {
    private Long addrId;

    private Long addrUserId;

    private String addrInfo;

    private Date gmtCreate;

    private Date gmtModified;

}