package com.dadm.mapper;

import com.dadm.model.Group;
import com.dadm.model.GroupMO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T23:09:19+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class GroupNoUsersMapperImpl implements GroupNoUsersMapper {

    @Override
    public Group toDomainNoUsers(GroupMO groupMO) {
        if ( groupMO == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = groupMO.getId();
        name = groupMO.getName();

        Group group = new Group( id, name );

        return group;
    }
}