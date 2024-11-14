package com.FarmCollector.farmAPI.service;

import com.FarmCollector.farmAPI.dto.Harvested;
import com.FarmCollector.farmAPI.repository.HarvestedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HarvestService {
   @Autowired
   HarvestedRepository harvestedRepository;
    public void save( Harvested harvested)
    {
        harvestedRepository.save(harvested) ;
    }
}
