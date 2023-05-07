package com.dadm.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ExpenseDTO {

    private Long id;

    private String title;

    private double quantity;
}
