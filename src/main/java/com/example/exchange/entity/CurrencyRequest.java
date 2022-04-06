package com.example.exchange.entity;

import lombok.Data;

@Data
public class CurrencyRequest {
    private String codeCurrency;
    private int rate;
    private double exchangeValue;
}
