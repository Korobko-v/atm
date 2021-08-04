package com.bank.atm.web;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
public class AmountForm {

    @Positive(message = "Сумма должна быть положительной")
    private Integer amount;
}
