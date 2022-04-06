package com.example.exchange.controller;

import com.example.exchange.entity.Currency;
import com.example.exchange.entity.CurrencyRequest;
import com.example.exchange.service.CurrencyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/getByCurrencyName")
    public Currency getCurrency(@RequestParam String currencyValue) {
        return currencyService.getCurrencyByCode(currencyValue);
    }

    @PostMapping("/addNewCurrencyWithRate")
    public Currency insertRate(@RequestBody CurrencyRequest currency) {
        return currencyService.insertCurrency(currency);
    }
}
