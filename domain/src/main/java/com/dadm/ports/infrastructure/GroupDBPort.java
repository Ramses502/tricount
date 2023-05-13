package com.dadm.ports.infrastructure;

import com.dadm.model.Expense;
import com.dadm.model.Group;
import com.dadm.model.User;

import java.util.List;

public interface GroupDBPort {

    List<Group> getAllGroups();

    List<Group> getAllGroupsByUserName(String name);

    Group get(Long id);

    Group getNoUsers(Long id);

    void upload(Group group);

    void update(Group group);

    void delete(Long id);

    int getNumberOfUsers(Long id);

    void insertUserIntoGroup(String userName, Long groupId);

    List<Expense> getAllExpensesFromGroup(Long groupId);

    List<User> getAllUsersFromGroup(Long groupId);
}
