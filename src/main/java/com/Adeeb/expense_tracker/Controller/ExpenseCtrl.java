package com.Adeeb.expense_tracker.Controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepo;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseCtrl {
    private final ExpenseRepo repo;

    public ExpenseCtrl(ExpenseRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Expense> getAll(@RequestParam(required = false) String category,
                                @RequestParam(required = false) String sort) {
        List<Expense> list = repo.findAll();
        if(category != null) {
            list = list.stream().filter(e -> e.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
        }
        if("amountAsc".equals(sort)) list.sort(Comparator.comparingDouble(Expense::getAmount));
        if("amountDesc".equals(sort)) list.sort(Comparator.comparingDouble(Expense::getAmount).reversed());
        return list;
    }

    @PostMapping
    public Expense add(@RequestBody Expense e) { return repo.save(e); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repo.deleteById(id); }

    @GetMapping("/summary")
    public Map<String, Double> summary() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)));
    }
}
