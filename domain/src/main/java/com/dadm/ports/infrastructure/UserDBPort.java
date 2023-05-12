package com.dadm.ports.infrastructure;

import com.dadm.model.Expense;
import com.dadm.model.Group;
import com.dadm.model.User;

import java.util.List;
import java.util.Map;

public interface UserDBPort {

    List<User> get();

    User get(String name);

    User getNoGroups(String name);

    void upload(User user);

    void update(User user);

    void delete(String name);

    List<User> getUsersFromGroup(Long groupId);

    void removeGroupFromUser(String userName, Group group);

    void removeExpenseFromUser(String name, Expense expense);

    void insertDebt(Long expenseId, Long groupId, Double debt);

    Map<String, Double> getUserDebtFromGroup(Long groupId);

    void pay(String name, Long groupId, Double pay);
}
