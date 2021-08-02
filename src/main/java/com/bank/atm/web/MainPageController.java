package com.bank.atm.web;

import com.bank.atm.model.Account;
import com.bank.atm.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    private AccountRepository accounts;

    @GetMapping
    public String index(Model model) {
        List<Account> accountsList = accounts.findAll();
        model.addAttribute("accountsList", accountsList);
        return "index";
    }
}
