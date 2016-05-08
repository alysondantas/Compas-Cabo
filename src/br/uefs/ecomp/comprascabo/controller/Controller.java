package br.uefs.ecomp.comprascabo.controller;

import br.uefs.ecomp.compascabo.exceptions.*;
import br.uefs.ecomp.comprascabo.model.*;
import br.uefs.ecomp.comprascabo.util.*;

public class Controller {
	
	Lista produtos;
	public Controller(){
		produtos = new Lista();
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
	
}
