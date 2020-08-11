package com.lcm.springbootdemo01;

import com.lcm.springbootdemo01.modules.test.dao.CountryDao;
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

    @Test
    void contextLoads() {
        Country countryByCountryId = countryDao.getCountryByCountryId(1);
        log.info("国家",countryByCountryId);
    }

}
