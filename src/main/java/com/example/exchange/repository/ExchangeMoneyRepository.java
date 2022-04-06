package com.example.exchange.repository;

import com.example.exchange.entity.ExchangeMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ExchangeMoneyRepository extends JpaRepository<ExchangeMoney, Long> {
}
