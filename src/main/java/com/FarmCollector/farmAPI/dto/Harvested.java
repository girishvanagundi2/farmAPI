package com.FarmCollector.farmAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Harvested {
    private Long plantedID;
    private Long harvestID;
    private String farmID;
    private int actualQuantity;
}
