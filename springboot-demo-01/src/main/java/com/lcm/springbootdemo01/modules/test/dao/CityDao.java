package com.lcm.springbootdemo01.modules.test.dao;

import com.lcm.springbootdemo01.modules.common.vo.SearchVo;
import com.lcm.springbootdemo01.modules.test.entity.City;
import com.lcm.springbootdemo01.modules.test.entity.Country;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CityDao {

    @Select("select * from m_city where country_id=#{countryId}")
    List<City> getCitiesByCountryId(int countryId);

    @Select("<script>" +
            "select * from m_city "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (city_name like '%${keyWord}%' or local_city_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by city_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
     List<City> getCitiesBySearchVo(SearchVo searchVo);

    @Insert("insert into m_city (city_name,local_city_name) values (#{cityName},#{localCityName})")
    @Options(useGeneratedKeys = true,keyColumn = "city_id",keyProperty = "cityId")
    void insertCity(City city);

    @Update("update m_city set city_name = #{cityName} where city_id = #{cityId}")
    void updateCity(City city);

    @Delete("delete from m_city where city_id  = #{cityId}")
    void deleteCity(int cityId);


    @Select("select * from m_city where city_id = #{cityId}")
    City getCities(int cityId);
}
