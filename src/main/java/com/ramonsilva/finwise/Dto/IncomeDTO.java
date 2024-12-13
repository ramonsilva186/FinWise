package com.ramonsilva.finwise.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class IncomeDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private Long userId;

}
