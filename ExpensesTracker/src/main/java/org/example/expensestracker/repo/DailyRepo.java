package org.example.expensestracker.repo;

import org.example.expensestracker.model.DailyExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DailyRepo extends JpaRepository<DailyExpense, Long> {

    List<DailyExpense> getDailyExpenseByDate(Date date);
}
