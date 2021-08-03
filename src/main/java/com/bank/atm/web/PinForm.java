package com.bank.atm.web;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PinForm {
    @Size(min = 4, max = 4, message = "PIN should consist of 4 digits")
    @Pattern(regexp = "[0-9]*",
            message = "PIN should consist of digits")
    private String pin;
}
