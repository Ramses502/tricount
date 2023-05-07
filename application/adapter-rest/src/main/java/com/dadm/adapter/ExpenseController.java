package com.dadm.adapter;

import com.dadm.mapper.ExpenseRestMapper;
import com.dadm.model.ExpenseDTO;
import com.dadm.model.GroupDTO;
import com.dadm.model.UserDTO;
import com.dadm.ports.application.ExpensePort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseRestMapper mapper = ExpenseRestMapper.INSTANCE;

    private final ExpensePort expensePort;

    public ExpenseController(ExpensePort expensePort) {
        this.expensePort = expensePort;
    }

    @GetMapping("/all")
    public List<ExpenseDTO> get(){
        return expensePort.get()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping
    public ExpenseDTO get(@RequestParam Long id){
        return mapper.toDTO(expensePort.get(id));
    }

    @PostMapping
    public void post(@RequestBody ExpenseDTO expenseDTO){
        expensePort.createExpense(mapper.toDomain(expenseDTO));
    }

    @PutMapping
    public void put(@RequestBody ExpenseDTO expenseDTO){
        expensePort.updateExpense(mapper.toDomain(expenseDTO));
    }

    @PutMapping("/add_users")
    public void addUsersToExpense(@RequestParam Long groupId, @RequestParam Long expenseId){
        expensePort.addUsersToExpense(groupId, expenseId);
    }

    @PutMapping("/remove_user")
    public void removeUserFromGroup(@RequestParam Long expenseId , @RequestParam String userName) {
        expensePort.removeUserFromGroup(expenseId, userName);
    }

    @GetMapping("/debt")
    public double mountPerUser(@RequestParam Long expenseId){
        return expensePort.getDebt(expenseId);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        expensePort.deleteExpense(id);
    }
}
