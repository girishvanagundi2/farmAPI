package com.FarmCollector.farmAPI.controller;


import com.FarmCollector.farmAPI.dto.CropDetailsReportDTO;
import com.FarmCollector.farmAPI.dto.FarmDetailsReportDTO;
import com.FarmCollector.farmAPI.entity.Harvested;
import com.FarmCollector.farmAPI.entity.Planted;
import com.FarmCollector.farmAPI.service.HarvestService;
import com.FarmCollector.farmAPI.service.PlantingService;
import com.FarmCollector.farmAPI.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FarmRestController {
    @Autowired
private PlantingService plantingService;
    @Autowired
private HarvestService harvestService;
    @Autowired
    ReportService reportService;

    /**
     * POST End point for updating the planted details by the farmers
     * @param planted
     * @return
     */
    @PostMapping ("/planted")
public ResponseEntity<String> updatePlaningDetails(@RequestBody Planted planted)
{
    plantingService.save(planted);

return new ResponseEntity<String>(HttpStatusCode.valueOf(200));
}

    /**
     * POST End point for updating the Harvested details by the farmers
     * @param harvested
     * @return
     */
    @PostMapping ("/harvested")
    public ResponseEntity<String> updatePlaningDetails(@RequestBody Harvested harvested)
    {
        harvestService.save(harvested);
        return new ResponseEntity<String>(HttpStatusCode.valueOf(200));
    }

    /**
     * Get End point to fetch the report.
     * Generate Report for All Farms
     * @return List<FarmDetailsReportDTO>
     */
    @GetMapping("/reportForAllFarms")
    public List<FarmDetailsReportDTO> fetchReportForAllFarms()
    {
        List<FarmDetailsReportDTO> result = reportService.farmDetailsReport();
        return result;
    }

    /**
     * Get End point to fetch the report by corpType.
     * Generate Report for given Corp Type
     * @return List<CropDetailsReportDTO>
     */
    @GetMapping("/reportForCorpType")
    public List<CropDetailsReportDTO> fetchReportForCorpType()
    {
        List<CropDetailsReportDTO> result = reportService.reportByCorpType();
        return result;
    }
}
