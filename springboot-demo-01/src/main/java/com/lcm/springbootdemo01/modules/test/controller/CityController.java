package com.lcm.springbootdemo01.modules.test.controller;

import com.github.pagehelper.PageInfo;
import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.City;
import com.lcm.springbootdemo01.modules.test.service.CityService;
import org.apache.ibatis.annotations.Delete;
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

    @GetMapping(value = "/city",consumes = "application/json",produces = "application/json")
    public PageInfo<City> getCitiesBySearchVo(@RequestBody SearchVo searchVo){
        return cityService.getCitiesBySearchVo(searchVo);
    }

   @PostMapping(value = "/city",consumes = "application/json")
    public Result<City> insertCity(@RequestBody City city){
       return cityService.insertCity(city);
   }

   @PutMapping(value = "/city",consumes = "application/x-www-form-urlencoded")
    public Result<City> updateCity(@ModelAttribute City city){
        return cityService.updateCity(city);
   }

   @DeleteMapping("/city/{cityId}")
    public Result<City> deleteCity(@PathVariable("cityId") int cityId){
        return cityService.deleteCity(cityId);
   }


}
