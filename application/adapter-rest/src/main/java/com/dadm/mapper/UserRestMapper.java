package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRestMapper {

    UserRestMapper INSTANCE = Mappers.getMapper(UserRestMapper.class);

    UserDTO toDTO(User user);

    User toDomain(UserDTO userDTO);
}
