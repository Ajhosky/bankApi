package com.example.bankapi.controllers;

import com.example.bankapi.models.BlikModel;
import com.example.bankapi.repositories.BlikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlikController {
    @Autowired
    BlikRepository blikRepository;

    @GetMapping("blik")
    public String test(){
        return "hello";
    }

    @GetMapping("blik/codes")
    public List<BlikModel> showProducts(){
        return blikRepository.getBlikCodes();

    }

    @GetMapping("blik/{code}")
    public String checkBlikCode(@PathVariable("code") String code){
        return blikRepository.checkBlikCode(code);

    }
}
