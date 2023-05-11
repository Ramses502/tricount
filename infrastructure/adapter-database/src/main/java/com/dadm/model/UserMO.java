package com.dadm.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserGroupMO> groups = new ArrayList<UserGroupMO>();

    @ManyToMany(mappedBy = "users")
    private List<ExpenseMO> expenses;
}
