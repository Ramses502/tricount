package com.dadm.adapter;

import com.dadm.mapper.ExpenseMapper;
import com.dadm.mapper.ExpenseNoUsersMapper;
import com.dadm.model.Expense;
import com.dadm.ports.infrastructure.ExpenseDBPort;
import com.dadm.repositories.ExpenseRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExpenseDBAdapter implements ExpenseDBPort {

    private final ExpenseMapper mapper = ExpenseMapper.INSTANCE;
    private final ExpenseNoUsersMapper mapperNoUsers = ExpenseNoUsersMapper.INSTANCE;

    private final ExpenseRepository expenseRepository;

    public ExpenseDBAdapter(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> get() {
        return expenseRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Expense get(Long id) {
        return mapper.toDomain(expenseRepository.getReferenceById(id));
    }

    @Override
    public Expense getNoUsers(Long id) {
        return mapperNoUsers.toDomainNoUsers(expenseRepository.getReferenceById(id));
    }

    @Override
    public void upload(Expense expense) {
        expenseRepository.save(mapper.toMO(expense));
    }

    @Override
    public void update(Expense expense) {
        expenseRepository.save(mapper.toMO(expense));
    }

    @Override
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public int getUsersOfExpense(Long id) {
        return expenseRepository.getNumberOfUsers(id);
    }

    @Override
    public void insertUsersFromGroupToExpense(Long groupId, Long expenseId) {
        expenseRepository.insertUsersFromGroupToExpense(groupId, expenseId);
    }
}
