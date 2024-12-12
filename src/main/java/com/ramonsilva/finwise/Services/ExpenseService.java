package com.ramonsilva.finwise.Services;

import com.ramonsilva.finwise.Dto.ExpenseDTO;
import com.ramonsilva.finwise.Entity.Expense;
import com.ramonsilva.finwise.Entity.ExpenseCategory;
import com.ramonsilva.finwise.Entity.Users;
import com.ramonsilva.finwise.Mapper.ExpenseMapper;
import com.ramonsilva.finwise.Repositories.ExpenseCategoryRepository;
import com.ramonsilva.finwise.Repositories.ExpenseRepository;
import com.ramonsilva.finwise.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UsersRepository usersRepository;
    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Users user = usersRepository.findById(expenseDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ExpenseCategory category = expenseCategoryRepository.findById(expenseDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Expense expense = ExpenseMapper.toEntity(expenseDTO, user, category);
        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.toDTO(savedExpense);
    }

    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(ExpenseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ExpenseDTO getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        return ExpenseMapper.toDTO(expense);
    }

    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense existingExpense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        existingExpense.setDescription(expenseDTO.getDescription());
        existingExpense.setAmount(expenseDTO.getAmount());
        existingExpense.setDate(expenseDTO.getDate());

        Users user = usersRepository.findById(expenseDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ExpenseCategory category = expenseCategoryRepository.findById(expenseDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Expense updatedExpense = expenseRepository.save(existingExpense);
        return ExpenseMapper.toDTO(updatedExpense);
    }

    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expenseRepository.delete(expense);
    }
}
