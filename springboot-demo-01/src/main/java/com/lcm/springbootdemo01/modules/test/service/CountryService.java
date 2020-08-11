package com.lcm.springbootdemo01.modules.test.service;

import com.lcm.springbootdemo01.modules.test.entity.Country;

public interface CountryService {
    public Country getCountryByCountryId(int countryId);
    public Country getCountryByCountryName(String countryName);
}
