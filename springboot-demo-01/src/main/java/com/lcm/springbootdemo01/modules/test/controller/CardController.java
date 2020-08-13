package com.lcm.springbootdemo01.modules.test.controller;

import com.lcm.springbootdemo01.modules.common.vo.Result;
import com.lcm.springbootdemo01.modules.test.entity.Card;
import com.lcm.springbootdemo01.modules.test.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping(value = "/card",consumes = "application/json")
    public Result<Card> insertCard(@RequestBody Card card){
        return cardService.insertCard(card);
    }

}
