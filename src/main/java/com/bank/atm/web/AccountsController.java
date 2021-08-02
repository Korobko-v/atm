package com.bank.atm.web;

import com.bank.atm.model.Account;
import com.bank.atm.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class AccountsController {

    @Autowired
    private AccountRepository accounts;

    @GetMapping("/accounts/generate")
    public String generateAccounts() {
        accounts.deleteAll();
        Random random = new Random();

        for (int i = 0; i < 5; ++i) {
            StringBuilder strNumber = new StringBuilder("42764500");
            for (int j = 0; j < 8; j++) {
                strNumber.append(random.nextInt(10));
            }
            accounts.insert(new Account(strNumber.toString(), "1234", random.nextInt(1_000_000)));
        }

        return "redirect:/";
    }
}
