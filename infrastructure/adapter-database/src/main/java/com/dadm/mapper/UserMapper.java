package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserMO userMO);

    UserMO toMO(User user);

}
