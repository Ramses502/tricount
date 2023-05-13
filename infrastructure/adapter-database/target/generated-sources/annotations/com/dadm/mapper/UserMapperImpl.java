package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-13T13:21:09+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDomain(UserMO userMO) {
        if ( userMO == null ) {
            return null;
        }

        String name = null;
        String password = null;

        name = userMO.getName();
        password = userMO.getPassword();

        User user = new User( name, password );

        return user;
    }

    @Override
    public UserMO toMO(User user) {
        if ( user == null ) {
            return null;
        }

        UserMO userMO = new UserMO();

        userMO.setName( user.getName() );
        userMO.setPassword( user.getPassword() );

        return userMO;
    }
}
