package br.uefs.ecomp.comprascabo.model;

public class Cliente {
	private static Integer serialId=0;//SerialID é quem vai definir o id de cada produto quando for criado 
	private int id = 0; // Id do produto.
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String estado;
	private String cidade;
	private String rua;
	private String bairro;
	private String numero;
	private String numeroTel;
	private String email;
	
	public Cliente(String nome, String dataNascimento, String cpf, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email){
		serialId=serialId+1;//Incrementa o SerialID para que não se repita
		this.id = serialId;//id da doacao recebe o serialID da criação
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
		this.setCidade(cidade);
		this.setCpf(cpf);
		this.setEstado(estado);
		this.setRua(rua);
		this.setBairro(bairro);
		this.setNumero(numero);
		this.setNumeroTel(numeroTel);
		this.setEmail(email);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public int getId() {
		return id;
	}

}
