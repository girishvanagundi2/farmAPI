package com.FarmCollector.farmAPI.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter

public class Planted {
    private Long ID;
    private String farmID;
    private String farmerFirstName;
    private String farmerLastName;
    private int area;
    private String corpType;
    private int expectedQuantity;
    private String season;


}
