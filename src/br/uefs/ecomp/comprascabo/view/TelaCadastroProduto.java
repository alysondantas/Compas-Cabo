package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.comprascabo.exceptions.ObjetoNaoEncontradoException;
import br.uefs.ecomp.comprascabo.model.Produto;

public class TelaCadastroProduto extends JFrame {
	
	private Controller controller;
	
	private JButton salvar;
	private JButton cancelar;
	private JButton limpar;
	private JButton visualizar;
	
	private JTextField nome;
	private JTextField dataValidade;
	private JTextField codigoBarras;
	private JTextField fornecedor;
	
	private JLabel lNome;
	private JLabel lDataValidade;
	private JLabel lCodigoBarras;
	private JLabel lFornecedor;

	private JLabel titulo;
	
	public TelaCadastroProduto(Controller controller) {
		this.controller = controller;
		this.setLayout(null); //sem layout pré-definido
		this.setLocationRelativeTo(null); //deixa a janela no centro na tela
		this.setResizable(false); //não pode ser redimensionada
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //ao fechar a janela, fecha o programa
		this.setTitle("Cadastro de Produto");
		this.setSize(560, 275);
		
		salvar = new JButton("Salvar");
		limpar = new JButton("Limpar");
		cancelar = new JButton("Cancelar");
		visualizar = new JButton("Visualizar");
		
		nome = new JTextField();
		dataValidade = new JTextField();
		codigoBarras = new JTextField();
		fornecedor = new JTextField();
		
		lNome = new JLabel("Nome:");
		lDataValidade = new JLabel("Data de Validade:");
		lCodigoBarras = new JLabel("Código de Barras:");
		lFornecedor = new JLabel("Fornecedor:");
		titulo = new JLabel("Cadastro de Produto");
		
		titulo.setBounds(10, 15, 150, 14);
		lNome.setBounds(10, 50, 46, 14);
		nome.setBounds(56, 50, 320, 20);
		lDataValidade.setBounds(300, 90, 170, 14);
		dataValidade.setBounds(405, 90, 100, 20);
		lCodigoBarras.setBounds(10, 90, 106, 14);
		codigoBarras.setBounds(118, 90, 150, 20);
		lFornecedor.setBounds(10, 130, 96, 14);
		fornecedor.setBounds(86, 130, 250, 20);
		
		salvar.setBounds(40, 175, 110, 50);
		visualizar.setBounds(160, 175, 110, 50);
		limpar.setBounds(280, 175, 110, 50);
		cancelar.setBounds(400, 175, 110, 50);
		
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		visualizar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String idAux = JOptionPane.showInputDialog("Digite o ID do produto que deseja visualizar!");
				if(idAux != null) {
				int id = Integer.parseInt(idAux);
				Produto produto = controller.listarProdutos(id);
				if(produto == null) {
					JOptionPane.showMessageDialog(null, "ERRO! produto não encontrado!");
					return;
				} else {
					String texto = "produto: \n";
					texto = texto + "Nome: " + produto.getNome() + "\n";
					texto = texto + "Fornecedor: " + produto.getFornecedor().getNome() + "\n";
					texto = texto + "Código de Barras " + produto.getCodigoDeBarras() + "\n";
					texto = texto + "Data de validade: " + produto.getDataValidade() + "\n";
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
		this.add(lNome);
		this.add(nome);
		this.add(lDataValidade);
		this.add(dataValidade);
		this.add(lCodigoBarras);
		this.add(codigoBarras);
		this.add(lFornecedor);
		this.add(fornecedor);
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
		nome.setText("");
		dataValidade.setText("");
		codigoBarras.setText("");
		fornecedor.setText("");
	}
	
	public void salvar() {
		 String nomeAux = nome.getText();
		 String dataValidadeAux = dataValidade.getText();
		 String codigoBarrasAux = codigoBarras.getText();
		 String fornecedorAux = fornecedor.getText();

			try {
				controller.cadastrarProduto(nomeAux, fornecedorAux, dataValidadeAux, codigoBarrasAux);
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
		TelaCadastroProduto cad = new TelaCadastroProduto(new Controller());
	}
}
