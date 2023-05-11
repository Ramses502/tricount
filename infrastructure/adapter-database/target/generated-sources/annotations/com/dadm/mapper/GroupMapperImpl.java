package com.dadm.mapper;

import com.dadm.model.Group;
import com.dadm.model.GroupMO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T23:02:33+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class GroupMapperImpl implements GroupMapper {

    @Override
    public Group toDomain(GroupMO groupMO) {
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

    @Override
    public GroupMO toMO(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupMO groupMO = new GroupMO();

        groupMO.setId( group.getId() );
        groupMO.setName( group.getName() );

        return groupMO;
    }
}
