package org.example.expensestracker.controller;

import lombok.RequiredArgsConstructor;
import org.example.expensestracker.dto.DailyExpenseDto;
import org.example.expensestracker.model.DailyExpense;
import org.example.expensestracker.service.ExpenseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/expenses")
public class DailyExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<DailyExpenseDto> addExpense(@Validated @RequestBody DailyExpenseDto dailyExpenseDto) {
        DailyExpenseDto savedExpense = expenseService.addExpense(dailyExpenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DailyExpense>> getAllExpenses() {
        List<DailyExpense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DailyExpenseDto> getExpenseById(@PathVariable Long id) {
        DailyExpenseDto expense = expenseService.getExpenseById(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DailyExpenseDto> updateExpense(@PathVariable Long id, @Validated @RequestBody DailyExpenseDto dailyExpenseDto) {
        DailyExpenseDto updatedExpense = expenseService.updateExpense(id, dailyExpenseDto);
        return new ResponseEntity<>(updatedExpense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/date")
    public ResponseEntity<List<DailyExpense>> getAllDataByDate(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<DailyExpense> dailyExpenses = expenseService.getAllExpenseByDate(date);
        if (dailyExpenses != null && !dailyExpenses.isEmpty()) {
            return ResponseEntity.ok(dailyExpenses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
