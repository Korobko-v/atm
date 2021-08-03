package com.bank.atm.web;

import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class PinForm {
    @Size(min = 4, max = 4)
    @Pattern(regexp = "[0-9]*",
            message = "Pin should consist of digits")
    private String pin;
}
