package com.example.exchange.service;

import com.example.exchange.entity.ExchangeMoney;
import com.example.exchange.repository.ExchangeMoneyRepository;
import com.example.exchange.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ExchangeMoneyService {
   private final CurrencyRepository currencyRepository;
   private final ExchangeMoneyRepository changeMoneyRepository;

    public ExchangeMoneyService(CurrencyRepository currencyRepository, ExchangeMoneyRepository changeMoneyRepository) {
        this.currencyRepository = currencyRepository;
        this.changeMoneyRepository = changeMoneyRepository;
    }

    public void exchangeMoney(String code, double sumOfMoney) {
        ExchangeMoney changeMoney = new ExchangeMoney();
        changeMoney.setCodCurrency(code);
        changeMoney.setSumOfMoneyShouldToConvert(sumOfMoney);
        changeMoney.setExchangeValue(getMoneyCost(code));
        changeMoney.setSumOfMoneyAfterChange(getMoneyCost(code,sumOfMoney));
        changeMoney.setCurrency(currencyRepository.getById(currencyRepository.getByCodeCurrency(code).getId()));
        changeMoneyRepository.save(changeMoney);
    }

    public double getMoneyCost(String code ,Double money){
       double exchangeValueForMoney = currencyRepository.getByCodeCurrency(code).getExchangeValue();
       return money * exchangeValueForMoney;
    }
    public double getMoneyCost(String code){
         return currencyRepository.getByCodeCurrency(code).getExchangeValue();
    }
}
