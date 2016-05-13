package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.view.excluir.TelaExcluirCliente;
import br.uefs.ecomp.comprascabo.view.excluir.TelaExcluirFornecedor;
import br.uefs.ecomp.comprascabo.view.excluir.TelaExcluirProduto;
import br.uefs.ecomp.comprascabo.view.excluir.TelaExcluirVenda;
import br.uefs.ecomp.comprascabo.view.telaEditar.TelaEditarCliente;
import br.uefs.ecomp.comprascabo.view.telaEditar.TelaEditarFornecedor;
import br.uefs.ecomp.comprascabo.view.telaEditar.TelaEditarProduto;
import br.uefs.ecomp.comprascabo.view.telaEditar.TelaEditarVenda;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane = null;
	private Controller controller = null;

	private JMenuBar menuBar = null;

	/*______________________________________________________________________________________________________________*/
	
	/**
	 * Instância o frame e monta a tela inicial.
	 */
	public static void main(String[] args) {
		Interface frame = new Interface();
		frame.montarTela();
		frame.setVisible(true);
	}
	
	/*______________________________________________________________________________________________________________*/

	private Interface(){
		super("Compras Conder");
		controller = new Controller();
		contentPane = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setBounds(100, 100, 500, 300);
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
	}
	
	/*______________________________________________________________________________________________________________*/

	/**
	 * Cria a interface do frame principal.
	 */
	private void montarTela() {

		prepararJMenuBar();
		prepararBotoes();
		prepararBotoesEditar();
		prepararBotoesExcluir();
	}
	
	/*______________________________________________________________________________________________________________*/

	private void prepararJMenuBar(){
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		ActionListener eventCadastroCliente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente(controller);
			}
		};

		ActionListener eventCadastroProduto = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroProduto(controller);
			}
		};

		ActionListener eventCadastroFornecedor = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFornecedor(controller);
			}
		};

		ActionListener eventCadastroVenda = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroVenda(controller);
			}
		};

		JMenu cadastro = new JMenu("CADASTRO");
		menuBar.add(cadastro);

		JMenuItem menuItemProduto = new JMenuItem("Produto");
		menuItemProduto.addActionListener(eventCadastroProduto);
		cadastro.add(menuItemProduto);

		JMenuItem menuItemCliente = new JMenuItem("Cliente");
		menuItemCliente.addActionListener(eventCadastroCliente);
		cadastro.add(menuItemCliente);

		JMenuItem menuItemFornecedor = new JMenuItem("Fornecedor");
		menuItemFornecedor.addActionListener(eventCadastroFornecedor);
		cadastro.add(menuItemFornecedor);

		JMenu venda = new JMenu("VENDA");
		menuBar.add(venda);

		JMenuItem mntmNova = new JMenuItem("Nova Venda");
		mntmNova.addActionListener(eventCadastroVenda);
		venda.add(mntmNova);

		JMenu opcoes = new JMenu("OPÇÕES");
		menuBar.add(opcoes);

		JMenuItem menuItemSair = new JMenuItem("Salvar e Sair");
		menuItemSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.escreverTudoArquivo();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possivel armazenar os dados da aplicação!");
				}
				System.exit(0);
			}
		});
		opcoes.add(menuItemSair);
	}

	/*______________________________________________________________________________________________________________*/
	
	private void prepararBotoes(){
		ActionListener eventCadastroCliente = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente(controller);
			}
		};

		ActionListener eventCadastroProduto = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroProduto(controller);
			}
		};

		ActionListener eventCadastroFornecedor = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFornecedor(controller);
			}
		};

		ActionListener eventCadastroVenda = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroVenda(controller);
			}
		};
		
		JButton botaoProduto = new JButton("Produto");
		botaoProduto.setBounds(28, 28, 110, 40);
		botaoProduto.addActionListener(eventCadastroProduto);
		contentPane.add(botaoProduto);

		JButton botaoCliente = new JButton("Cliente");
		botaoCliente.setBounds(28, 76, 110, 40);
		botaoCliente.addActionListener(eventCadastroCliente);
		contentPane.add(botaoCliente);

		JButton botaoFornecedor = new JButton("Fornecedor");
		botaoFornecedor.setBounds(28, 124, 110, 40);
		botaoFornecedor.addActionListener(eventCadastroFornecedor);
		contentPane.add(botaoFornecedor);

		JButton botaoVenda = new JButton("Venda");
		botaoVenda.setBounds(28, 172, 110, 40);
		botaoVenda.addActionListener(eventCadastroVenda);
		contentPane.add(botaoVenda);
	}
	
	/*______________________________________________________________________________________________________________*/
	
	private void prepararBotoesEditar(){
		JButton botaoEditarProduto = new JButton("Editar Produto");
		botaoEditarProduto.setBounds(150, 28, 140, 40);
		
		botaoEditarProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaEditarProduto(controller);
			}
		});
		
		contentPane.add(botaoEditarProduto);
		
		JButton botaoEditarCliente = new JButton("Editar Cliente");
		botaoEditarCliente.setBounds(150, 76, 140, 40);
		
		botaoEditarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaEditarCliente(controller);
			}
		});
		
		contentPane.add(botaoEditarCliente);
		
		JButton botaoEditarFornecedor = new JButton("Editar Fornecedor");
		botaoEditarFornecedor.setBounds(150, 124, 140, 40);
		
		botaoEditarFornecedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaEditarFornecedor(controller);
			}
		});
		
		contentPane.add(botaoEditarFornecedor);
		
		JButton botaoEditarVenda = new JButton("Editar Venda");
		botaoEditarVenda.setBounds(150, 172, 140, 40);
		
		botaoEditarVenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaEditarVenda(controller);
			}
		});
		
		contentPane.add(botaoEditarVenda);
	}
	
	/*______________________________________________________________________________________________________________*/
	
	private void prepararBotoesExcluir(){
		JButton botaoExcluirProduto = new JButton("Excluir Produto");
		botaoExcluirProduto.setBounds(300, 28, 150, 40);
		
		botaoExcluirProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaExcluirProduto(controller);
			}
		});
		
		contentPane.add(botaoExcluirProduto);
		
		JButton botaoExcluirCliente = new JButton("Excluir Cliente");
		botaoExcluirCliente.setBounds(300, 76, 150, 40);
		
		botaoExcluirCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaExcluirCliente(controller);
			}
		});
		
		contentPane.add(botaoExcluirCliente);
		
		JButton botaoExcluirFornecedor = new JButton("Excluir Fornecedor");
		botaoExcluirFornecedor.setBounds(300, 124, 150, 40);
		
		botaoExcluirFornecedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaExcluirFornecedor(controller);
			}
		});
		
		contentPane.add(botaoExcluirFornecedor);
		
		JButton botaoExcluirVenda = new JButton("Excluir Venda");
		botaoExcluirVenda.setBounds(300, 172, 150, 40);
		
		botaoExcluirVenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaExcluirVenda(controller);
			}
		});
		
		contentPane.add(botaoExcluirVenda);
	}
	
	/*______________________________________________________________________________________________________________*/
	
}
