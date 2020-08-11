package com.lcm.springbootdemo01.modules.test.service;

import com.github.pagehelper.PageInfo;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.City;

import java.util.List;

public interface CityService {
    List<City> getCitiesByCountryId(int countryId);

    PageInfo<City> getCitiesPage(int countryId, SearchVo searchVo);
}
