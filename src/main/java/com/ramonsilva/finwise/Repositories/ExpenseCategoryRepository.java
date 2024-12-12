package com.ramonsilva.finwise.Repositories;

import com.ramonsilva.finwise.Entity.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {
}
