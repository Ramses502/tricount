package com.dadm.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_group")
@IdClass(UserGroupMO.class)
public class UserGroupMO {
    @Id
    @ManyToOne
    UserMO user;

    @Id
    @ManyToOne
    GroupMO group;


    @Column(nullable = true)
    @Nullable
    private Double debt;
}
