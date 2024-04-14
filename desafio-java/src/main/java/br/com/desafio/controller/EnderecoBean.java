package br.com.desafio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.desafio.model.Endereco;
import br.com.desafio.service.EnderecoService;
import br.com.desafio.utility.CadastroException;
import br.com.desafio.utility.Message;

@Named("endbean")
@ViewScoped
public class EnderecoBean implements Serializable{



	private static final long serialVersionUID = 1L;
	
	@Inject
	private Endereco endereco;
	
	@Inject
	private EnderecoService service;
	
	
	private List<Endereco> enderecos;
	
	public void carregar() {
		enderecos = service.todosOsCadastros();
	}

	public void adicionar() {
		try {
			service.salvar(endereco);
			endereco = new Endereco();
			carregar();

			Message.info("Cadastrado com sucesso!");

		} catch (CadastroException e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluir() {
		service.remover(endereco);
		carregar();

		Message.info(endereco.getId() + " foi removido!");

	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


}
