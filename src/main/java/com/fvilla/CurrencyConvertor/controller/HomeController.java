package com.fvilla.CurrencyConvertor.controller;

import com.fvilla.CurrencyConvertor.dao.CurrencyDao;
import com.fvilla.CurrencyConvertor.entity.Currencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
public class HomeController {

    @Autowired
    private CurrencyDao currencyDao;

    @RequestMapping("/")
    public String home(Model model){
        Currencies currencies = currencyDao.getCurrencies();
        model.addAttribute("currencies", currencies);
        return "home";
    }

    @PostMapping("/")
    public String getConvertedValue(@ModelAttribute("from") String from, @ModelAttribute("to") String to,
                                    @ModelAttribute("amount") BigDecimal amount, Model model){
        Currencies currencies = currencyDao.getCurrencies();
        model.addAttribute("currencies", currencies);
        model.addAttribute("result", currencyDao.getConvertedValue(from,to,amount));
        return "home";
    }
}
