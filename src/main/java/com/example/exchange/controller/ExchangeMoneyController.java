package com.example.exchange.controller;

import com.example.exchange.entity.ExchangeRequest;
import com.example.exchange.service.ExchangeMoneyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/exchangerOfMoney")
@RequiredArgsConstructor
public class ExchangeMoneyController {

    private final ExchangeMoneyService changeMoneyService;

    @PostMapping("/convertMoney")
    public void exchangeMoney(@RequestBody ExchangeRequest exchangeRequest) {
        changeMoneyService.exchangeMoney(exchangeRequest.getExchangeValue(), exchangeRequest.getSumOfMoney());
    }
}
