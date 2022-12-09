package com.example.bankapi.repositories;

import com.example.bankapi.models.BlikModel;
import org.springframework.beans.factory.annotation.Autowired;
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
       }
