package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.comprascabo.model.Cliente;

public class ActionCadastroCliente implements ActionListener {

	private Controller controller;
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
	
	public ActionCadastroCliente(Controller controller, String nome, String dataNascimento, String cpf, String estado, String cidade, String rua, String bairro, String numero, String numeroTel, String email) {
		this.controller = controller;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.numeroTel = numeroTel;
		this.email = email;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Cliente cliente = new Cliente(nome, dataNascimento, cpf, estado, cidade, rua, bairro, numero, numeroTel, email);
		try {
			controller.cadastrarCliente(nome, dataNascimento, cpf, estado, cidade, rua, bairro, numero, numeroTel, email);
			controller.escreverCliente(cliente);
		} catch (CampoObrigatorioInexistenteException e) {
			JOptionPane.showMessageDialog(null, "ERRO! Campo Obrigatório não preenchido");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
