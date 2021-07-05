package com.example.projetogrupowl.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.projetogrupowl.modelo.Funcionario;

public interface IFuncionarioService {

	public List<Funcionario> listar();

	public Optional<Funcionario> listarId(int id);

	public int save(Funcionario f);

	public void delete(int id);

}
