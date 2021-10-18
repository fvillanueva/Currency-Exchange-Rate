package com.fvilla.CurrencyConvertor.dao;

import com.fvilla.CurrencyConvertor.entity.Currencies;

import java.math.BigDecimal;

public interface CurrencyDao {

    Currencies getCurrencies();

    BigDecimal getConvertedValue (String from, String to, BigDecimal value);
}
