package com.bank.atm.web;

import com.bank.atm.model.Account;
import com.bank.atm.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@Controller
public class AccountsController {

    @Autowired
    private AccountRepository accounts;

    private static String currentNumber;

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


    @GetMapping("/bank.com/card-number")
    public String showNumberForm() {
        return "card_number";
    }

    @PostMapping("/bank.com/card-number")
    public String handleNumberForm(@RequestParam String number)
    {

            Account account = accounts.findAccountByNumber(number);
            if (account== null) {
                currentNumber = null;
                return "card_number";
            }
            currentNumber = number;
//        accountsSession.setAccountId(account.getId());
//        accountsSession.setNumber(account.getNumber());
        return "pin";
    }

    @GetMapping("/bank.com/pin")
    public String showPinForm(@ModelAttribute("form")
                                          PinForm form) {
        return "pin";
    }

    @PostMapping("/bank.com/pin")
    public String handlePinForm(@ModelAttribute("form")
                                    @Valid
                                            PinForm form,
                                BindingResult result) {
        Account account = accounts.findAccountByNumber(currentNumber);
        if (!account.getPin().equals(form.getPin())) {
            result.addError(new FieldError("form", "pin", "Неверный PIN"));
        }
        if (result.hasErrors()) {
            return "pin";
        }
        return "amount";
    }

    @GetMapping("/bank.com/amount")
    public String showAmountForm() {

        return "amount";
    }

    @PostMapping("/bank.com/amount")
    public String handleAmountForm(@RequestParam (required = false, defaultValue = "10") Integer sum) {
        if (accounts.findAccountByNumber(currentNumber).getBalance() - sum < 0) {
            throw new IllegalStateException("Not enough money to debit");
        }
        accounts.debit(accounts.findAccountByNumber(currentNumber), sum);

//        accounts.findAccountByNumber(currentNumber).setBalance(balance);
//        model.addAttribute("balance", accounts.findAccountByNumber(currentNumber).getBalance());
        return "success";
    }

    @GetMapping("/bank.com/success")
    public String showSuccessPage() {
        return "success";
    }
    @PostMapping("/bank.com/success")
    public String handleSuccessPage() {
        return "success";
    }

    @ModelAttribute("form")
    public PinForm createDefault() {
        return new PinForm();
    }

}
