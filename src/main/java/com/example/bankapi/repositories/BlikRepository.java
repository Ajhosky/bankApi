package com.example.bankapi.repositories;

import com.example.bankapi.models.BlikModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlikRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BlikModel> getBlikCodes()
    {
        return
            jdbcTemplate.query(
                    "SELECT * FROM blik",
                    BeanPropertyRowMapper.newInstance(BlikModel.class)
        );

    }

    public String checkBlikCode(String code) {

        try {
            jdbcTemplate.queryForObject(
                    "SELECT code FROM blik WHERE code = "+code,
                    BeanPropertyRowMapper.newInstance(BlikModel.class));
            return "podales dobry kod";
        } catch (EmptyResultDataAccessException e) {
            return "zly kod" + e.getMessage();
        }


        /*if(
                jdbcTemplate.query(
                "SELECT code FROM blik WHERE code = "+code,
                BeanPropertyRowMapper.newInstance(BlikModel.class)
        ) == code){
            return "brawo zaplaciles";

        }else {
            return "zly kod blik";
        }*/

    }

    public String generateBlikCode() {

    }
}
