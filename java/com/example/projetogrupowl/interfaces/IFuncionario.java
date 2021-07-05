package com.example.projetogrupowl.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.projetogrupowl.modelo.Funcionario;

@Repository
public interface IFuncionario extends CrudRepository<Funcionario, Integer> {

}
