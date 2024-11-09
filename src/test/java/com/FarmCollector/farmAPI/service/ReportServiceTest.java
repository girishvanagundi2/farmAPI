package com.FarmCollector.farmAPI.service;

import com.FarmCollector.farmAPI.dto.CropDetailsReportDTO;
import com.FarmCollector.farmAPI.dto.FarmDetailsReportDTO;
import com.FarmCollector.farmAPI.repository.HarvestedRepository;
import com.FarmCollector.farmAPI.repository.PlantedRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class ReportServiceTest {
    @Mock
    PlantedRepository plantedRepository;
    @Mock
    HarvestedRepository harvestedRepository;
    @InjectMocks
    ReportService reportService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFarmDetailsReport() throws Exception {
        when(plantedRepository.reportAllFarm()).thenReturn(List.of(new FarmDetailsReportDTO()));

        List<FarmDetailsReportDTO> result = reportService.farmDetailsReport();
        Assert.assertEquals(List.of(new FarmDetailsReportDTO()), result);
    }

    @Test
    public void testReportByCorpType() throws Exception {
      //  testDTO;
        List<CropDetailsReportDTO> testDTO= new ArrayList();
        CropDetailsReportDTO elem1=new CropDetailsReportDTO();
        elem1.setCorp_type("corn");
        elem1.setSeason("2024");
        elem1.setActualQuantity(1);
        testDTO.add(elem1);

        when(plantedRepository.reportByCorpType()).thenReturn(testDTO);

        List<CropDetailsReportDTO> result = reportService.reportByCorpType();
        Assert.assertEquals(List.of(new CropDetailsReportDTO()), result);
    }
}

