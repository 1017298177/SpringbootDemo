package com.lcm.springbootdemo01.modules.test.controller;

import com.lcm.springbootdemo01.modules.test.entity.City;
import com.lcm.springbootdemo01.modules.test.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    @Autowired
    private CityService cityService;

    @GetMapping("test")
    public String test(){
        return "index";
    }

    @GetMapping("/cities/{cityId}")
    @ResponseBody
    public City getCities(@PathVariable int cityId){
        return cityService.getCities(cityId);
    }

}
