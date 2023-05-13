package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-13T13:21:11+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserRestMapperImpl implements UserRestMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        String name = null;
        String password = null;

        name = user.getName();
        password = user.getPassword();

        UserDTO userDTO = new UserDTO( name, password );

        return userDTO;
    }

    @Override
    public User toDomain(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        String name = null;
        String password = null;

        name = userDTO.getName();
        password = userDTO.getPassword();

        User user = new User( name, password );

        return user;
    }
}
