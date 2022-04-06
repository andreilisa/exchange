package com.example.exchange.service;

import com.example.exchange.entity.Numerar;
import com.example.exchange.entity.NumerarRequest;
import com.example.exchange.repository.NumerarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class NumerarService {
    private final NumerarRepository numerarRepository;

    public void addNumerar(NumerarRequest numerarRequest) {
        Numerar numerar = new Numerar();
        numerar.setExchangeValue(numerarRequest.getExchangeValue());
        numerar.setSumOfMoney(numerarRequest.getSumOfMoney());
        numerarRepository.save(numerar);
    }

    public Numerar editNumerar(String exchangeValue, double newSumOfMoney) throws Exception {
        Numerar numerar = numerarRepository.findByExchangeValue(exchangeValue).orElseThrow(() -> new Exception("Numerar not found for this value : " + exchangeValue));
        numerar.setSumOfMoney(newSumOfMoney);
        return numerarRepository.save(numerar);
    }

}
