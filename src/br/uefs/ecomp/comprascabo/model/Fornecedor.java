package br.uefs.ecomp.comprascabo.model;

public class Fornecedor {
	private static Integer serialId=0;//SerialID é quem vai definir o id de cada produto quando for criado 
	private int id = 0; // Id do produto.
	private String nome;
	private String tipo;
	
	public Fornecedor(String nome, String tipo){
		serialId=serialId+1;//Incrementa o SerialID para que não se repita
		this.id= serialId;//id da doacao recebe o serialID da criação
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

}
