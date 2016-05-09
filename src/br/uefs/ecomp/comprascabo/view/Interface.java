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
import javax.swing.border.EmptyBorder;

import br.uefs.ecomp.comprascabo.controller.Controller;

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
	}
	
	/*______________________________________________________________________________________________________________*/

	/**
	 * Cria a interface do frame principal.
	 */
	public void montarTela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		prepararJMenuBar();
		prepararBotoes();
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

		JMenuItem menuItemSair = new JMenuItem("Sair");
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

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton botaoProduto = new JButton("Produto");
		botaoProduto.setBounds(28, 28, 104, 37);
		botaoProduto.addActionListener(eventCadastroProduto);
		contentPane.add(botaoProduto);

		JButton botaoCliente = new JButton("Cliente");
		botaoCliente.setBounds(28, 76, 104, 37);
		botaoCliente.addActionListener(eventCadastroCliente);
		contentPane.add(botaoCliente);

		JButton botaoFornecedor = new JButton("Fornecedor");
		botaoFornecedor.setBounds(28, 124, 104, 37);
		botaoFornecedor.addActionListener(eventCadastroFornecedor);
		contentPane.add(botaoFornecedor);

		JButton botaoVenda = new JButton("Venda");
		botaoVenda.setBounds(28, 172, 104, 37);
		botaoVenda.addActionListener(eventCadastroVenda);
		contentPane.add(botaoVenda);
	}
}
