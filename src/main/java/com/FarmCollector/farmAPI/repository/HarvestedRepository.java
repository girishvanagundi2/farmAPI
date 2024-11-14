package com.FarmCollector.farmAPI.repository;

import com.FarmCollector.farmAPI.dto.Harvested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HarvestedRepository {
@Autowired
    JdbcTemplate jdbcTemplate;
    public int save(Harvested harvested)
    {
        return jdbcTemplate.update("insert into Harvested (planted_id,farm_id,actual_quantity) " +
                        "values (?,?,?)",
                new Object[]{
                        harvested.getPlantedID(), harvested.getFarmID(),harvested.getActualQuantity()
                });

    }
}
