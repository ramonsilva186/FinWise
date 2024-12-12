package com.ramonsilva.finwise.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ExpenseDTO {

    private String description;
    private BigDecimal amount;
    private Long userId;
    private Long categoryId;
    private LocalDate date;

}
