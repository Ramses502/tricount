package com.dadm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserMO {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_group",
            joinColumns = {
                    @JoinColumn(name = "user_name", referencedColumnName = "name")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "group_id", referencedColumnName = "id")
            }
    )
    private List<GroupMO> groups = new ArrayList<GroupMO>();

    @ManyToMany(mappedBy = "users")
    private List<ExpenseMO> expenses;
}
