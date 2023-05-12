package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-12T13:22:37+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class UserNoGroupsMapperImpl implements UserNoGroupsMapper {

    @Override
    public User toDomainNoGroups(UserMO userMO) {
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
}
