package com.example.exchange.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "numerar")
@Data
public class Numerar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String exchangeValue;
    private double sumOfMoney;

}
