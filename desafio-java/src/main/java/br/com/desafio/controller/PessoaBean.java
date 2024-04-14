package br.com.desafio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.desafio.model.Pessoa;
import br.com.desafio.service.PessoaService;
import br.com.desafio.utility.CadastroException;
import br.com.desafio.utility.Message;

@Named("pessoabean")
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoa pessoa;

	@Inject
	private PessoaService service;

	private List<Pessoa> pessoas;

	public void carregar() {
		pessoas = service.todosOsCadastros();
	}

	public void adicionar() {
		try {
			service.salvar(pessoa);
			pessoa = new Pessoa();
			carregar();

			Message.info("Cadastrado com sucesso!");

		} catch (CadastroException e) {
			Message.erro(e.getMessage());
		}
	}

	public void excluir() {
		service.remover(pessoa);
		carregar();

		Message.info(pessoa.getNome() + " foi removido!");

	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void setService(PessoaService pessoaService) {
		this.service = service;
		
	}

}
