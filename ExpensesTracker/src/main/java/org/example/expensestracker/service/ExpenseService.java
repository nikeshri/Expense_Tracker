package org.example.expensestracker.service;

import org.example.expensestracker.dto.DailyExpenseDto;
import org.example.expensestracker.model.DailyExpense;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface  ExpenseService {

   DailyExpenseDto addExpense(DailyExpenseDto dailyExpenseDto);
   List<DailyExpense> getAllExpenses();
   DailyExpenseDto getExpenseById(Long id);
   DailyExpenseDto updateExpense(Long id, DailyExpenseDto dailyExpenseDto);
   void deleteExpense(Long id);

   List<DailyExpense> getAllExpenseByDate(Date date);
}
