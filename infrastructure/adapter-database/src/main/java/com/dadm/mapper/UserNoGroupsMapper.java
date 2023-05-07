package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserNoGroupsMapper {

    UserNoGroupsMapper INSTANCE = Mappers.getMapper(UserNoGroupsMapper.class);

    User toDomainNoGroups(UserMO userMO);
}
