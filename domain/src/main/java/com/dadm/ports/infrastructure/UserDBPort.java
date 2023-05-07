package com.dadm.ports.infrastructure;

import com.dadm.model.Expense;
import com.dadm.model.Group;
import com.dadm.model.User;

import java.util.List;

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
}
