package com.ramonsilva.finwise.Controllers;

import com.ramonsilva.finwise.Dto.ExpenseCategoryDTO;
import com.ramonsilva.finwise.Services.ExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class ExpenseCategoryController {
    private final ExpenseCategoryService categoryService;

    @PostMapping
    public ResponseEntity<ExpenseCategoryDTO> createCategory(@RequestBody ExpenseCategoryDTO categoryDTO) {
        ExpenseCategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseCategoryDTO>> getAllCategories() {
        List<ExpenseCategoryDTO> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseCategoryDTO> getCategoryById(@PathVariable Long id) {
        ExpenseCategoryDTO category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseCategoryDTO> updateCategory(@PathVariable Long id, @RequestBody ExpenseCategoryDTO categoryDTO) {
        ExpenseCategoryDTO updatedCategory = categoryService.updateCategory(id, categoryDTO);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
