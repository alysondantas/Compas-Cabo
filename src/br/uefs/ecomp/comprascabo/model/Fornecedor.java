package br.uefs.ecomp.comprascabo.model;

public class Fornecedor {
	private static Integer serialId=0;//SerialID é quem vai definir o id de cada produto quando for criado 
	private int id = 0; // Id do produto.
	private String nome;
	private String tipo;
	private String cnpj;
	private String estado;
	private String cidade;
	private String rua;
	private String bairro;
	private String numero;
	private String numeroTel;
	private String email;
	
	public Fornecedor(String nome, String tipo, String cnpj, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email){
		serialId=serialId+1;//Incrementa o SerialID para que não se repita
		this.id= serialId;//id da doacao recebe o serialID da criação
		this.nome = nome;
		this.tipo = tipo;
		this.cnpj = cnpj;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.numeroTel = numeroTel;
		this.email = email;
	}

	public Fornecedor() {
		
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
