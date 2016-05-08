package br.uefs.ecomp.comprascabo.model;
/**
 * Classe produto:
 * Ir� conter os atributos do produto a ser cadastrado no sistema e consequentemente a ser disponibilizado ao usu�rio.
 * @author Alyson Dantas, Bruno, Gustavo Henrique.
 * @since 06 de maio de 2016.
 *
 */

public class Produto {
	private static Integer serialId=0;//SerialID � quem vai definir o id de cada produto quando for criado 
	private String nome = null; // Nome do produto.
	private int id = 0; // Id do produto.
	private String dataValidade = null; //Campo para data de validade do produto
	private String codigoDeBarras = null; // C�digo de barras.
	private Fornecedor fornecedor;
	
	/**
	 * Construtor da classe para incrementar o SeriaID e dar o serial do produto
	 */
	public Produto(String nome, String dataValidade, String codigoBarras, Fornecedor fornecedor){
		serialId=serialId+1;//Incrementa o SerialID para que n�o se repita
		this.id=serialId;//id da doacao recebe o serialID da cria��o
		this.nome = nome;
		this.dataValidade = dataValidade;
		this.codigoDeBarras = codigoBarras;
		this.fornecedor = fornecedor;
	}
	
	/**
	 * Retorna o conte�do de nome.
	 * @return nome - Conte�do de nome.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Altera o conte�do de nome para o conte�do do par�metro nome.
	 * @param nome - Novo conte�do de nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Retorna o conte�do de id.
	 * @return id - Conte�do de id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Altera o conte�do de id para o conte�do do par�metro id.
	 * @param id - Novo conte�do de id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Retorna o conte�do de codigoDeBarras.
	 * @return codigoDeBarras - Conte�do de codigoDeBarras.
	 */
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	/**
	 * Altera o conte�do de codigoDeBarras para o conte�do do par�metro codigoDeBarras.
	 * @param codigoDeBarras - Novo conte�do de codigoDeBarras.
	 */
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
