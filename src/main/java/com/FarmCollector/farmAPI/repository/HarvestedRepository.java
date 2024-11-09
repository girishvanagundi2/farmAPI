package com.FarmCollector.farmAPI.repository;

import com.FarmCollector.farmAPI.entity.Harvested;
import com.FarmCollector.farmAPI.entity.Planted;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestedRepository extends JpaRepository <Harvested,Long> {
}
