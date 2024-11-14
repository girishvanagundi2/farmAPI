package com.FarmCollector.farmAPI.repository;

import com.FarmCollector.farmAPI.dto.CorpReportDTO;
import com.FarmCollector.farmAPI.dto.FarmReportDTO;
import com.FarmCollector.farmAPI.dto.Planted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlantedRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
     String SQL="select sum(actual_quantity) as total_actual_quantity,sum(expected_quantity) as total_expected_quantity,p.farm_id,p.farmer_first_name,p.farmer_last_name,p.season\n" +
            "from planted p , harvested h\n" +
            "where  p.id=h.planted_id and " +
            "p.farm_id in (select distinct farm_id from planted ) " +
            "group by " +
            "p.farm_id,p.farmer_first_name,p.farmer_last_name,p.season";

    String SQL2="select sum(actual_quantity) as total_actual_quantity,sum(expected_quantity) as total_expected_quantity,p.corp_type\n" +
            "from planted p , harvested h\n" +
            "where p.id=h.planted_id  \n" +
            "and p.corp_type in (select distinct corp_type from planted ) \n" +
            "group by p.corp_type";
   public List<FarmReportDTO> reportAllFarm()
    {
        return jdbcTemplate.query(SQL, new ResultSetExtractor<List<FarmReportDTO>>() {
            public List<FarmReportDTO> extractData(ResultSet rs) throws SQLException {

                List<FarmReportDTO> farmReportDTOList = new ArrayList<FarmReportDTO>();
                while(rs.next())
                {
                    FarmReportDTO farmReportDTO=new FarmReportDTO();
                    farmReportDTO.setFarmID(rs.getString("farm_id"));
                    farmReportDTO.setSeason(rs.getString("season"));
                    farmReportDTO.setExpectedQuantity(rs.getInt("total_expected_quantity"));
                    farmReportDTO.setActualQuantity(rs.getInt("total_actual_quantity"));
                    farmReportDTO.setFarmerFirstName(rs.getString("farmer_first_name"));
                    farmReportDTO.setFarmerLastName(rs.getString("farmer_last_name"));
                    farmReportDTOList.add(farmReportDTO);

                }

                return farmReportDTOList;
            }
            }
        );
    }

    public List<CorpReportDTO> reportByCorpType()
    {
return jdbcTemplate.query(SQL2, new ResultSetExtractor<List<CorpReportDTO>>() {
    @Override
    public List<CorpReportDTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<CorpReportDTO> corpReportDTOList=new ArrayList<CorpReportDTO>();
        while (rs.next())
        {
            CorpReportDTO corpReportDTO=new CorpReportDTO();
            corpReportDTO.setCorpType(rs.getString("corp_type"));
            corpReportDTO.setExpectedQuantity(rs.getInt("total_expected_quantity"));
            corpReportDTO.setActualQuantity(rs.getInt("total_actual_quantity"));
            corpReportDTOList.add(corpReportDTO);
        }
        return corpReportDTOList;
    }
});
    }

    public int save(Planted planted)
    {
      return jdbcTemplate.update("insert into PLANTED (farm_id,farmer_first_name,farmer_last_name,area,corp_type,expected_quantity,season) " +
               "values (?,?,?,?,?,?,?)",
            new Object[]{
                planted.getFarmID(),planted.getFarmerFirstName(),planted.getFarmerLastName(),planted.getArea(),planted.getCorpType(),planted.getExpectedQuantity(),planted.getSeason()
        });

        }

    }



