package com.codingdojo.com.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.com.safetravels.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long>{

	List<Expense> findAll();
}
