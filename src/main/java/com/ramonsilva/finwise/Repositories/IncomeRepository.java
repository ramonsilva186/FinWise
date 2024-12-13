package com.ramonsilva.finwise.Repositories;

import com.ramonsilva.finwise.Entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
}
