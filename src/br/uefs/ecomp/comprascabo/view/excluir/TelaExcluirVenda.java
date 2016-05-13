package br.uefs.ecomp.comprascabo.view.excluir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.exceptions.ObjetoNaoEncontradoException;

public class TelaExcluirVenda{

	private Controller controller = null;
	private JFrame frame = null;
	private JPanel panelPrincipal = null;
	private JTextField textField = null;

	private JLabel labelNome = null;

	public TelaExcluirVenda(Controller controller){
		frame = new JFrame("Excluir Venda");
		this.controller = controller;
		frame.setLayout(null); //sem layout pré-definido
		frame.setSize(360, 200);
		frame.setLocationRelativeTo(null); //deixa a janela no centro na tela
		frame.setResizable(false); //não pode ser redimensionada
		frame.setVisible(true);

		panelPrincipal = new JPanel();
		panelPrincipal.setSize(360, 200);
		panelPrincipal.setLayout(null);
		frame.add(panelPrincipal);

		montarTela();
	}

	private void montarTela(){
		prepararPanelPrincipal();
	}

	private void prepararPanelPrincipal(){
		prepararLabel();
		prepararTextField();
		prepararBotoes();
		frame.repaint();
	}

	private void prepararTextField(){
		textField = new JTextField();
		textField.setBounds(100, 40, 140, 20);
		textField.setText("");
		panelPrincipal.add(textField);
	}

	private void prepararLabel(){
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(40, 40, 40, 20);
		panelPrincipal.add(labelNome);
	}

	private void prepararBotoes(){
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.setBounds(100, 60, 140, 30);

		botaoExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				if(nome.trim() == ""){
					JOptionPane.showMessageDialog(null, "Digite um nome válido!");
					return;
				}
				try {
					controller.excluirCliente(nome);
				} catch (ObjetoNaoEncontradoException e1) {
					JOptionPane.showMessageDialog(null, "A Venda não foi encontrada!");
				}
			}
		});

		panelPrincipal.add(botaoExcluir);
	}
}
