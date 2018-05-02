/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evdosoft.stocktechsys.models;

import java.math.BigDecimal;

/**
 * Model to download last day price History from IEX
 * Example of call: https://api.iextrading.com/1.0/stock/aapl/chart/5y
 * Typical response:
[ {"date":"20180105",
* "minute":"10:59",
* "label":"10:59 AM",
* "high":175.19,
* "low":175.18,
* "average":175.185,
* "volume":200,
* "notional":35037,
* "numberOfTrades":2,
* "marketHigh":175.19,
* "marketLow":175.065,
* "marketAverage":175.161,
* "marketVolume":60642,
* "marketNotional":10622121.2319,
* "marketNumberOfTrades":437,
* "marketChangeOverTime":0.009666597496022644,
* "changeOverTime":0.010608840123221757}
 *},...,{...}]
 * @author dominicj
 */

public class ChartOneDay {
   
        protected String date;
    protected String minute;
    protected String label;
    protected BigDecimal high;
    protected BigDecimal low;
    protected BigDecimal average;
    protected Integer volume;
    protected Integer notional;
    protected Integer numberOfTrades;
    protected BigDecimal marketHigh;
    protected BigDecimal marketLow;
    protected BigDecimal marketAverage;
    protected Integer marketVolume;
    protected BigDecimal marketNotional;
    protected BigDecimal marketNumberOfTrades;
    protected float marketChangeOverTime;
    protected float changeOverTime;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getMinute() {
        return minute;
    }
    public void setMinute(String minute) {
        this.minute = minute;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public BigDecimal getHigh() {
        return high;
    }
    public void setHigh(BigDecimal high) {
        this.high = high;
    }
    public BigDecimal getLow() {
        return low;
    }
    public void setLow(BigDecimal low) {
        this.low = low;
    }
    public BigDecimal getAverage() {
        return average;
    }
    public void setAverage(BigDecimal average) {
        this.average = average;
    }
    public Integer getVolume() {
        return volume;
    }
    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    public Integer getNotional() {
        return notional;
    }
    public void setNotional(Integer notional) {
        this.notional = notional;
    }
    public Integer getNumberOfTrades() {
        return numberOfTrades;
    }
    public void setNumberOfTrades(Integer numberOfTrades) {
        this.numberOfTrades = numberOfTrades;
    }
    public BigDecimal getMarketHigh() {
        return marketHigh;
    }
    public void setMarketHigh(BigDecimal marketHigh) {
        this.marketHigh = marketHigh;
    }
    public BigDecimal getMarketLow() {
        return marketLow;
    }
    public void setMarketLow(BigDecimal marketLow) {
        this.marketLow = marketLow;
    }
    public BigDecimal getMarketAverage() {
        return marketAverage;
    }
    public void setMarketAverage(BigDecimal marketAverage) {
        this.marketAverage = marketAverage;
    }
    public Integer getMarketVolume() {
        return marketVolume;
    }
    public void setMarketVolume(Integer marketVolume) {
        this.marketVolume = marketVolume;
    }
    public BigDecimal getMarketNotional() {
        return marketNotional;
    }
    public void setMarketNotional(BigDecimal marketNotional) {
        this.marketNotional = marketNotional;
    }
    public BigDecimal getMarketNumberOfTrades() {
        return marketNumberOfTrades;
    }
    public void setMarketNumberOfTrades(BigDecimal marketNumberOfTrades) {
        this.marketNumberOfTrades = marketNumberOfTrades;
    }
    public float getMarketChangeOverTime() {
        return marketChangeOverTime;
    }
    public void setMarketChangeOverTime(float marketChangeOverTime) {
        this.marketChangeOverTime = marketChangeOverTime;
    }
    public float getChangeOverTime() {
        return changeOverTime;
    }
    public void setChangeOverTime(float changeOverTime) {
        this.changeOverTime = changeOverTime;
    }
    
    
}
