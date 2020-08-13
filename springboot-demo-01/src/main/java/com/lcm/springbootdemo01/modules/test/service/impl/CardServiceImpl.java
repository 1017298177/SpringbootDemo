package com.lcm.springbootdemo01.modules.test.service.impl;

import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.test.entity.Card;
import com.lcm.springbootdemo01.modules.test.repository.CardRepository;
import com.lcm.springbootdemo01.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Result<Card> insertCard(Card card) {
        cardRepository.saveAndFlush(card);
        return new Result<Card>("insert success",Result.ResultStatus.SUCCESS.status,card);
    }
}
