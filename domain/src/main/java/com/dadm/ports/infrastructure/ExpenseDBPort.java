package com.dadm.ports.infrastructure;

import com.dadm.model.Expense;

import java.util.List;

public interface ExpenseDBPort {

    List<Expense> get();

    Expense get(Long id);

    Expense getNoUsers(Long id);

    void upload(Expense expense);

    void update(Expense expense);

    void delete(Long id);

    int getUsersOfExpense(Long id);

    void insertUsersFromGroupToExpense(Long groupId, Long expenseId);

}
