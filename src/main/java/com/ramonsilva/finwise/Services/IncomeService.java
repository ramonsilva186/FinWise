package com.ramonsilva.finwise.Services;

import com.ramonsilva.finwise.Dto.IncomeDTO;
import com.ramonsilva.finwise.Entity.Income;
import com.ramonsilva.finwise.Entity.Users;
import com.ramonsilva.finwise.Mapper.IncomeMapper;
import com.ramonsilva.finwise.Repositories.IncomeRepository;
import com.ramonsilva.finwise.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final UsersRepository usersRepository;

    public IncomeDTO createIncome(IncomeDTO incomeDTO) {
        Users user = usersRepository.findById(incomeDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Income income = IncomeMapper.toEntity(incomeDTO, user);
        Income savedIncome = incomeRepository.save(income);
        return IncomeMapper.toDTO(savedIncome);
    }

    public List<IncomeDTO> getAllIncomes() {
        return incomeRepository.findAll().stream()
                .map(IncomeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public IncomeDTO getIncomeById(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));
        return IncomeMapper.toDTO(income);
    }

    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));

        income.setDescription(incomeDTO.getDescription());
        income.setAmount(incomeDTO.getAmount());
        income.setDate(incomeDTO.getDate());

        Income updatedIncome = incomeRepository.save(income);
        return IncomeMapper.toDTO(updatedIncome);

    }

    public void deleteIncome(Long id) {
        Income income = incomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Income not found"));
        incomeRepository.delete(income);
    }
}
