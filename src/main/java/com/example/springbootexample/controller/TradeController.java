package com.example.springbootexample.controller;

import com.example.springbootexample.entity.Trade;
import com.example.springbootexample.model.DeleteResult;
import com.example.springbootexample.model.Response;
import com.example.springbootexample.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/trades")
public class TradeController {

    @Autowired
    private TradeService service;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "Trade Controller works!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add-trade")
    public Response<Trade> addTrade(@RequestBody Trade trade) {
        return this.service.addTrade(trade);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update-trade")
    public Response<Trade> updateTrade(@RequestBody Trade trade) {
        return this.service.updateTrade(trade);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete-trade/{id}")
    public Response<DeleteResult> deleteTrade(@PathVariable("id") int tradeId) {
         return this.service.deleteTrade(tradeId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get-trades/{id}")
    public Response<List<Trade>> getTrades(@PathVariable("id") int userId) {
        return this.service.getTrades(userId);
    }

}