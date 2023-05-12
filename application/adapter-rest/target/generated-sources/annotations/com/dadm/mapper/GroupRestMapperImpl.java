package com.dadm.mapper;

import com.dadm.model.Group;
import com.dadm.model.GroupDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-12T15:10:34+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
public class GroupRestMapperImpl implements GroupRestMapper {

    @Override
    public Group toDomain(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = groupDTO.getId();
        name = groupDTO.getName();

        Group group = new Group( id, name );

        return group;
    }

    @Override
    public GroupDTO toDTO(Group group) {
        if ( group == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = group.getId();
        name = group.getName();

        GroupDTO groupDTO = new GroupDTO( id, name );

        return groupDTO;
    }
}
