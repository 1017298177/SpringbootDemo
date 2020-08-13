package com.lcm.springbootdemo01;

import com.lcm.springbootdemo01.modules.test.dao.CityDao;
import com.lcm.springbootdemo01.modules.test.dao.CountryDao;
import com.lcm.springbootdemo01.modules.test.entity.City;
import com.lcm.springbootdemo01.modules.test.entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringbootDemo01ApplicationTests {

    @Autowired
    private CountryDao countryDao;
    @Autowired
    private CityDao cityDao;

    @Test
    void contextLoads() {
    }

}
