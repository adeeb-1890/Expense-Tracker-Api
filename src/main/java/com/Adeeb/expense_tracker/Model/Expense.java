package com.Adeeb.expense_tracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Setter;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @Setter
    @Positive
    private double amount;

    public Expense() {}

    public Expense(String name, String category, double amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public Long getId() { return id; }
    public String getName() { return name; }

    public String getCategory() { return category; }

    public double getAmount() { return amount; }
}
