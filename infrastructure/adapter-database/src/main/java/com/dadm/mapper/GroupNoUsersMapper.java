package com.dadm.mapper;

import com.dadm.model.Group;
import com.dadm.model.GroupMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupNoUsersMapper {

    GroupNoUsersMapper INSTANCE = Mappers.getMapper(GroupNoUsersMapper.class);

    Group toDomainNoUsers(GroupMO groupMO);
}
