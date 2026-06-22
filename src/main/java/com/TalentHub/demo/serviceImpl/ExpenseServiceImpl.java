package com.TalentHub.demo.serviceImpl;

import com.TalentHub.demo.dto.ExpenseRequest;
import com.TalentHub.demo.dto.ExpenseResponse;
import com.TalentHub.demo.entity.Category;
import com.TalentHub.demo.entity.Expense;
import com.TalentHub.demo.repository.CategoryRepository;
import com.TalentHub.demo.repository.ExpenseRepository;
import com.TalentHub.demo.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;


    @Override
    public ExpenseResponse createExpense(ExpenseRequest expenseRequest){

        Category category = categoryRepository.findById(expenseRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Expense expense =modelMapper.map(expenseRequest, Expense.class);
        expense.setCategory(category); // bcz its a object and modelmapper can't map it!

        Expense savedExpense = expenseRepository.save(expense);
        return modelMapper.map(expense ,ExpenseResponse.class);

    }

    @Override
    public ExpenseResponse updateExpense(Long id, ExpenseRequest expenseRequest){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Expense Not Found"));

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Category Not Found"));

        expense.setDescription(expenseRequest.getDescription());
        expense.setAmount(expenseRequest.getAmount());
        expense.setDate(expenseRequest.getDate());
        expense.setCategory(category);

        Expense updatedExpense = expenseRepository.save(expense);

        return modelMapper.map(updatedExpense, ExpenseResponse.class);
    }



    @Override
    public List<ExpenseResponse> getAllExpenses(){

        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map(expense -> modelMapper.map(expense, ExpenseResponse.class))
                .toList();
    }

    public ExpenseResponse getResponseById(Long id){

        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found at id:" +id));
        return modelMapper.map(expense ,ExpenseResponse.class);

    }







}
