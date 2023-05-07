package com.dadm.mapper;

import com.dadm.model.Group;
import com.dadm.model.GroupMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.swing.*;

@Mapper
public interface GroupMapper {

    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group toDomain(GroupMO groupMO);

    GroupMO toMO(Group group);
}
