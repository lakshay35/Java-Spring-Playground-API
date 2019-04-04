package com.example.springbootexample.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "entryDate")
    private Date entryDate;

    @Column(name = "exitDate")
    @Nullable
    private Date exitDate;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "entryPrice")
    private Double entryPrice;

    @Column(name = "exitPrice")
    @Nullable
    private Double exitPrice;

    @Column(name = "positionSize")
    private Integer positionSize;

    @Column(name = "tradeType")
    private String tradeType;

    @Column(name = "securityType")
    private String securityType;

    @Column(name = "tradeFee")
    private double tradeFee;

    @Column(name = "optionPremium")
    @Nullable
    private Double optionPremium;

    @Column(name = "userId")
    private Integer userId;

    public Trade() {

    }

    public Trade(Date entryDate, Date exitDate, String ticker, double entryPrice, double exitPrice, Integer positionSize, String tradeType, String securityType, double tradeFee, double optionPremium, Integer userId) {
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.ticker = ticker;
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.positionSize = positionSize;
        this.tradeType = tradeType;
        this.securityType = securityType;
        this.tradeFee = tradeFee;
        this.optionPremium = optionPremium;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public double getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(double exitPrice) {
        this.exitPrice = exitPrice;
    }

    public Integer getPositionSize() {
        return positionSize;
    }

    public void setPositionSize(Integer positionSize) {
        this.positionSize = positionSize;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    public double getTradeFee() {
        return tradeFee;
    }

    public void setTradeFee(double tradeFee) {
        this.tradeFee = tradeFee;
    }

    public double getOptionPremium() {
        return optionPremium;
    }

    public void setOptionPremium(double optionPremium) {
        this.optionPremium = optionPremium;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
