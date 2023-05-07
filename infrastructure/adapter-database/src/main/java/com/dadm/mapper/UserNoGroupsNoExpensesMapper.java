package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserNoGroupsNoExpensesMapper {

    UserNoGroupsNoExpensesMapper INSTANCE = Mappers.getMapper(UserNoGroupsNoExpensesMapper.class);

    User toDomainNoGroupsNoExpenses(UserMO userMO);
}