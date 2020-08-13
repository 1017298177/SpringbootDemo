package com.lcm.springbootdemo01.modules.test.repository;

import com.lcm.springbootdemo01.modules.test.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description CardRepository
 * @Author HymanHu
 * @Date 2020/8/12 15:13
 */
@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {


}
