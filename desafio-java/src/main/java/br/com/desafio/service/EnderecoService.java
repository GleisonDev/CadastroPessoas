package br.com.desafio.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.desafio.dao.DAO;
import br.com.desafio.model.Endereco;

import br.com.desafio.utility.CadastroException;

public class EnderecoService implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Endereco> dao;
	
	public void salvar(Endereco e) throws CadastroException {
		
		if (e.getEstado().isEmpty()|| e.getCep().isEmpty() || e.getLogradouro().isEmpty()|| e.getNumero() == 0) {
			throw new CadastroException("Preencha todos os campos corretamente!");
		}
		dao.salvar(e);
	}
	
	public void remover(Endereco e) {
		dao.remover(Endereco.class, e.getId());
	}
	
	public List<Endereco> todosOsCadastros(){
		return dao.buscarTodos("select e from endereco e order by e.id");
	}

}
