package com.example.exchange.service;

import com.example.exchange.entity.Currency;
import com.example.exchange.entity.CurrencyRequest;
import com.example.exchange.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    @SneakyThrows
    public Currency insertCurrency(CurrencyRequest currencyRequest) {
        Currency currencyForInsert = new Currency();
        currencyForInsert.setCodeCurrency(currencyRequest.getCodeCurrency());
        currencyForInsert.setRate(currencyRequest.getRate());
        currencyForInsert.setExchangeValue(currencyRequest.getExchangeValue());
        if (currencyRepository.checkIfExist(currencyForInsert.getCodeCurrency()) == null) {
            return currencyRepository.save(currencyForInsert);
        } else throw new Exception("Current exist value for this exchange type");
    }

    public Currency getCurrencyByCode(String codeCurrency) {
        return currencyRepository.getByCodeCurrency(codeCurrency);
    }
}
