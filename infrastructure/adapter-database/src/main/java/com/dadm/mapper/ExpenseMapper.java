package com.dadm.mapper;

import com.dadm.model.Expense;
import com.dadm.model.ExpenseMO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseMapper {

    ExpenseMapper INSTANCE = Mappers.getMapper(ExpenseMapper.class);

    Expense toDomain(ExpenseMO expenseMO);

    ExpenseMO toMO(Expense expense);
}
