package com.TalentHub.demo.repository;

import com.TalentHub.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Category,Long>{
}
