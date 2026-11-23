package com.example.expensetracker;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository gives us built-in CRUD (save, findAll, deleteById) out of the box
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
    // Custom query method: fetches expenses sorted by date (latest first)
    List<Expense> findAllByOrderByDateDesc();
}