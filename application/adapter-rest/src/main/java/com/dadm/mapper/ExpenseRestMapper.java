package com.dadm.mapper;

import com.dadm.model.Expense;
import com.dadm.model.ExpenseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExpenseRestMapper {

    ExpenseRestMapper INSTANCE = Mappers.getMapper(ExpenseRestMapper.class);

    Expense toDomain(ExpenseDTO expenseDTO);

    ExpenseDTO toDTO(Expense expense);
}
