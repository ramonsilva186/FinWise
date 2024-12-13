package com.ramonsilva.finwise.Controllers;

import com.ramonsilva.finwise.Dto.IncomeDTO;
import com.ramonsilva.finwise.Services.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeDTO> createIncome(@RequestBody IncomeDTO incomeDTO) {
        IncomeDTO createdIncome = incomeService.createIncome(incomeDTO);
        return new ResponseEntity<>(createdIncome, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<IncomeDTO>> getAllIncomes() {
        List<IncomeDTO> incomes = incomeService.getAllIncomes();
        return new ResponseEntity<>(incomes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncomeDTO> getIncomeById(@PathVariable Long id) {
        IncomeDTO income = incomeService.getIncomeById(id);
        return new ResponseEntity<>(income, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IncomeDTO> updateIncome(@PathVariable Long id, @RequestBody IncomeDTO incomeDTO) {
        IncomeDTO updatedIncome = incomeService.updateIncome(id, incomeDTO);
        return new ResponseEntity<>(updatedIncome, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
