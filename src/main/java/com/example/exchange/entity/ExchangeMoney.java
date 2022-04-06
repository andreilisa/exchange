package com.example.exchange.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "change_money")
@Data
public class ExchangeMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codCurrency;
    private double exchangeValue;
    private double sumOfMoneyShouldToConvert;
    private double sumOfMoneyAfterChange;
    @ManyToOne
    private Currency currency;
}
