package com.lcm.springbootdemo01.modules.test.service;

import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.test.entity.Card;

public interface CardService {

    Result<Card> insertCard(Card card);

}
