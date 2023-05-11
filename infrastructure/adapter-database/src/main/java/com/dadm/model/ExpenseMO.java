package com.dadm.model;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpenseMO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String title;

    @Column
    private double quantity;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "UserExpense",
            joinColumns = {
                    @JoinColumn(name = "expense_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_name", referencedColumnName = "name")
            }
    )
    private List<UserMO> users;
}
