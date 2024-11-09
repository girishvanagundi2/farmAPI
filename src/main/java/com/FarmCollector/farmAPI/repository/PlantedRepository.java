package com.FarmCollector.farmAPI.repository;

import com.FarmCollector.farmAPI.dto.CropDetailsReportDTO;
import com.FarmCollector.farmAPI.dto.FarmDetailsReportDTO;
import com.FarmCollector.farmAPI.entity.Planted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantedRepository extends JpaRepository <Planted,Long> {

    /**
     * select p.expectedquqnttiy,h.actualquantity ,season ,p.corp_type
     * from  planted p,  harvested h
     * where
     * farmID in (select distinct farmId from planted)
     *
     * @param farmIds
     * @return
     */
    @Query("select p.expectedquqnttiy,h.actualquantity ,season ,p.corp_typ" +
            "from  planted p,  harvested h" +
            "where p.farmID = h.farmID" +
            "and p.farmID in (select distinct farmId from planted), nativeQuery = true")
    //List<FarmDetailsReportDTO> reportAllFarm(@Param("names") Collection<String> farmIds);
    List<FarmDetailsReportDTO> reportAllFarm();

    @Query("select p.expectedquqnttiy,h.actualquantity ,season ,p.corp_type\n" +
            "from  planted p,  harvested h\n" +
            "where \n" +
            "p.corp_type in (select distinct corp_type from planted)")
    List<CropDetailsReportDTO> reportByCorpType();
}
