package com.ramonsilva.finwise.Mapper;

import com.ramonsilva.finwise.Dto.IncomeDTO;
import com.ramonsilva.finwise.Entity.Income;
import com.ramonsilva.finwise.Entity.Users;

public class IncomeMapper {
    public static Income toEntity(IncomeDTO dto, Users user) {
        Income income = new Income();
        income.setId(dto.getId());
        income.setDescription(dto.getDescription());
        income.setAmount(dto.getAmount());
        income.setDate(dto.getDate());
        income.setUser(user);
        return income;
    }

    public static IncomeDTO toDTO(Income income) {
        IncomeDTO dto = new IncomeDTO();
        dto.setId(income.getId());
        dto.setDescription(income.getDescription());
        dto.setAmount(income.getAmount());
        dto.setDate(income.getDate());
        dto.setUserId(income.getUser().getId());
        return dto;
    }
}
