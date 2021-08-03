package com.bank.atm.web;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class NumberForm {
    @Size(min = 16, max = 16)
    @Pattern(regexp = "[0-9]*",
            message = "Number should consist of digits")
    private String number;
}
