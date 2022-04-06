package com.example.exchange.repository;

import com.example.exchange.entity.Numerar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface NumerarRepository extends JpaRepository<Numerar, Long> {

   Optional<Numerar> findByExchangeValue(String value);
}
