package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.comprascabo.exceptions.ObjetoNaoEncontradoException;
import br.uefs.ecomp.comprascabo.model.Venda;

public class TelaCadastroVenda extends JFrame {
	
	private Controller controller;
	
	private JButton salvar;
	private JButton cancelar;
	private JButton limpar;
	private JButton visualizar;
	
	private JTextField produto;
	private JTextField quantidade;
	private JTextField cliente;
	
	private JLabel lProduto;
	private JLabel lQuantidade;
	private JLabel lCliente;

	private JLabel titulo;
	
	public TelaCadastroVenda(Controller controller) {
		this.controller = controller;
		this.setLayout(null); //sem layout pré-definido
		this.setLocationRelativeTo(null); //deixa a janela no centro na tela
		this.setResizable(false); //não pode ser redimensionada
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ao fechar a janela, fecha o programa
		this.setTitle("Cadastro de Venda");
		this.setSize(560, 240);
		
		salvar = new JButton("Salvar");
		limpar = new JButton("Limpar");
		cancelar = new JButton("Cancelar");
		visualizar = new JButton("Visualizar");
		
		produto = new JTextField();
		quantidade = new JTextField();
		cliente = new JTextField();
		
		lProduto = new JLabel("Produto:");
		lQuantidade = new JLabel("Quantidade:");
		lCliente = new JLabel("Cliente:");
		titulo = new JLabel("Cadastro de Venda");
		
		titulo.setBounds(10, 15, 150, 14);
		lProduto.setBounds(10, 90, 86, 14);
		produto.setBounds(68, 90, 200, 20);
		lCliente.setBounds(10, 50, 106, 14);
		cliente.setBounds(62, 50, 320, 20);
		lQuantidade.setBounds(300, 90, 96, 14);
		quantidade.setBounds(380, 90, 50, 20);
		
		salvar.setBounds(40, 140, 110, 50);
		visualizar.setBounds(160, 140, 110, 50);
		limpar.setBounds(280, 140, 110, 50);
		cancelar.setBounds(400, 140, 110, 50);
		
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		visualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idAux = JOptionPane.showInputDialog("Digite o ID da venda que deseja visualizar!");
				if(idAux != null) {
				int id = Integer.parseInt(idAux);
				Venda venda = controller.listarVendas(id);
				if(venda == null) {
					JOptionPane.showMessageDialog(null, "ERRO! venda não encontrado!");
					return;
				} else {
					String texto = "Venda: \n";
					texto = texto + "Cliente: " + venda.getCliente().getNome() + "\n";
					texto = texto + "Produto: " + venda.getProduto().getNome() + "\n";
					texto = texto + "Quantidade " + venda.getQuantidade() + "\n";
					JOptionPane.showMessageDialog(null, texto);
				}
			}
			}
		});
		limpar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		
		this.add(titulo);
		this.add(lProduto);
		this.add(produto);
		this.add(lQuantidade);
		this.add(quantidade);
		this.add(lCliente);
		this.add(cliente);
		this.add(salvar);
		this.add(cancelar);
		this.add(limpar);
		this.add(visualizar);
		
		this.setVisible(true);
	}
	
	public void cancelar() {
		this.dispose();
	}
	
	public void limpar() {
		produto.setText("");
		quantidade.setText("");
		cliente.setText("");
	}
	
	public void salvar() {
		 String produtoAux = produto.getText();
		 String quantidadeAux1 = quantidade.getText();
		 int quantidadeAux = Integer.parseInt(quantidadeAux1);
		 String clienteAux = cliente.getText();

			try {
				controller.cadastrarVenda(clienteAux, produtoAux, quantidadeAux);
				JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!!");
			} catch (CampoObrigatorioInexistenteException e) {
				JOptionPane.showMessageDialog(null, "ERRO! Campo Obrigatório não preenchido");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ObjetoNaoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void main (String[] args) {
		TelaCadastroVenda cad = new TelaCadastroVenda(new Controller());
	}
}
