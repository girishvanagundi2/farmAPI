package com.FarmCollector.farmAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Planted {
    /**
     * farmID :farm1234
     * farmerName:farmer1
     * area:2 acres
     * corp_type :corn
     * expectedquantity:2 ton
     * season  :2024_season1
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmID;
    String farmerFirstName;
    String farmerLastName;
    int area;
    String corp_type;
    int expectedquantity;
    String season;
}
