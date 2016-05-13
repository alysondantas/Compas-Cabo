package br.uefs.ecomp.comprascabo.view.telaEditar;

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
import br.uefs.ecomp.comprascabo.model.Venda;

public class TelaEditarVenda extends JFrame {

	private static final long serialVersionUID = 4572519819414638485L;

	private Controller controller;

	private JButton salvar;
	private JButton cancelar;
	private JButton limpar;
	private JButton visualizar;

	private JTextField produto;
	private JTextField quantidade;
	private JTextField cliente;
	private JTextField textId;

	private JLabel lProduto;
	private JLabel lQuantidade;
	private JLabel lCliente;
	private JLabel labelId;

	private JLabel titulo;

	public TelaEditarVenda(Controller controller) {
		this.controller = controller;
		this.setLayout(null); //sem layout pré-definido
		this.setSize(560, 240);
		this.setLocationRelativeTo(null); //deixa a janela no centro na tela
		this.setResizable(false); //não pode ser redimensionada
		this.setTitle("Editar Venda");
		
		montarTela();
	}

	private void montarTela(){
		salvar = new JButton("Salvar");
		limpar = new JButton("Limpar");
		cancelar = new JButton("Cancelar");
		visualizar = new JButton("Visualizar");

		produto = new JTextField();
		quantidade = new JTextField();
		cliente = new JTextField();
		textId = new JTextField();

		lProduto = new JLabel("Produto:");
		lQuantidade = new JLabel("Quantidade:");
		lCliente = new JLabel("Cliente:");
		labelId = new JLabel("Id:");
		titulo = new JLabel("Editar Venda");

		titulo.setBounds(10, 15, 150, 14);
		lProduto.setBounds(10, 110, 86, 14);
		produto.setBounds(68, 110, 200, 20);
		lCliente.setBounds(10, 70, 106, 14);
		cliente.setBounds(62, 70, 320, 20);
		lQuantidade.setBounds(300, 110, 96, 14);
		quantidade.setBounds(380, 110, 50, 20);

		textId.setBounds(50, 45, 40, 20);
		labelId.setBounds(10, 45, 100, 14);

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
		this.add(textId);
		this.add(labelId);

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
		String idx = textId.getText();
		int quantidadeAux = 0;
		int id = 0;
		try{
			id = Integer.parseInt(idx);
			quantidadeAux = Integer.parseInt(quantidadeAux1);
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Não é permitido letras nos campos quantidade e id!");
			return;
		}
		String clienteAux = cliente.getText();
		try {
			controller.editarVenda(id, clienteAux, produtoAux, quantidadeAux);
			controller.escreverVenda(controller.obterVenda(id));
			JOptionPane.showMessageDialog(null, "Edição efetuada com sucesso!!");
		} catch (CampoObrigatorioInexistenteException e) {
			JOptionPane.showMessageDialog(null, "ERRO! Campo Obrigatório não preenchido");
		} catch (ObjetoNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "A venda a ser editada não foi encontrada!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possivel armazenar os dados editados");
		}
	}
}
