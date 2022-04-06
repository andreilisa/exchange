package com.example.exchange.repository;

import com.example.exchange.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency getByCodeCurrency(String codeCurrency);

    @Query(value = "SELECT codeCurrency from currency WHERE EXISTS (SELECT codeCurrency FROM currency WHERE codeCurrency = :code_currency)")
    String checkIfExist(@Param("code_currency") String code_currency);

}
