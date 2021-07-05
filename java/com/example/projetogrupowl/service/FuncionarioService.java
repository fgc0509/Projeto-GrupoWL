package com.example.projetogrupowl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetogrupowl.interfaceService.IFuncionarioService;
import com.example.projetogrupowl.interfaces.IFuncionario;
import com.example.projetogrupowl.modelo.Funcionario;

@Service
public class FuncionarioService implements IFuncionarioService {

	@Autowired
	private IFuncionario data;

	@Override
	public List<Funcionario> listar() {

		return (List<Funcionario>) data.findAll();
	}

	@Override
	public Optional<Funcionario> listarId(int id) {

		return data.findById(id);
	}

	@Override
	public int save(Funcionario f) {
		int res = 0;
		Funcionario funcionario = data.save(f);
		if (!funcionario.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);

	}

}
