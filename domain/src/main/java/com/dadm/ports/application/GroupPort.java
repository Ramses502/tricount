package com.dadm.ports.application;

import com.dadm.model.Group;

import java.util.List;

public interface GroupPort {

    List<Group> getAllGroups();

    Group get(Long id);

    void createGroup(Group group);

    void updateGroup(Group group);

    void deleteGroup(Long id);

    void addUser(Long groupId, String name);

    void removeUserFromGroup(Long groupId, String name);
}