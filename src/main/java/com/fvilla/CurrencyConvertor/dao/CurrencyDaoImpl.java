package com.fvilla.CurrencyConvertor.dao;

import com.fvilla.CurrencyConvertor.entity.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Repository
public class CurrencyDaoImpl implements CurrencyDao{

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://api.bluelytics.com.ar/v2/latest";

    public Currencies getCurrencies(){
        Currencies currencies = restTemplate.getForObject(url, Currencies.class);
        currencies.setLastUpdate(formatDate(currencies.getLastUpdate()));
        return currencies;
    }

    public BigDecimal getConvertedValue(String from, String to, BigDecimal amount) {

        Currencies currencies = restTemplate.getForObject(url, Currencies.class);
        currencies.setLastUpdate(formatDate(currencies.getLastUpdate()));

        BigDecimal result = BigDecimal.valueOf(0);

        switch (from) {
            case "pesoArgentino":
                switch (to) {
                    case "dolarOficialSell":
                        result = amount.divide(currencies.getDolarOficial().getSellValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "dolarOficialBuy":
                        result = amount.divide(currencies.getDolarOficial().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "dolarBlueSell":
                        result = amount.divide(currencies.getDolarBlue().getSellValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "dolarBlueBuy":
                        result = amount.divide(currencies.getDolarBlue().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "euroOficialSell":
                        result = amount.divide(currencies.getEuroOficial().getSellValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "euroOficialBuy":
                        result = amount.divide(currencies.getEuroOficial().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "euroBlueSell":
                        result = amount.divide(currencies.getEuroBlue().getSellValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "euroBlueBuy":
                        result = amount.divide(currencies.getEuroBlue().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    default:
                        result = amount;
                        break;
                }
                break;
            case "dolar":
                switch (to) {
                    case "pesoArgentino":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).setScale(2);
                        break;
                    case "euroOficialSell":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).divide(currencies.getEuroOficial().getSellValue());
                        break;
                    case "euroOficialBuy":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).divide(currencies.getEuroOficial().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "euroBlueSell":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).divide(currencies.getEuroBlue().getSellValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "euroBlueBuy":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).divide(currencies.getEuroBlue().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    default:
                        result = amount;
                        break;
                }
                break;
            case "euro":
                switch (to) {
                    case "pesoArgentino":
                        result = amount.multiply(currencies.getEuroBlue().getBuyValue()).setScale(2);
                        break;
                    case "dolarOficialSell":
                        result = amount.multiply(currencies.getEuroBlue().getBuyValue()).divide(currencies.getDolarOficial().getSellValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "dolarOficialBuy":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).divide(currencies.getDolarOficial().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "dolarBlueSell":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).divide(currencies.getDolarBlue().getSellValue(), 2, RoundingMode.HALF_UP);
                        break;
                    case "dolarBlueBuy":
                        result = amount.multiply(currencies.getDolarBlue().getBuyValue()).divide(currencies.getDolarBlue().getBuyValue(), 2, RoundingMode.HALF_UP);
                        break;
                    default:
                        result = amount;
                        break;
                }
                break;
        }
        return result;
    }

    public String formatDate(String date){

        String[] newDate = date.split("T");

        return newDate[0];
    }
}
