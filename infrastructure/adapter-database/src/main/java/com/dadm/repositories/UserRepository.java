package com.dadm.repositories;

import com.dadm.model.ExpenseMO;
import com.dadm.model.GroupMO;
import com.dadm.model.UserMO;
//import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserMO,String> {

    @Query("SELECT u FROM UserMO u JOIN u.groups g WHERE g.id = :groupId")
    List<UserMO> getUsersFromId(Long groupId);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserMO u WHERE u.name = :userName AND :group MEMBER OF u.groups")
    void removeGroupFromUser(@Param("userName") String userName, @Param("group") GroupMO group);

    @Transactional
    @Modifying
    @Query("DELETE FROM UserMO u WHERE u.name = :userName AND :expense MEMBER OF u.expenses")
    void removeExpenseFromUser(@Param("userName") String userName, @Param("expense") ExpenseMO expenseMO);
}
