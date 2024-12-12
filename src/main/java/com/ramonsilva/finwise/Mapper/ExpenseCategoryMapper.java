package com.ramonsilva.finwise.Mapper;

import com.ramonsilva.finwise.Dto.ExpenseCategoryDTO;
import com.ramonsilva.finwise.Entity.ExpenseCategory;

public class ExpenseCategoryMapper {
    public static ExpenseCategoryDTO toDTO(ExpenseCategory entity) {
        ExpenseCategoryDTO dto = new ExpenseCategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public static ExpenseCategory toEntity(ExpenseCategoryDTO dto) {
        ExpenseCategory category = new ExpenseCategory();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }
}
