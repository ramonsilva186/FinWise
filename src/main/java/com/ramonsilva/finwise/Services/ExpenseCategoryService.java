package com.ramonsilva.finwise.Services;

import com.ramonsilva.finwise.Dto.ExpenseCategoryDTO;
import com.ramonsilva.finwise.Entity.ExpenseCategory;
import com.ramonsilva.finwise.Mapper.ExpenseCategoryMapper;
import com.ramonsilva.finwise.Repositories.ExpenseCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseCategoryService {

    private final ExpenseCategoryRepository categoryRepository;

    public ExpenseCategoryDTO createCategory(ExpenseCategoryDTO categoryDTO) {
        ExpenseCategory category = ExpenseCategoryMapper.toEntity(categoryDTO);
        ExpenseCategory savedCategory = categoryRepository.save(category);
        return ExpenseCategoryMapper.toDTO(savedCategory);
    }

    public List<ExpenseCategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(ExpenseCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ExpenseCategoryDTO getCategoryById(Long id) {
        ExpenseCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return ExpenseCategoryMapper.toDTO(category);
    }

    public ExpenseCategoryDTO updateCategory(Long id, ExpenseCategoryDTO categoryDTO) {
        ExpenseCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryDTO.getName());
        ExpenseCategory updatedCategory = categoryRepository.save(category);
        return ExpenseCategoryMapper.toDTO(updatedCategory);
    }

    public void deleteCategory(Long id) {
        ExpenseCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(category);
    }
}
