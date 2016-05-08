package br.uefs.ecomp.comprascabo.model;

public class Venda {
	private static Integer serialId=0;//SerialID é quem vai definir o id de cada produto quando for criado 
	private int id = 0; // Id do produto.
	private Cliente cliente;
	private Produto produto;
	private int quantidade;
	
	public Venda(Cliente cliente, Produto produto, int quantidade){
		serialId=serialId+1;//Incrementa o SerialID para que não se repita
		this.id= serialId;//id da doacao recebe o serialID da criação
		this.cliente = cliente;
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public int getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
