package com.lcm.springbootdemo01.modules.test.dao;


import com.lcm.springbootdemo01.modules.test.entity.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CountryDao {


    @Select("select * from m_country where country_id = #{countryId}")
    @Results(id = "countryCities",value = {
            @Result(column = "country_id",property = "countryId"),
            @Result(column = "country_id",property = "cities",
            javaType = List.class,
            many = @Many(select = "com.lcm.springbootdemo01.modules.test.dao.CityDao.getCitiesByCountryId"))
    })
    public Country getCountryByCountryId(int countryId);

    @Select("select * from m_country where country_name = #{countryName}")
    @ResultMap("countryCities")
    public Country getCountryByCountryName(String countryName);

}
