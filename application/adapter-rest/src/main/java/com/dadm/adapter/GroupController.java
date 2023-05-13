package com.dadm.adapter;

import com.dadm.mapper.ExpenseRestMapper;
import com.dadm.mapper.GroupRestMapper;
import com.dadm.model.ExpenseDTO;
import com.dadm.model.GroupDTO;
import com.dadm.ports.application.GroupPort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final GroupRestMapper mapper = GroupRestMapper.INSTANCE;
    private final ExpenseRestMapper expenseRestMapper = ExpenseRestMapper.INSTANCE;

    private final GroupPort groupPort;

    public GroupController(GroupPort groupPort) {
        this.groupPort = groupPort;
    }

    @GetMapping("/all")
    public List<GroupDTO> get(){
        return groupPort.getAllGroups()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/get_all_my_groups")
    public List<GroupDTO> getAllByUserName(@RequestParam String userName){
        return groupPort.getAllGroupsByUserName(userName)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/get_expenses")
    public List<ExpenseDTO> getAllExpenses(@RequestParam Long groupId){
        return groupPort.getAllExpensesFromGroup(groupId)
                .stream()
                .map(expenseRestMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping
    public GroupDTO get(@RequestParam Long id){
        return mapper.toDTO(groupPort.get(id));
    }

    @PostMapping("/create")
    public void post(@RequestBody GroupDTO groupDTO){
        groupPort.createGroup(mapper.toDomain(groupDTO));
    }

    @PutMapping("/add_user")
    public void addUser(@RequestParam Long groupId , @RequestParam String userName) {
        groupPort.addUser(groupId, userName);
    }

    @PutMapping("/modify")
    public void put(@RequestBody GroupDTO groupDTO){
        groupPort.updateGroup(mapper.toDomain(groupDTO));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam Long id){
        groupPort.deleteGroup(id);
    }

    @PutMapping("/remove_user")
    public void removeUserFromGroup(@RequestParam Long groupId , @RequestParam String userName) {
        groupPort.removeUserFromGroup(groupId, userName);
    }
}
