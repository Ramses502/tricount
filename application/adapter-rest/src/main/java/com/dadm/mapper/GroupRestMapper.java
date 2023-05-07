package com.dadm.mapper;

import com.dadm.model.Group;
import com.dadm.model.GroupDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupRestMapper {

    GroupRestMapper INSTANCE = Mappers.getMapper(GroupRestMapper.class);

    Group toDomain(GroupDTO groupDTO);

    GroupDTO toDTO(Group group);
}
