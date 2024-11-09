package com.FarmCollector.farmAPI.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class FarmDetailsReportDTO implements Serializable {

    private int expectedQuantity;
    private int actualQuantity;
    private String season;
    private  String corp_type;

    @Override
    public String toString() {
        return "FarmDetailsReportDTO{" +
                "expectedQuantity=" + expectedQuantity +
                ", actualQuantity=" + actualQuantity +
                ", season='" + season + '\'' +
                ", corp_type='" + corp_type + '\'' +
                '}';
    }
}
