package com.example.springbootexample.repository;

import com.example.springbootexample.entity.Trade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TradeRepository extends CrudRepository<Trade, Integer> {
    List<Trade> findByUserId(int userId);
}