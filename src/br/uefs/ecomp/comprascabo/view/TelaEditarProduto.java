package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.comprascabo.exceptions.ObjetoNaoEncontradoException;
import br.uefs.ecomp.comprascabo.model.Produto;

public class TelaEditarProduto extends JFrame {

	private static final long serialVersionUID = -2773045524285334890L;

	private Controller controller;

	private JButton salvar;
	private JButton cancelar;
	private JButton limpar;
	private JButton visualizar;

	private JTextField nome;
	private JTextField novoNome = null;
	private JTextField dataValidade;
	private JTextField codigoBarras;

	private JLabel lNome;
	private JLabel lNovoNome = null;
	private JLabel lDataValidade;
	private JLabel lCodigoBarras;

	private JLabel titulo;

	public TelaEditarProduto(Controller controller) {
		this.controller = controller;
		this.setLayout(null); //sem layout pré-definido.
		this.setLocationRelativeTo(null); //deixa a janela no centro na tela.
		this.setResizable(false); //não pode ser redimensionada.
		this.setTitle("Editar Produto");
		this.setSize(560, 275);
		montarTela();
	}

	public void cancelar() {
		this.dispose();
	}

	public void limpar() {
		nome.setText("");
		novoNome.setText("");
		dataValidade.setText("");
		codigoBarras.setText("");
	}

	public void salvar() {
		String novoNomeProduto = novoNome.getText();
		String nomeAux = nome.getText();
		String dataValidadeAux = dataValidade.getText();
		String codigoBarrasAux = codigoBarras.getText();

		try {
			controller.editarProduto(nomeAux, novoNomeProduto, dataValidadeAux, codigoBarrasAux);
			controller.escreverProduto(controller.obterProduto(novoNomeProduto));
			JOptionPane.showMessageDialog(null, "Edição efetuada com sucesso!!");
		} catch (CampoObrigatorioInexistenteException e) {
			JOptionPane.showMessageDialog(null, "ERRO! Campo Obrigatório não preenchido");
		} catch (ObjetoNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "O produto não foi encontrado!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel armazenar os dados editados");
		}
	}

	public void montarTela () {
		salvar = new JButton("Salvar");
		limpar = new JButton("Limpar");
		cancelar = new JButton("Cancelar");
		visualizar = new JButton("Visualizar");

		nome = new JTextField();
		novoNome = new JTextField();
		dataValidade = new JTextField();
		codigoBarras = new JTextField();

		lNome = new JLabel("Nome:");
		lNovoNome = new JLabel("Novo Nome:");
		lDataValidade = new JLabel("Data de Validade:");
		lCodigoBarras = new JLabel("Código de Barras:");
		titulo = new JLabel("Editar Produto");

		titulo.setBounds(10, 15, 150, 14);
		lNome.setBounds(10, 40, 46, 14);
		nome.setBounds(56, 40, 320, 20);

		novoNome.setBounds(90, 65, 320, 20);
		lNovoNome.setBounds(10, 65, 70, 14);

		lDataValidade.setBounds(300, 95, 170, 14);
		dataValidade.setBounds(405, 95, 100, 20);
		lCodigoBarras.setBounds(10, 95, 106, 14);
		codigoBarras.setBounds(118, 95, 150, 20);

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
						texto += "Fornecedor: " + produto.getFornecedor().getNome() + "\n";
						texto += "Código de Barras " + produto.getCodigoDeBarras() + "\n";
						texto += "Data de validade: " + produto.getDataValidade() + "\n";
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
		this.add(lNovoNome);
		this.add(novoNome);
		this.add(lDataValidade);
		this.add(dataValidade);
		this.add(lCodigoBarras);
		this.add(codigoBarras);
		this.add(salvar);
		this.add(cancelar);
		this.add(limpar);
		this.add(visualizar);

		this.setVisible(true);
	}
	
	public static void main (String[] args) {
		TelaEditarProduto cad = new TelaEditarProduto(new Controller());
	}
}
