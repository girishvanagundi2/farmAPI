package com.FarmCollector.farmAPI.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class FarmReportDTO implements Serializable {
    int expectedQuantity;
    int actualQuantity;
    String farmID;
    String farmerFirstName;
    String farmerLastName;
    String season;

    public FarmReportDTO()
    {

    }
    public FarmReportDTO(int expectedquantity, int actualquantity, String farmID, String farmerFirstName, String farmerLastName, String season) {
        this.expectedQuantity = expectedquantity;
        this.actualQuantity = actualquantity;
        this.farmID = farmID;
        this.farmerFirstName = farmerFirstName;
        this.farmerLastName = farmerLastName;
        this.season = season;
    }

    @Override
    public String toString() {
        return "FarmReportDTO{" +
                "expectedquantity=" + expectedQuantity +
                ", actualquantity=" + actualQuantity +
                ", farmID='" + farmID + '\'' +
                ", farmerFirstName='" + farmerFirstName + '\'' +
                ", farmerLastName='" + farmerLastName + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
