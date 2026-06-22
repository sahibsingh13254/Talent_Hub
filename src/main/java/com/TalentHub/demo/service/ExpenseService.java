package com.TalentHub.demo.service;

import com.TalentHub.demo.dto.ExpenseRequest;
import com.TalentHub.demo.dto.ExpenseResponse;

import java.util.List;

public interface ExpenseService {

    ExpenseResponse createExpense(ExpenseRequest expenseRequest);
    List<ExpenseResponse> getAllExpenses();
    ExpenseResponse getResponseById(Long id);
    void deleteExpense(Long id);
    ExpenseResponse updateExpense(Long id, ExpenseRequest expenseRequest);

}
