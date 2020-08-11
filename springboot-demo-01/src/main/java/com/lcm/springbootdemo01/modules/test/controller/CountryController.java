package com.lcm.springbootdemo01.modules.test.controller;

import com.lcm.springbootdemo01.modules.test.entity.Country;
import com.lcm.springbootdemo01.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country/{countryId}")
    public Country getCountryByCountryId(@PathVariable("countryId") int countryId){
        return countryService.getCountryByCountryId(countryId);
    }

    @GetMapping("/country")
    public Country getCountryByCountryName(@RequestParam String countryName){
        return countryService.getCountryByCountryName(countryName);
    }

}
