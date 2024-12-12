package com.ramonsilva.finwise.Repositories;

import com.ramonsilva.finwise.Entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
