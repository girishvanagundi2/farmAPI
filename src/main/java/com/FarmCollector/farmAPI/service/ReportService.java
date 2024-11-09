package com.FarmCollector.farmAPI.service;

import com.FarmCollector.farmAPI.dto.CropDetailsReportDTO;
import com.FarmCollector.farmAPI.dto.FarmDetailsReportDTO;
import com.FarmCollector.farmAPI.repository.HarvestedRepository;
import com.FarmCollector.farmAPI.repository.PlantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    PlantedRepository plantedRepository;
    @Autowired
    HarvestedRepository harvestedRepository;

    public List<FarmDetailsReportDTO> farmDetailsReport()
    {
        List<FarmDetailsReportDTO> resultDTO = plantedRepository.reportAllFarm();
        return resultDTO;
    }

    public List<CropDetailsReportDTO> reportByCorpType()
    {
        List<CropDetailsReportDTO> resultDTO = plantedRepository.reportByCorpType();
        return resultDTO;
    }
}
