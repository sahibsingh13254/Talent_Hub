package com.TalentHub.demo.repository;

import com.TalentHub.demo.entity.Category;
import com.TalentHub.demo.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long>{
}
