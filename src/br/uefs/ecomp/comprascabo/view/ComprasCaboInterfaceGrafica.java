package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * Classe Interface Gr�fica da aplica��o, ser� respons�vel pela intera��o do usu�rio com o programa.
 * @author Alyson Dantas, Bruno e Gustavo Henrique.
 * @since 06 de Maio de 2016.
 */
public class ComprasCaboInterfaceGrafica {// Interface de usu�rio.

	private final int X = 600, Y = 540;// Aqui ser� o tamanho da tela.
	private JFrame framePrincipal = null; // Frame principal, ir� conter o panel principal.
	private JMenuBar menuBarPrincipal = null; // JMenuBar do frame principal.
	private JPanel panelPrincipal = null;// Panel principal, ir� conter as primeiras informa��es do sistema.

	// Esta linha � utilizada para poder dividir os m�todos, tornando-o mais leg�vel.
	/*____________________________________________________________________________________________________________________*/
	public static void main(String args[]){
		/*Vou criar um objeto da classe e chamar o m�todo montarTela, por que como os componentes que s�o utilizados pela
		 * main tem que ser static isso faz com que os componentes possam ser simples(n�o ser�o static).
		 */
		new ComprasCaboInterfaceGrafica().montarTela();
	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * M�todo respons�vel por inicializar os componentes da interface.(A ordem de chamada dos m�todos � importante).
	 */
	public void montarTela(){
		prepararFramePrincipal();// Prepara o frame principal.
		prepararPanelPrincipal();// Prepara o panel principal.
		prepararMenu();// Prepara o JMenu do frame principal.
	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Inst�ncia e monta o frame principal.
	 */
	private void prepararFramePrincipal() {
		/*Vou inst�nciar o frame aqui porque ele sendo static vai sempre existir no programa mas n�o poder� ser utilizado 
		 * s� no momento da inst�ncia da classe.*/
		framePrincipal = new JFrame("Compras Cabo");// Inst�ncia o frame para poder ser utilizado.
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Quando fecha esta janela a aplica��o ser� finalizada.
		framePrincipal.setLayout(null);// Seta o layout como null, para que possamos posicionar os componentes livremente.
		framePrincipal.setSize(X, Y);// Seta o tamanho da janela.
		framePrincipal.setResizable(false);// Torna a janela n�o redimension�vel.
		framePrincipal.setVisible(true);// Torna a janela vis�vel.
	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Inst�ncia e monta o JMenu do frame principal.
	 */
	private void prepararMenu() {
		menuBarPrincipal = new JMenuBar();
		prepararMenuCadastro();// Prepara o menu cadastro.
		prepararMenuVenda();// Prepara o menu venda.
		prepararMenuOpcoes();// Prepara o menu op��es.
		menuBarPrincipal.setVisible(true);

	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Prepara o menu cadastro.
	 */
	private void prepararMenuCadastro() {
		JMenu menuCadastro = new JMenu("Cadastro");
		JMenuItem MICProduto, MICCliente, MICFornecedor;// Op��es do menu cadastro (MIC - Menu Item Cadastro, apenas para ficar mais leg�vel).

		/*Monta a op��o Produto do menu cadastro*/
		MICProduto = new JMenuItem("Produto");
		MICProduto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Ver como ser� feito o cadastro do produto.
			}
		});
		menuCadastro.add(MICProduto);
		menuCadastro.addSeparator();// Adiciona um separador ap�s o menu item Produto.

		/*Monta a op��o Cliente do menu cadastro*/
		MICCliente = new JMenuItem("Cliente");
		MICCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Ver como ir� ser feito o cadastro do cliente.
			}
		});
		menuCadastro.add(MICCliente);
		menuCadastro.addSeparator();

		/*Monta a op��o Fornecedor do menu cadastro*/
		MICFornecedor = new JMenuItem("Fornecedor");
		MICFornecedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Ver como ir� ser feito o cadastro do fornecedor.

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
		// TODO V� como ser� feita a venda.
		menuBarPrincipal.add(menuVenda);

	}

	/*____________________________________________________________________________________________________________________*/

	/**
	 * Prepara o submenu op��es.
	 */
	private void prepararMenuOpcoes() {
		JMenu menuOpcoes = new JMenu("Op��es");
		JMenuItem MIOSair = null;
		
		/*Monta a op��o sair do menu op��es*/
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
