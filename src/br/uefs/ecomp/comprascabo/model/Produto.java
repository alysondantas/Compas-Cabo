package br.uefs.ecomp.comprascabo.model;
/**
 * Classe produto:
 * Irá conter os atributos do produto a ser cadastrado no sistema e consequentemente a ser disponibilizado ao usuário.
 * @author Alyson Dantas, Bruno, Gustavo Henrique.
 * @since 06 de maio de 2016.
 *
 */

public class Produto {

	private String nome = null; // Nome do produto.
	private int id = 0; // Id do produto.
	private String codigoDeBarras = null; // Código de barras.
	/**
	 * Retorna o conteúdo de nome.
	 * @return nome - Conteúdo de nome.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Altera o conteúdo de nome para o conteúdo do parâmetro nome.
	 * @param nome - Novo conteúdo de nome.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Retorna o conteúdo de id.
	 * @return id - Conteúdo de id.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Altera o conteúdo de id para o conteúdo do parâmetro id.
	 * @param id - Novo conteúdo de id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Retorna o conteúdo de codigoDeBarras.
	 * @return codigoDeBarras - Conteúdo de codigoDeBarras.
	 */
	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}
	/**
	 * Altera o conteúdo de codigoDeBarras para o conteúdo do parâmetro codigoDeBarras.
	 * @param codigoDeBarras - Novo conteúdo de codigoDeBarras.
	 */
	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}
}
