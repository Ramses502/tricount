package com.dadm.adapter;

import com.dadm.mapper.*;
import com.dadm.model.Expense;
import com.dadm.model.Group;
import com.dadm.model.User;
import com.dadm.model.UserMO;
import com.dadm.ports.infrastructure.UserDBPort;
import com.dadm.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDBAdapter implements UserDBPort {

    private final UserMapper mapper = UserMapper.INSTANCE;
    private final UserNoGroupsMapper noGroupsMapper = UserNoGroupsMapper.INSTANCE;
    private final UserNoGroupsNoExpensesMapper noGroupsNoExpensesMapper = UserNoGroupsNoExpensesMapper.INSTANCE;
    private final GroupMapper groupMapper = GroupMapper.INSTANCE;
    private final ExpenseMapper expenseMapper = ExpenseMapper.INSTANCE;

    private final UserRepository userRepository;

    public UserDBAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> get() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User get(String name) {
        UserMO userMO = userRepository.getReferenceById(name);
        return mapper.toDomain(userMO);
    }

    @Override
    public User getNoGroups(String name) {
        UserMO userMO = userRepository.getReferenceById(name);
        return noGroupsMapper.toDomainNoGroups(userMO);
    }

    @Override
    public void upload(User user) {
        UserMO userMO = mapper.toMO(user);
        userRepository.save(userMO);
    }

    @Override
    public void update(User user) {
        UserMO userMO = mapper.toMO(user);
        userRepository.save(userMO);
    }

    @Override
    public void delete(String name) {
        userRepository.deleteById(name);
    }

    @Override
    public List<User> getUsersFromGroup(Long groupId){
        return userRepository.getUsersFromId(groupId)
                .stream()
                .map(noGroupsNoExpensesMapper::toDomainNoGroupsNoExpenses)
                .collect(Collectors.toList());
    }

    @Override
    public void removeGroupFromUser(String userName, Group group) {
        userRepository.removeGroupFromUser(userName, groupMapper.toMO(group));
    }

    @Override
    public void removeExpenseFromUser(String userName, Expense expense) {
        userRepository.removeExpenseFromUser(userName, expenseMapper.toMO(expense));
    }
}
