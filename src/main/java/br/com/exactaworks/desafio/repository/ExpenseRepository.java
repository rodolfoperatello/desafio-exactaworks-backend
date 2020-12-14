package br.com.exactaworks.desafio.repository;

import br.com.exactaworks.desafio.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
