package com.dadm.services;

import com.dadm.model.Expense;
import com.dadm.ports.application.ExpensePort;
import com.dadm.ports.infrastructure.ExpenseDBPort;
import com.dadm.ports.infrastructure.UserDBPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseUseCase implements ExpensePort {

    private final ExpenseDBPort expenseDBPort;
    private final UserDBPort userDBPort;

    public ExpenseUseCase(ExpenseDBPort expenseDBPort, UserDBPort userDBPort) {
        this.expenseDBPort = expenseDBPort;
        this.userDBPort = userDBPort;
    }

    @Override
    public List<Expense> get() {
        return expenseDBPort.get();
    }

    @Override
    public Expense get(Long id) {
        return expenseDBPort.get(id);
    }

    @Override
    public void createExpense(Expense expense) {
        expenseDBPort.upload(expense);
    }

    @Override
    public void updateExpense(Expense expense) {
        expenseDBPort.update(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseDBPort.delete(id);
    }

    @Override
    public void addUsersToExpense(Long groupId, Long expenseId) {
        expenseDBPort.insertUsersFromGroupToExpense(groupId, expenseId);
        calculateDebt(expenseId, groupId);
    }

    @Override
    public void removeUserFromGroup(Long expenseId, String name) {
        Expense expense = expenseDBPort.getNoUsers(expenseId);
        userDBPort.removeExpenseFromUser(name, expense);
    }

    public void calculateDebt(Long expenseId, Long groupId) {
        int numberOfUsers = expenseDBPort.getUsersOfExpense(expenseId);
        double quantity = expenseDBPort.getNoUsers(expenseId).getQuantity();
        double debt = quantity / numberOfUsers;
        userDBPort.insertDebt(expenseId, groupId, debt);
    }
}
