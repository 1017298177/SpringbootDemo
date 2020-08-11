package com.lcm.springbootdemo01.modules.test.controller;

import com.github.pagehelper.PageInfo;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.City;
import com.lcm.springbootdemo01.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/{countryId}")
    public List<City> getCitiesByCountryId(@PathVariable("countryId") int countryId){
        return  cityService.getCitiesByCountryId(countryId);
    }


    @PostMapping(value = "/cities/{countryId}",consumes = "application/json")
    public PageInfo<City> getCitiesPage(@PathVariable("countryId") int countryId, @RequestBody SearchVo searchVo){
      return  cityService.getCitiesPage(countryId,searchVo);
    }

}
