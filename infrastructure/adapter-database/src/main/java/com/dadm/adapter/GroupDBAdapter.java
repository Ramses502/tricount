package com.dadm.adapter;

import com.dadm.mapper.ExpenseMapper;
import com.dadm.mapper.GroupMapper;
import com.dadm.mapper.GroupNoUsersMapper;
import com.dadm.mapper.UserMapper;
import com.dadm.model.Expense;
import com.dadm.model.Group;
import com.dadm.model.User;
import com.dadm.ports.infrastructure.GroupDBPort;
import com.dadm.repositories.GroupRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupDBAdapter implements GroupDBPort {

    private final GroupMapper mapper = GroupMapper.INSTANCE;
    private final GroupNoUsersMapper mapperNoUsers = GroupNoUsersMapper.INSTANCE;
    private final ExpenseMapper expenseMapper = ExpenseMapper.INSTANCE;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    private final GroupRepository groupRepository;

    public GroupDBAdapter(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.getAllGroups()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> getAllGroupsByUserName(String name) {
        return groupRepository.getAllGroupsByUserName(name)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Group get(Long id) {
        return mapper.toDomain(groupRepository.getOne(id));
    }

    @Override
    public Group getNoUsers(Long id) {
        return mapperNoUsers.toDomainNoUsers(groupRepository.getOne(id));
    }

    @Override
    public void upload(Group group) {
        groupRepository.save(mapper.toMO(group));
    }

    @Override
    public void update(Group group) {
        groupRepository.save(mapper.toMO(group));
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public int getNumberOfUsers(Long id) {
        return groupRepository.getHowManyUsersThereAreInTheGroup(id);
    }

    @Override
    public void insertUserIntoGroup(String userName, Long groupId) {
        groupRepository.insertUserIntoGroup(userName, groupId);
    }

    @Override
    public List<Expense> getAllExpensesFromGroup(Long groupId) {
        return groupRepository.getAllExpensesFromGroup(groupId)
                .stream()
                .map(expenseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getAllUsersFromGroup(Long groupId) {
        return groupRepository.getAllUsersFromGroup(groupId)
                .stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }
}
