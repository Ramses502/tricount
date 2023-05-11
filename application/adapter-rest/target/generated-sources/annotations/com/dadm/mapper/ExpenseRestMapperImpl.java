package com.dadm.mapper;

import com.dadm.model.Expense;
import com.dadm.model.ExpenseDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T23:09:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class ExpenseRestMapperImpl implements ExpenseRestMapper {

    @Override
    public Expense toDomain(ExpenseDTO expenseDTO) {
        if ( expenseDTO == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        double quantity = 0.0d;

        id = expenseDTO.getId();
        title = expenseDTO.getTitle();
        quantity = expenseDTO.getQuantity();

        Expense expense = new Expense( id, title, quantity );

        return expense;
    }

    @Override
    public ExpenseDTO toDTO(Expense expense) {
        if ( expense == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        double quantity = 0.0d;

        id = expense.getId();
        title = expense.getTitle();
        quantity = expense.getQuantity();

        ExpenseDTO expenseDTO = new ExpenseDTO( id, title, quantity );

        return expenseDTO;
    }
}
