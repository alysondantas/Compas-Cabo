package br.uefs.ecomp.comprascabo.controller;

import br.uefs.ecomp.compascabo.exceptions.*;
import br.uefs.ecomp.comprascabo.model.*;
import br.uefs.ecomp.comprascabo.util.*;

public class Controller {
	
	Lista produtos;
	Lista clientes;
	public Controller(){
		produtos = new Lista();
		clientes = new Lista();
	}
	
	public void cadastrarProduto(String nome, String dataValidade, String codigoBarras) throws CampoObrigatorioInexistenteException{
		if(nome.trim().isEmpty() || nome == null || dataValidade.trim().isEmpty() || dataValidade == null || codigoBarras.trim().isEmpty() || codigoBarras == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Produto produto = new Produto(nome, dataValidade, codigoBarras);
		produtos.inserirInicio(produto);
	}
	public void editarProduto(String nome, String novoNome, String dataValidade, String codigoBarras) throws ObjetoNaoEncontradoException, CampoObrigatorioInexistenteException{
		if(nome.trim().isEmpty() || nome == null || novoNome.trim().isEmpty() || novoNome == null || dataValidade.trim().isEmpty() || dataValidade == null || codigoBarras.trim().isEmpty() || codigoBarras == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Produto produto = obterProduto(nome);
		produto.setNome(novoNome);
		produto.setCodigoDeBarras(codigoBarras);
		produto.setDataValidade(dataValidade);
	}
	
	public void excluirProduto(String nome) throws ObjetoNaoEncontradoException{
		MeuIterador iterador = (MeuIterador) produtos.iterador();
		int cont = 0;
		Produto aux = null;
		while(iterador.temProximo()){
			aux = (Produto) iterador.obterProximo();
			if(aux.getNome().equals(nome)){
				produtos.remover(cont);
			}
			cont++;
		}
		if(aux == null){
			throw new ObjetoNaoEncontradoException();
		}
	}
	public Produto obterProduto(String nome) throws ObjetoNaoEncontradoException{
		if(produtos.estaVazia()){
			throw new ObjetoNaoEncontradoException();
		}
		Produto produto = null;
		MeuIterador iterador = (MeuIterador) produtos.iterador();
		while(iterador.temProximo()){
			produto = (Produto) iterador.obterProximo();
			if(produto.getNome().equals(nome)){
				break;
			}
		}
		if(produto == null){
			throw new ObjetoNaoEncontradoException();
		}else{
			return produto;
		}
	}
	
	public void cadastrarCliente(String nome, String dataNascimento, String cpf, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email) throws CampoObrigatorioInexistenteException{
		if(nome.trim().isEmpty() || nome == null || dataNascimento.trim().isEmpty() || dataNascimento == null || cpf.trim().isEmpty() || cpf == null || estado.trim().isEmpty() || estado == null || cidade.trim().isEmpty() || cidade == null || rua.trim().isEmpty() || rua == null || bairro.trim().isEmpty() || bairro == null || numero.trim().isEmpty() || numero == null || numeroTel.trim().isEmpty() || numeroTel == null || email.trim().isEmpty() || email == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Cliente cliente = new Cliente(nome,dataNascimento,cpf,estado,cidade, rua, bairro, numero, numeroTel, email);
		clientes.inserirInicio(cliente);
	}
	public void editarCliente(String nome, String novoNome, String dataNascimento, String cpf, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email) throws ObjetoNaoEncontradoException, CampoObrigatorioInexistenteException{
		if(nome.trim().isEmpty() || nome == null || dataNascimento.trim().isEmpty() || dataNascimento == null || cpf.trim().isEmpty() || cpf == null || estado.trim().isEmpty() || estado == null || cidade.trim().isEmpty() || cidade == null || rua.trim().isEmpty() || rua == null || bairro.trim().isEmpty() || bairro == null || numero.trim().isEmpty() || numero == null || numeroTel.trim().isEmpty() || numeroTel == null || email.trim().isEmpty() || email == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Cliente cliente = obterCliente(nome);
		cliente.setNome(novoNome);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCidade(cidade);
		cliente.setBairro(bairro);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setEstado(estado);
		cliente.setNumero(numeroTel);
		cliente.setNumeroTel(numeroTel);
		cliente.setRua(rua);
	}
	public void excluirCliente(String nome) throws ObjetoNaoEncontradoException{
		MeuIterador iterador = (MeuIterador) clientes.iterador();
		int cont = 0;
		Cliente aux = null;
		while(iterador.temProximo()){
			aux = (Cliente) iterador.obterProximo();
			if(aux.getNome().equals(nome)){
				clientes.remover(cont);
			}
			cont++;
		}
		if(aux == null){
			throw new ObjetoNaoEncontradoException();
		}
	}
	
	public Cliente obterCliente(String nome) throws ObjetoNaoEncontradoException{
		if(clientes.estaVazia()){
			throw new ObjetoNaoEncontradoException();
		}
		Cliente cliente = null;
		MeuIterador iterador = (MeuIterador) clientes.iterador();
		while(iterador.temProximo()){
			cliente = (Cliente) iterador.obterProximo();
			if(cliente.getNome().equals(nome)){
				break;
			}
		}
		if(cliente == null){
			throw new ObjetoNaoEncontradoException();
		}else{
			return cliente;
		}
	}
}
