package com.FarmCollector.farmAPI.service;

import com.FarmCollector.farmAPI.dto.CorpReportDTO;
import com.FarmCollector.farmAPI.dto.FarmReportDTO;
import com.FarmCollector.farmAPI.repository.PlantedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
@Autowired
    PlantedRepository plantedRepository;
    public List<FarmReportDTO> farmDetailsReport()
    {
        List<FarmReportDTO> result = plantedRepository.reportAllFarm();
        return result;
    }

    public List<CorpReportDTO> reportByCorpType()
    {
        List<CorpReportDTO> result = plantedRepository.reportByCorpType();
        return result;
    }
}
