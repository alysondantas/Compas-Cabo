package br.uefs.ecomp.comprascabo.view;

import java.awt.EventQueue;
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller = new Controller();

	//	private List<Cliente> listaDeClientes = null;
	//	private List<Fornecedor> listaDeFornecedores = null;
	//	private List<Produto> listaDeProdutos = null;
	//	private List<Venda> listaDeVendas = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
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

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(eventCadastroProduto);
		cadastro.add(mntmProduto);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cliente");
		mntmNewMenuItem.addActionListener(eventCadastroCliente);
		cadastro.add(mntmNewMenuItem);

		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.addActionListener(eventCadastroFornecedor);
		cadastro.add(mntmFornecedor);

		JMenu venda = new JMenu("VENDA");
		menuBar.add(venda);

		JMenuItem mntmNova = new JMenuItem("Nova");
		mntmNova.addActionListener(eventCadastroVenda);
		venda.add(mntmNova);

		JMenu opcoes = new JMenu("OPÇÕES");
		menuBar.add(opcoes);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {

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
		opcoes.add(mntmSair);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Produto");
		btnNewButton.setBounds(28, 28, 104, 37);
		btnNewButton.addActionListener(eventCadastroProduto);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cliente");
		btnNewButton_1.setBounds(28, 76, 104, 37);
		btnNewButton_1.addActionListener(eventCadastroCliente);
		contentPane.add(btnNewButton_1);

		JButton btnFornecedor = new JButton("Fornecedor");
		btnFornecedor.setBounds(28, 124, 104, 37);
		btnFornecedor.addActionListener(eventCadastroFornecedor);
		contentPane.add(btnFornecedor);

		JButton btnVenda = new JButton("Venda");
		btnVenda.setBounds(28, 172, 104, 37);
		btnVenda.addActionListener(eventCadastroVenda);
		contentPane.add(btnVenda);
	}
}
