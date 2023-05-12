package com.dadm.adapter;

import com.dadm.mapper.*;
import com.dadm.model.*;
import com.dadm.ports.infrastructure.UserDBPort;
import com.dadm.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        UserMO userMO = userRepository.getOne(name);
        return mapper.toDomain(userMO);
    }

    @Override
    public User getNoGroups(String name) {
        UserMO userMO = userRepository.getOne(name);
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

    @Override
    public void insertDebt(Long expenseId, Long groupId, Double debt) {
        userRepository.insertDebt(expenseId, groupId, debt);
    }

    @Override
    public Map<String, Double> getUserDebtFromGroup(Long groupId) {
        List<UserGroupMO> usersFromGroup = userRepository.getDebtFromGroup(groupId);
        Map<String, Double> userDebts = new HashMap<>();
        for (UserGroupMO user : usersFromGroup){
            userDebts.put(user.getUser().getName(), user.getDebt());
        }
        return userDebts;
    }
}
