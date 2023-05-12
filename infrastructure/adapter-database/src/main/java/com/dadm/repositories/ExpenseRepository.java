package com.dadm.repositories;

import com.dadm.model.ExpenseMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseMO, Long> {

    @Query("SELECT COUNT(u) FROM UserMO u JOIN u.expenses e WHERE e.id = :expenseId")
    int getNumberOfUsers(Long expenseId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_expense (user_name, expense_id) SELECT U.name, :expenseId FROM usermo U JOIN user_group UG ON U.name = UG.user_name WHERE UG.group_id = :groupId", nativeQuery = true)
    void insertUsersFromGroupToExpense(Long groupId, Long expenseId);

}
