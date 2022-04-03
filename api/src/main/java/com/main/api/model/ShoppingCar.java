package com.main.api.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class ShoppingCar {
    private Long carId;

    private Long carUserId;

    private Long carCommId;

    private Integer carCommNumber;

    private Date gmtCreate;

    private Date gmtModified;

}