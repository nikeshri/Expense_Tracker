package org.example.expensestracker.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class DailyExpenseDto {
    private Date date;
    private String category;
    private double amount;
    private String remark;
}
