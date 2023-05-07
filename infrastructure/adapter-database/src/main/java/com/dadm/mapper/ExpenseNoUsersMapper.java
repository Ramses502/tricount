package com.dadm.mapper;

import com.dadm.model.Expense;
import com.dadm.model.ExpenseMO;
import com.dadm.model.Group;
import com.dadm.model.GroupMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseNoUsersMapper {

    ExpenseNoUsersMapper INSTANCE = Mappers.getMapper(ExpenseNoUsersMapper.class);

    Expense toDomainNoUsers(ExpenseMO expenseMO);
}
