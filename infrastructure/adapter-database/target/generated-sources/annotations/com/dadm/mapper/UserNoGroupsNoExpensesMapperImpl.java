package com.dadm.mapper;

import com.dadm.model.User;
import com.dadm.model.UserMO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T19:59:25+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class UserNoGroupsNoExpensesMapperImpl implements UserNoGroupsNoExpensesMapper {

    @Override
    public User toDomainNoGroupsNoExpenses(UserMO userMO) {
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
