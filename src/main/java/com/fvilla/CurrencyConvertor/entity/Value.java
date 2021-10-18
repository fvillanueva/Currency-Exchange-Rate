package com.fvilla.CurrencyConvertor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class Value {

    @JsonProperty("value_avg")
    private BigDecimal avgValue;

    @JsonProperty("value_sell")
    private BigDecimal sellValue;

    @JsonProperty("value_buy")
    private BigDecimal buyValue;

    public Value() {
    }

    public Value(BigDecimal avgValue, BigDecimal sellValue, BigDecimal buyValue) {
        this.avgValue = avgValue;
        this.sellValue = sellValue;
        this.buyValue = buyValue;
    }

    public BigDecimal getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(BigDecimal avgValue) {
        this.avgValue = avgValue;
    }

    public BigDecimal getSellValue() {
        return sellValue;
    }

    public void setSellValue(BigDecimal sellValue) {
        this.sellValue = sellValue;
    }

    public BigDecimal getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(BigDecimal buyValue) {
        this.buyValue = buyValue;
    }

    @Override
    public String toString() {
        return "Value{" +
                "avgValue=" + avgValue +
                ", sellValue=" + sellValue +
                ", buyValue=" + buyValue +
                '}';
    }
}
