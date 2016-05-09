package br.uefs.ecomp.comprascabo.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import br.uefs.ecomp.comprascabo.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.comprascabo.exceptions.ObjetoNaoEncontradoException;
import br.uefs.ecomp.comprascabo.model.Cliente;
import br.uefs.ecomp.comprascabo.model.Fornecedor;
import br.uefs.ecomp.comprascabo.model.Produto;
import br.uefs.ecomp.comprascabo.model.Venda;
import br.uefs.ecomp.comprascabo.util.Lista;
import br.uefs.ecomp.comprascabo.util.MeuIterador;

public class Controller {

	Lista produtos;
	Lista clientes;
	Lista fornecedores;
	Lista vendas;
	public Controller(){
		produtos = new Lista();
		clientes = new Lista();
		fornecedores = new Lista();
		vendas = new Lista();
	}
	public void escreverTudoArquivo() throws IOException { //método deixado aqui só para inspiração. Não vai ser usado do jeito que está descrito no momento
		URL path = Controller.class.getResource("Produto.txt");
		File f = new File(path.getFile());
		BufferedWriter writer = new BufferedWriter(new FileWriter(f));
		String texto = "";
		MeuIterador iterador=(MeuIterador) produtos.iterador();
		Produto produto;
		texto = texto + "Produtos:\n";
		while(iterador.temProximo()){
			produto = (Produto) iterador.obterProximo();
			texto = texto + produto.getNome() + "\n";
			texto = texto + produto.getCodigoDeBarras() + "\n";
			texto = texto + produto.getDataValidade() + "\n";
			texto = texto + produto.getId() + "\n";
			texto = texto + produto.getFornecedor().getNome() + "\n";
		}
		texto = texto + "Clientes:\n";
		iterador = (MeuIterador) clientes.iterador();
		Cliente cliente;
		while(iterador.temProximo()){
			cliente = (Cliente) iterador.obterProximo();
			texto = texto + cliente.getNome() + "\n";
			texto = texto + cliente.getCpf() + "\n";
			texto = texto + cliente.getId() + "\n";
			texto = texto + cliente.getDataNascimento() + "\n";
			texto = texto + cliente.getEstado() + "\n";
			texto = texto + cliente.getCidade() + "\n";
			texto = texto + cliente.getBairro() + "\n";
			texto = texto + cliente.getRua() + "\n";
			texto = texto + cliente.getNumero() + "\n";
			texto = texto + cliente.getNumeroTel() + "\n";
			texto = texto + cliente.getEmail() + "\n";
		}
		texto = texto + "Fornecedores:\n";
		iterador = (MeuIterador) fornecedores.iterador();
		Fornecedor fornecedor;
		while(iterador.temProximo()){
			fornecedor = (Fornecedor) iterador.obterProximo();
			texto = texto + fornecedor.getNome() + "\n";
			texto = texto + fornecedor.getCnpj() + "\n";
			texto = texto + fornecedor.getId() + "\n";
			texto = texto + fornecedor.getTipo() + "\n";
			texto = texto + fornecedor.getEstado() + "\n";
			texto = texto + fornecedor.getCidade() + "\n";
			texto = texto + fornecedor.getBairro() + "\n";
			texto = texto + fornecedor.getRua() + "\n";
			texto = texto + fornecedor.getNumero() + "\n";
			texto = texto + fornecedor.getNumeroTel() + "\n";
			texto = texto + fornecedor.getEmail() + "\n";
		}
		texto = texto + "Fornecedores:\n";
		iterador = (MeuIterador) vendas.iterador();
		Venda venda;
		while(iterador.temProximo()){
			venda = (Venda) iterador.obterProximo();
			texto = texto + venda.getId() + "\n";
			texto = texto + venda.getQuantidade() + "\n";
			texto = texto + venda.getCliente().getNome() + "\n";
			texto = texto + venda.getProduto().getNome() + "\n";
		}
		writer.append(texto); //anexo essa string no arquivo de texto
		writer.close(); //fecho o arquivo aberto
	}
	public void cadastrarProduto(String nome, String nomeFornecedor, String dataValidade, String codigoBarras) throws CampoObrigatorioInexistenteException, ObjetoNaoEncontradoException, IOException{
		if(nome.trim().isEmpty() || nome == null || nomeFornecedor.trim().isEmpty() || nomeFornecedor == null || dataValidade.trim().isEmpty() || dataValidade == null || codigoBarras.trim().isEmpty() || codigoBarras == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Fornecedor fornece;
		fornece = obterFornecedor(nomeFornecedor);
		Produto produto = new Produto(nome, dataValidade, codigoBarras, fornece);
		produtos.inserirInicio(produto);
		escreverProduto(produto);
	}
	public MeuIterador listarProdutos(){
		return (MeuIterador) produtos.iterador();
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
	
	public Produto listarProdutos (int id) {
		MeuIterador it = (MeuIterador) produtos.iterador();
		while(it.temProximo()) {
			Produto c = (Produto)it.obterProximo();
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	public void cadastrarCliente(String nome, String dataNascimento, String cpf, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email) throws CampoObrigatorioInexistenteException, IOException{
		if(nome.trim().isEmpty() || nome == null || dataNascimento.trim().isEmpty() || dataNascimento == null || cpf.trim().isEmpty() || cpf == null || estado.trim().isEmpty() || estado == null || cidade.trim().isEmpty() || cidade == null || rua.trim().isEmpty() || rua == null || bairro.trim().isEmpty() || bairro == null || numero.trim().isEmpty() || numero == null || numeroTel.trim().isEmpty() || numeroTel == null || email.trim().isEmpty() || email == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Cliente cliente = new Cliente(nome,dataNascimento,cpf,estado,cidade, rua, bairro, numero, numeroTel, email);
		clientes.inserirInicio(cliente);
		escreverCliente(cliente);
	}
	
	public Cliente listarClientes (int id) {
		MeuIterador it = (MeuIterador) clientes.iterador();
		while(it.temProximo()) {
			Cliente c = (Cliente)it.obterProximo();
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
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

	public void cadastrarFornecedor(String nome, String tipo, String cnpj, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email) throws CampoObrigatorioInexistenteException, IOException{
		if(nome.trim().isEmpty() || nome == null || tipo.trim().isEmpty() || tipo == null || cnpj.trim().isEmpty() || email.trim().isEmpty() || email == null || numeroTel.trim().isEmpty() || numeroTel == null || numero.trim().isEmpty() || numero == null || bairro.trim().isEmpty() || bairro == null || cnpj == null || estado.trim().isEmpty() || estado == null || cidade.trim().isEmpty() || cidade == null || rua.trim().isEmpty() || rua == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Fornecedor fornecedor = new Fornecedor(nome, tipo, cnpj, estado, cidade, rua, bairro, numero, numeroTel, email);
		fornecedores.inserirInicio(fornecedor);
		escreverFornecedor(fornecedor);
	}
	public MeuIterador listarFornecedores(){
		return (MeuIterador) fornecedores.iterador();
	}
	public void editarFornecedor(String nome, String novoNome, String tipo, String cnpj, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email) throws ObjetoNaoEncontradoException, CampoObrigatorioInexistenteException{
		if(novoNome.trim().isEmpty() || novoNome == null || nome.trim().isEmpty() || nome == null || tipo.trim().isEmpty() || tipo == null || cnpj.trim().isEmpty() || email.trim().isEmpty() || email == null || numeroTel.trim().isEmpty() || numeroTel == null || numero.trim().isEmpty() || numero == null || bairro.trim().isEmpty() || bairro == null || cnpj == null || estado.trim().isEmpty() || estado == null || cidade.trim().isEmpty() || cidade == null || rua.trim().isEmpty() || rua == null){
			throw new CampoObrigatorioInexistenteException();
		}
		Fornecedor fornecedor = obterFornecedor(nome);
		fornecedor.setNome(novoNome);
		fornecedor.setTipo(tipo);
		fornecedor.setCidade(cidade);
		fornecedor.setBairro(bairro);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEmail(email);
		fornecedor.setEstado(estado);
		fornecedor.setNumero(numeroTel);
		fornecedor.setNumeroTel(numeroTel);
		fornecedor.setRua(rua);
	}
	public void excluirFornecedor(String nome) throws ObjetoNaoEncontradoException{
		MeuIterador iterador = (MeuIterador) fornecedores.iterador();
		int cont = 0;
		Fornecedor aux = null;
		while(iterador.temProximo()){
			aux = (Fornecedor) iterador.obterProximo();
			if(aux.getNome().equals(nome)){
				fornecedores.remover(cont);
			}
			cont++;
		}
		if(aux == null){
			throw new ObjetoNaoEncontradoException();
		}
	}
	public Fornecedor obterFornecedor(String nome) throws ObjetoNaoEncontradoException{
		if(fornecedores.estaVazia()){
			throw new ObjetoNaoEncontradoException();
		}
		Fornecedor fornecedor = null;
		MeuIterador iterador = (MeuIterador) fornecedores.iterador();
		while(iterador.temProximo()){
			fornecedor = (Fornecedor) iterador.obterProximo();
			if(fornecedor.getNome().equals(nome)){
				break;
			}
		}
		if(fornecedor == null){
			throw new ObjetoNaoEncontradoException();
		}else{
			return fornecedor;
		}
	}
	
	public Fornecedor listarFornecedores (int id) {
		MeuIterador it = (MeuIterador) fornecedores.iterador();
		while(it.temProximo()) {
			Fornecedor c = (Fornecedor)it.obterProximo();
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	public void cadastrarVenda(String nomeCliente, String nomeProduto, int quantidade) throws CampoObrigatorioInexistenteException, ObjetoNaoEncontradoException, IOException{
		if(nomeCliente.trim().isEmpty() || nomeCliente == null || nomeProduto.trim().isEmpty() || nomeProduto == null || quantidade == 0){
			throw new CampoObrigatorioInexistenteException();
		}
		Produto produto = obterProduto(nomeProduto);
		Cliente cliente = obterCliente(nomeCliente);
		Venda venda = new Venda(cliente, produto, quantidade);
		vendas.inserirInicio(venda);
		escreverVenda(venda);
	}
	
	public Venda listarVendas (int id) {
		MeuIterador it = (MeuIterador) vendas.iterador();
		while(it.temProximo()) {
			Venda c = (Venda)it.obterProximo();
			if(c.getId() == id) {
				return c;
			}
		}
		return null;
	}
	
	public void editarVenda(int id, String nomeNovoCliente, String nomeNovoProduto, int quantidade) throws ObjetoNaoEncontradoException, CampoObrigatorioInexistenteException{
		if(id < 0 || nomeNovoCliente.trim().isEmpty() || nomeNovoCliente == null || nomeNovoProduto.trim().isEmpty() || nomeNovoProduto == null || quantidade == 0){
			throw new CampoObrigatorioInexistenteException();
		}
		Produto produto = obterProduto(nomeNovoProduto);
		Cliente cliente = obterCliente(nomeNovoCliente);
		Venda venda = obterVenda(id);
		venda.setCliente(cliente);
		venda.setProduto(produto);
		venda.setQuantidade(quantidade);
	}
	public void excluirVenda(int id) throws ObjetoNaoEncontradoException{
		MeuIterador iterador = (MeuIterador) vendas.iterador();
		int cont = 0;
		Venda aux = null;
		while(iterador.temProximo()){
			aux = (Venda) iterador.obterProximo();
			if(aux.getId() == id){
				vendas.remover(cont);
			}
			cont++;
		}
		if(aux == null){
			throw new ObjetoNaoEncontradoException();
		}
	}
	public Venda obterVenda(int id) throws ObjetoNaoEncontradoException{
		if(vendas.estaVazia()){
			throw new ObjetoNaoEncontradoException();
		}
		Venda venda = null;
		MeuIterador iterador = (MeuIterador) vendas.iterador();
		while(iterador.temProximo()){
			venda = (Venda) iterador.obterProximo();
			if(venda.getId() == id){
				break;
			}
		}
		if(venda == null){
			throw new ObjetoNaoEncontradoException();
		}else{
			return venda;
		}
	}

	public void escreverCliente(Cliente cliente) throws IOException {
		File f = new File("Cliente.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
		String texto = "";
		texto = texto + "Cliente: \n";
		texto = texto + "Nome: " + cliente.getNome() + "\n";
		texto = texto + "CPF: " + cliente.getCpf() + "\n";
		texto = texto + "ID: " + cliente.getId() + "\n";
		texto = texto + "Data de Nascimento: " + cliente.getDataNascimento() + "\n";
		texto = texto + "Estado: " + cliente.getEstado() + "\n";
		texto = texto + "Cidade: " + cliente.getCidade() + "\n";
		texto = texto + "Bairro: " + cliente.getBairro() + "\n";
		texto = texto + "Rua: " + cliente.getRua() + "\n";
		texto = texto + "Número: " + cliente.getNumero() + "\n";
		texto = texto + "Telefone: " + cliente.getNumeroTel() + "\n";
		texto = texto + "E-mail: " + cliente.getEmail() + "\n";
		writer.append(texto); //anexo essa string no arquivo de texto
		writer.close(); //fecho o arquivo aberto
	}

	public void escreverFornecedor(Fornecedor fornecedor) throws IOException {
		File f = new File("Fornecedor.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
		String texto = "";
		texto = texto + "Fornecedor :\n";
		texto = texto + "Nome: " +fornecedor.getNome() + "\n";
		texto = texto + "CNPJ: " + fornecedor.getCnpj() + "\n";
		texto = texto + "ID: " + fornecedor.getId() + "\n";
		texto = texto + "Tipo: " + fornecedor.getTipo() + "\n";
		texto = texto + "Estado: " + fornecedor.getEstado() + "\n";
		texto = texto + "Cidade: " + fornecedor.getCidade() + "\n";
		texto = texto + "Bairro: " + fornecedor.getBairro() + "\n";
		texto = texto + "Rua: " + fornecedor.getRua() + "\n";
		texto = texto + "Número: " + fornecedor.getNumero() + "\n";
		texto = texto + "Telefone: " + fornecedor.getNumeroTel() + "\n";
		texto = texto + "E-mail: " + fornecedor.getEmail() + "\n";
		writer.append(texto); //anexo essa string no arquivo de texto
		writer.close(); //fecho o arquivo aberto
	}

	public void escreverProduto(Produto produto) throws IOException {
		File f = new File("Produto.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
		String texto = "";
		texto = texto + "Produto :\n";
		texto = texto + "Nome: " + produto.getNome() + "\n";
		texto = texto + "Código de barras: " + produto.getCodigoDeBarras() + "\n";
		texto = texto + "Data de validade: " + produto.getDataValidade() + "\n";
		texto = texto + "ID: " + produto.getId() + "\n";
		texto = texto + "Fornecedor: " + produto.getFornecedor().getNome() + "\n";
		writer.append(texto); //anexo essa string no arquivo de texto
		writer.close(); //fecho o arquivo aberto
	}

	public void escreverVenda(Venda venda) throws IOException {
		File f = new File("Venda.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(f, true));
		String texto = "";
		texto = texto + "Venda :\n";
		texto = texto + "ID: " + venda.getId() + "\n";
		texto = texto + "Quantidade: " + venda.getQuantidade() + "\n";
		texto = texto + "Cliente: " + venda.getCliente().getNome() + "\n";
		texto = texto + "Produto: " + venda.getProduto().getNome() + "\n";
		writer.append(texto); //anexo essa string no arquivo de texto
		writer.close(); //fecho o arquivo aberto
	}

}
