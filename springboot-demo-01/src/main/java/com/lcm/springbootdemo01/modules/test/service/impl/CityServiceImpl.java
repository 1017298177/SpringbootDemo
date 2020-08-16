package com.lcm.springbootdemo01.modules.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.dao.CityDao;
import com.lcm.springbootdemo01.modules.test.entity.City;
import com.lcm.springbootdemo01.modules.test.service.CityService;
import com.lcm.springbootdemo01.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService
{

    @Autowired
    private CityDao cityDao;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<City> getCitiesByCountryId(int countryId) {
        return Optional.
                ofNullable(cityDao.getCitiesByCountryId(countryId))
                .orElse(Collections.emptyList());
    }

    @Override
    public PageInfo<City> getCitiesPage(int countryId, SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        PageInfo<City> cities = new PageInfo<>(cityDao.getCitiesByCountryId(countryId));
        return cities;
    }

    @Override
    public PageInfo<City> getCitiesBySearchVo(SearchVo searchVo) {
        searchVo.initSearchVo();
        PageHelper.startPage(searchVo.getCurrentPage(),searchVo.getPageSize());
        return new PageInfo<>(Optional.ofNullable(cityDao.getCitiesBySearchVo(searchVo)).orElse(Collections.emptyList()));

    }

    @Override
    public Result<City> insertCity(City city) {
        cityDao.insertCity(city);
        return new Result<City>("insert success",Result.ResultStatus.SUCCESS.status,city);
    }

    @Override
    public Result<City> updateCity(City city) {
        cityDao.updateCity(city);
        return new Result<>("update success",Result.ResultStatus.SUCCESS.status,city);
    }

    @Override
    public Result<City> deleteCity(int cityId) {
        cityDao.deleteCity(cityId);
        return new Result<>("delete success",Result.ResultStatus.SUCCESS.status);
    }

    @Override
    public City getCities(int cityId) {
        City city = cityDao.getCities(cityId);
        redisUtil.set("city",city);
        return city;
    }
}
