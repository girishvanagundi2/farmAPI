package com.FarmCollector.farmAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorpReportDTO {
    int expectedQuantity;
    int actualQuantity;
    String corpType;

    @Override
    public String toString() {
        return "CorpReportDTO{" +
                "expectedQuantity=" + expectedQuantity +
                ", actualQuantity=" + actualQuantity +
                ", corpType='" + corpType + '\'' +
                '}';
    }
}
