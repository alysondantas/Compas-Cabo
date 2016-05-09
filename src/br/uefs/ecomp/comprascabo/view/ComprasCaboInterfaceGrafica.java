package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Classe Interface Gráfica da aplicação, será responsável pela interação do usuário com o programa.
 * @author Alyson Dantas, Bruno e Gustavo Henrique.
 * @since 06 de Maio de 2016.
 */
public class ComprasCaboInterfaceGrafica {// Interface de usuário.

	private final int X = 600, Y = 540;// Aqui será o tamanho da tela.
	private JFrame framePrincipal = null; // Frame principal, irá conter o panel principal.
	private JMenuBar menuBarPrincipal = null; // JMenuBar do frame principal.
	private JPanel panelPrincipal = null;// Panel principal, irá conter as primeiras informações do sistema.

	// Esta linha é utilizada para poder dividir os métodos, tornando-o mais legível.
	/*____________________________________________________________________________________________________________________*/
	public static void main(String args[]){
		/*Vou criar um objeto da classe e chamar o método montarTela, por que como os componentes que são utilizados pela
		 * main tem que ser static isso faz com que os componentes possam ser simples(não serão static).
		 */
		new ComprasCaboInterfaceGrafica().montarTela();
	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Método responsável por inicializar os componentes da interface.(A ordem de chamada dos métodos é importante).
	 */
	public void montarTela(){
		prepararFramePrincipal();// Prepara o frame principal.
		prepararPanelPrincipal();// Prepara o panel principal.
		prepararMenu();// Prepara o JMenu do frame principal.
	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Instância e monta o frame principal.
	 */
	private void prepararFramePrincipal() {
		/*Vou instânciar o frame aqui porque ele sendo static vai sempre existir no programa mas não poderá ser utilizado 
		 * só no momento da instância da classe.*/
		framePrincipal = new JFrame("Compras Cabo");// Instância o frame para poder ser utilizado.
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Quando fecha esta janela a aplicação será finalizada.
		framePrincipal.setLayout(null);// Seta o layout como null, para que possamos posicionar os componentes livremente.
		framePrincipal.setSize(X, Y);// Seta o tamanho da janela.
		framePrincipal.setResizable(false);// Torna a janela não redimensionável.
		framePrincipal.setVisible(true);// Torna a janela visível.
	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Instância e monta o JMenu do frame principal.
	 */
	private void prepararMenu() {
		menuBarPrincipal = new JMenuBar();
		prepararMenuCadastro();// Prepara o menu cadastro.
		prepararMenuVenda();// Prepara o menu venda.
		prepararMenuOpcoes();// Prepara o menu opções.
		menuBarPrincipal.setVisible(true);

	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Prepara o menu cadastro.
	 */
	private void prepararMenuCadastro() {
		JMenu menuCadastro = new JMenu("Cadastro");
		JMenuItem MICProduto, MICCliente, MICFornecedor;// Opções do menu cadastro (MIC - Menu Item Cadastro, apenas para ficar mais legível).

		/*Monta a opção Produto do menu cadastro*/
		MICProduto = new JMenuItem("Produto");
		MICProduto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Ver como será feito o cadastro do produto.
			}
		});
		menuCadastro.add(MICProduto);
		menuCadastro.addSeparator();// Adiciona um separador após o menu item Produto.

		/*Monta a opção Cliente do menu cadastro*/
		MICCliente = new JMenuItem("Cliente");
		MICCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Ver como irá ser feito o cadastro do cliente.
			}
		});
		menuCadastro.add(MICCliente);
		menuCadastro.addSeparator();

		/*Monta a opção Fornecedor do menu cadastro*/
		MICFornecedor = new JMenuItem("Fornecedor");
		MICFornecedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Ver como irá ser feito o cadastro do fornecedor.

			}
		});
		menuCadastro.add(MICFornecedor);
		menuBarPrincipal.add(menuCadastro);
	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Prepara o menu Venda.
	 */
	private void prepararMenuVenda(){
		JMenu menuVenda = new JMenu("Venda");
		// TODO Vê como será feita a venda.
		menuBarPrincipal.add(menuVenda);

	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Prepara o submenu opções.
	 */
	private void prepararMenuOpcoes() {
		JMenu menuOpcoes = new JMenu("Opções");
		JMenuItem MIOSair = null;
		
		/*Monta a opção sair do menu opções*/
		MIOSair = new JMenuItem("Sair");
		MIOSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menuOpcoes.add(MIOSair);

		menuBarPrincipal.add(menuOpcoes);
	}
	
	/*____________________________________________________________________________________________________________________________*/
	
	/**
	 * Prepara o panel principal.
	 */
	private void prepararPanelPrincipal(){
		panelPrincipal = new JPanel();
		panelPrincipal.setSize(X, Y);
		//panelPrincipal.setBackground(Color.BLACK);
		framePrincipal.add(panelPrincipal);
	}
}
