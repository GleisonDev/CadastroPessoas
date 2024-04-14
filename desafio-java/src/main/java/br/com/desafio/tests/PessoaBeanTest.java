package br.com.desafio.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.desafio.controller.PessoaBean;
import br.com.desafio.model.Pessoa;
import br.com.desafio.service.PessoaService;
import br.com.desafio.utility.CadastroException;

public class PessoaBeanTest {

    private PessoaBean pessoaBean;
    
    private PessoaService pessoaService;
    
    @Before
    public void setUp() {
        pessoaBean = new PessoaBean();
        pessoaService = new PessoaService();
        pessoaBean.setPessoa(new Pessoa());
        pessoaBean.setService(pessoaService);
    }
    
    @Test
    public void testAdicionar() {
        int tamanhoAntes = pessoaBean.getPessoas().size();
        pessoaBean.adicionar();
        int tamanhoDepois = pessoaBean.getPessoas().size();
        assertEquals(tamanhoAntes + 1, tamanhoDepois);
    }

    @Test
    public void testExcluir() throws CadastroException {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Teste");
        pessoaService.salvar(pessoa);
        pessoaBean.setPessoas(pessoaService.todosOsCadastros());
        
        int tamanhoAntes = pessoaBean.getPessoas().size();
        pessoaBean.excluir();
        int tamanhoDepois = pessoaBean.getPessoas().size();
        assertEquals(tamanhoAntes - 1, tamanhoDepois);
    }
}

