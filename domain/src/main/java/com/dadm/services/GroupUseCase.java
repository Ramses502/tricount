package com.dadm.services;

import com.dadm.model.Group;
import com.dadm.model.User;
import com.dadm.ports.application.GroupPort;
import com.dadm.ports.infrastructure.ExpenseDBPort;
import com.dadm.ports.infrastructure.GroupDBPort;
import com.dadm.ports.infrastructure.UserDBPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupUseCase implements GroupPort {

    private final GroupDBPort groupDBPort;
    private final UserDBPort userDBPort;

    public GroupUseCase(GroupDBPort groupDBPort, UserDBPort userDBPort) {
        this.groupDBPort = groupDBPort;
        this.userDBPort = userDBPort;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDBPort.getAllGroups();
    }

    @Override
    public List<Group> getAllGroupsByUserName(String name) {
        return groupDBPort.getAllGroupsByUserName(name);
    }

    @Override
    public Group get(Long id) {
        return groupDBPort.get(id);
    }

    @Override
    public void createGroup(Group group) {
        groupDBPort.upload(group);
    }

    @Override
    public void updateGroup(Group group) {
        groupDBPort.update(group);
    }

    @Override
    public void deleteGroup(Long id) {
        groupDBPort.delete(id);
    }

    @Override
    public void addUser(Long groupId, String name) {
        groupDBPort.insertUserIntoGroup(name, groupId);
    }

    @Override
    public void removeUserFromGroup(Long groupId, String name) {
        Group group = groupDBPort.getNoUsers(groupId);
        userDBPort.removeGroupFromUser(name, group);
    }
}
