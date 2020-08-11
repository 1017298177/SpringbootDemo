package com.lcm.springbootdemo01.modules.test.service.impl;

import com.lcm.springbootdemo01.modules.test.dao.CountryDao;
import com.lcm.springbootdemo01.modules.test.entity.Country;
import com.lcm.springbootdemo01.modules.test.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImpl implements CountryService {


    @Autowired
    private CountryDao countryDao;

    @Override
    public Country getCountryByCountryId(int countryId) {
        return countryDao.getCountryByCountryId(countryId);
    }

    @Override
    public Country getCountryByCountryName(String countryName) {
        return countryDao.getCountryByCountryName(countryName);
    }


}
