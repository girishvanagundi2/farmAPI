package com.FarmCollector.farmAPI.controller;


import com.FarmCollector.farmAPI.dto.*;
import com.FarmCollector.farmAPI.repository.PlantedRepository;
import com.FarmCollector.farmAPI.service.HarvestService;
import com.FarmCollector.farmAPI.service.PlantingService;
import com.FarmCollector.farmAPI.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class FarmRestController {
    @Autowired
private PlantingService plantingService;
    @Autowired
    private PlantedRepository plantedRepository;
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
    public List<FarmReportDTO> fetchReportForAllFarms()
    {
        List<FarmReportDTO> result = reportService.farmDetailsReport();
        return result;
    }

    /**
     * Get End point to fetch the report by corpType.
     * Generate Report for given Corp Type
     * @return List<CropDetailsReportDTO>
     */
    @GetMapping("/reportForCorpType")
    public List<CorpReportDTO> fetchReportForCorpType()
    {
        List<CorpReportDTO> result = reportService.reportByCorpType();
        return result;
    }

    @GetMapping("/plant1/")
    public Optional<Planted> returnObjectInBrowser() {
  /*      Planted planted = new Planted();
        planted.setFarmerFirstName("farmerfistname");
        planted.setFarmerLastName("farmerLastname");
        planted.setArea(1);
        planted.setFarmID(0001l);
        planted.setCorp_type("corn");
        planted.setExpectedquantity(2);
        planted.setSeason("2024");*/
        //someClass.doStuff();
     //   Optional<Planted> res = plantedRepository.findById(1l);
        return null;
    }
}
