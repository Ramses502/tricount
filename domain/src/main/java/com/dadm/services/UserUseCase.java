package com.dadm.services;

import com.dadm.exceptions.LoginException;
import com.dadm.model.User;
import com.dadm.ports.application.UserPort;
import com.dadm.ports.infrastructure.UserDBPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserUseCase implements UserPort {

    private final UserDBPort userDBPort;

    public UserUseCase(UserDBPort userDBPort) {
        this.userDBPort = userDBPort;
    }

    @Override
    public List<User> get() {
        return userDBPort.get();
    }

    @Override
    public User get(String name) {
        return userDBPort.get(name);
    }

    @Override
    public void createUser(User user) {
        userDBPort.upload(user);
    }

    @Override
    public void updateUser(User user) {
        userDBPort.update(user);
    }

    @Override
    public void deleteUser(String name) {
        userDBPort.delete(name);
    }

    @Override
    public User login(String name, String password) {
        User user = userDBPort.getNoGroups(name);
        if(Objects.equals(user.getName(), name) && Objects.equals(user.getPassword(), password)){
            return user;
        }else{
            throw new LoginException();
        }
    }

    @Override
    public Double getDebtFromSpecificGroup(String name, Long groupId) {
        Map<String, Double> userDebtGroup = userDBPort.getUserDebtFromGroup(groupId);
        return userDebtGroup.get(name);
    }

    @Override
    public void pay(String name, Long groupId, double money) {
        userDBPort.pay(name, groupId, money);
    }
}
