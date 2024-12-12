package com.ramonsilva.finwise.Mapper;

import com.ramonsilva.finwise.Dto.ExpenseDTO;
import com.ramonsilva.finwise.Entity.Expense;
import com.ramonsilva.finwise.Entity.ExpenseCategory;
import com.ramonsilva.finwise.Entity.Users;

public class ExpenseMapper {
    public static Expense toEntity(ExpenseDTO expenseDTO, Users user, ExpenseCategory category) {
        Expense expense = new Expense();
        expense.setDescription(expenseDTO.getDescription());
        expense.setAmount(expenseDTO.getAmount());
        expense.setUser(user);
        expense.setCategory(category);
        expense.setDate(expenseDTO.getDate());
        return expense;
    }

    public static ExpenseDTO toDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setDescription(expense.getDescription());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setUserId(expense.getUser().getId());
        expenseDTO.setCategoryId(expense.getCategory().getId());
        expenseDTO.setDate(expense.getDate());
        return expenseDTO;
    }
}
