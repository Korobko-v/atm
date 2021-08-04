package com.bank.atm.web;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PinForm {
    @Size(min = 4, max = 4, message = "PIN должен состоять из 4 цифр")
    @Pattern(regexp = "[0-9]*",
            message = "PIN должен состоять из цифр")
    private String pin;
}
