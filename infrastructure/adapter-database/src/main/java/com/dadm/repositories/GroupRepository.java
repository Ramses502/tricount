package com.dadm.repositories;

import com.dadm.model.GroupMO;
import com.dadm.model.UserMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupMO, Long> {

    @Query("SELECT COUNT(u) FROM UserMO u JOIN u.groups g WHERE g.id = :groupId")
    int getHowManyUsersThereAreInTheGroup(Long groupId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_group (user_name, group_id, debt) VALUES (:userName, :groupId, 0)", nativeQuery = true)
    void insertUserIntoGroup(@Param("userName") String userName, @Param("groupId") Long groupId);

    @Query("SELECT g FROM GroupMO g")
    List<GroupMO> getAllGroups();

    @Query("SELECT ug.group FROM UserGroupMO ug JOIN ug.user u WHERE u.name = :userName")
    List<GroupMO> getAllGroupsByUserName(@Param("userName") String userName);
}
