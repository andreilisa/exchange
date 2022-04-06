package com.example.exchange.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "currency")
@Data
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codeCurrency;
    private int rate;
    private double exchangeValue;
    @Column(name = "date")
    private LocalDate dateOperation = LocalDate.now();
    @OneToMany
    private List<ExchangeMoney> changeMoney;



}
