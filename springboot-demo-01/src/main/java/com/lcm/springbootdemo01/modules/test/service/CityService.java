package com.lcm.springbootdemo01.modules.test.service;

import com.github.pagehelper.PageInfo;
import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.City;

import java.util.List;

public interface CityService {
   List<City> getCitiesByCountryId(int countryId);

   PageInfo<City> getCitiesPage(int countryId, SearchVo searchVo);

   PageInfo<City> getCitiesBySearchVo(SearchVo searchVo);

   Result<City> insertCity(City city);

   Result<City> updateCity(City city);

   Result<City> deleteCity(int cityId);

}
