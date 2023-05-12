package com.dadm.ports.application;

import com.dadm.model.Expense;

import java.util.List;

public interface ExpensePort {

    List<Expense> get();

    Expense get(Long id);

    void createExpense(Expense expense);

    void updateExpense(Expense expense);

    void deleteExpense(Long id);

    void addUsersToExpense(Long groupId, Long expenseId);

    void removeUserFromGroup(Long expenseId, String userName);
}
