package com.FarmCollector.farmAPI.service;

import com.FarmCollector.farmAPI.entity.Planted;
import com.FarmCollector.farmAPI.repository.PlantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantingService {
    @Autowired
    PlantedRepository plantedRepository;
    public void save( Planted planted)
    {
        plantedRepository.save(planted) ;
    }
}
