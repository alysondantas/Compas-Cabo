package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.uefs.ecomp.comprascabo.util.*;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.model.Cliente;

public class ActionVisualizarCliente implements ActionListener {
	private Controller controller;
	
	public ActionVisualizarCliente(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String idAux = JOptionPane.showInputDialog("Digite o ID do cliente que deseja visualizar!");
		if(idAux != null) {
		int id = Integer.parseInt(idAux);
		Cliente cliente = controller.listarClientes(id);
		if(cliente == null) {
			JOptionPane.showMessageDialog(null, "ERRO! Cliente n�o encontrado!");
			return;
		} else {
			String texto = "Cliente: \n";
			texto = texto + "Nome: " + cliente.getNome() + "\n";
			texto = texto + "CPF: " + cliente.getCpf() + "\n";
			texto = texto + "Data de nascimento: " + cliente.getDataNascimento() + "\n";
			texto = texto + "Estado: " + cliente.getEstado() + "\n";
			texto = texto + "Cidade: " + cliente.getCidade() + "\n";
			texto = texto + "Bairro: " + cliente.getBairro() + "\n";
			texto = texto + "Rua: " + cliente.getRua() + "\n";
			texto = texto + "N�mero: " + cliente.getNumero() + "\n";
			texto = texto + "Telefone: " + cliente.getNumeroTel() + "\n";
			texto = texto + "E-mail: " + cliente.getEmail();	
			JOptionPane.showMessageDialog(null, texto);
		}
	}
	}
}