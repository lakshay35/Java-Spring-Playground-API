package com.example.springbootexample.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Request;

@RestController
@RequestMapping("/alpha-vantage")
public class AlphaVantageController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {
        return "Alpha Vantage Controller is working!!";
    }

//    @RequestMapping(method = RequestMethod.GET, value = "`")

}