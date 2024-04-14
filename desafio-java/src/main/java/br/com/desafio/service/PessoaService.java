package br.com.desafio.service;

import java.io.Serializable;
import java.util.List;

import br.com.desafio.dao.DAO;
import br.com.desafio.model.Pessoa;
import br.com.desafio.utility.CadastroException;

import javax.inject.Inject;

public class PessoaService implements Serializable{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	@Inject
	private DAO<Pessoa> dao;
	
	public void salvar(Pessoa p) throws CadastroException {
		
		if (p.getNome().isEmpty()) {
			throw new CadastroException("O nome para cadastro não pode estar em branco!");
		}
		dao.salvar(p);
	}
	
	public void remover(Pessoa p) {
		dao.remover(Pessoa.class, p.getId());
	}
	
	public List<Pessoa> todosOsCadastros(){
		return dao.buscarTodos("select p from Pessoa p order by p.nome");
	}
}
