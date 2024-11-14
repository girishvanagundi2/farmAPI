package com.FarmCollector.farmAPI.repository;

import com.FarmCollector.farmAPI.dto.CorpReportDTO;
import com.FarmCollector.farmAPI.dto.FarmReportDTO;
import com.FarmCollector.farmAPI.dto.Planted;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.util.List;

import static org.mockito.Mockito.*;

public class PlantedRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    PlantedRepository plantedRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReportAllFarm() throws Exception {
        when(jdbcTemplate.query(anyString(), any(ResultSetExtractor.class))).thenReturn(List.of(new FarmReportDTO()));

        List<FarmReportDTO> result = plantedRepository.reportAllFarm();
        Assert.assertEquals(List.of(new FarmReportDTO()).size(), result.size());
    }

    @Test
    public void testReportByCorpType() throws Exception {
        when(jdbcTemplate.query(anyString(), any(ResultSetExtractor.class))).thenReturn(List.of(new CorpReportDTO()));

        List<CorpReportDTO> result = plantedRepository.reportByCorpType();
        Assert.assertEquals(List.of(new CorpReportDTO()).size(), result.size());
    }

/*   @Test
    public void testSave() throws Exception {
        when(jdbcTemplate.update(anyString(), anyVararg())).thenReturn(0);

        int result = plantedRepository.save(new Planted());
        Assert.assertEquals(0, result);
    }*/
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme