package com.example.expensetracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Handles REST endpoint calls coming from React frontend
@RestController
@RequestMapping("/api/v1/expenses")
@CrossOrigin(origins = "*") // Allows local React frontend to call this endpoint without CORS issues
public class ExpenseController {

    private final ExpenseRepository repo;

    // Constructor injection for repository dependency
    public ExpenseController(ExpenseRepository repo) {
        this.repo = repo;
    }

    // GET /api/v1/expenses -> Returns list of all expenses sorted by date
    @GetMapping
    public List<Expense> getExpenses() {
        return repo.findAllByOrderByDateDesc();
    }

    // POST /api/v1/expenses -> Creates and saves a new expense
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        // Quick server-side validation
        if (expense.getAmount() == null || expense.getAmount() <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Expense created = repo.save(expense);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // DELETE /api/v1/expenses/{id} -> Removes entry by primary key ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}