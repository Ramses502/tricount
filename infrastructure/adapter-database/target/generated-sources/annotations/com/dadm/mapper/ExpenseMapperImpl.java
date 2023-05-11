package com.dadm.mapper;

import com.dadm.model.Expense;
import com.dadm.model.ExpenseMO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-11T23:09:19+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
public class ExpenseMapperImpl implements ExpenseMapper {

    @Override
    public Expense toDomain(ExpenseMO expenseMO) {
        if ( expenseMO == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        double quantity = 0.0d;

        id = expenseMO.getId();
        title = expenseMO.getTitle();
        quantity = expenseMO.getQuantity();

        Expense expense = new Expense( id, title, quantity );

        return expense;
    }

    @Override
    public ExpenseMO toMO(Expense expense) {
        if ( expense == null ) {
            return null;
        }

        ExpenseMO expenseMO = new ExpenseMO();

        expenseMO.setId( expense.getId() );
        expenseMO.setTitle( expense.getTitle() );
        expenseMO.setQuantity( expense.getQuantity() );

        return expenseMO;
    }
}
