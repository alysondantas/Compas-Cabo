package br.uefs.ecomp.comprascabo.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.model.Cliente;
import br.uefs.ecomp.comprascabo.model.Fornecedor;
import br.uefs.ecomp.comprascabo.model.Produto;
import br.uefs.ecomp.comprascabo.model.Venda;

public class GUI {
	
	private static Controller controller = new Controller();
	
	private JFrame framePrincipal = null;
	private JMenuBar menuBarPrincipal = null;
	private JPanel panelPrincipal = null;
	private final int X = 600, Y = 540;
	
	private List<Cliente> listaDeClientes = null;
	private List<Fornecedor> listaDeFornecedores = null;
	private List<Produto> listaDeProdutos = null;
	private List<Venda> listaDeVendas = null;
	
	public static void main(String[] args){
//		new TelaCadastroCliente(controller);
//		new TelaCadastroFornecedor(controller);
//		new TelaCadastroProduto(controller);
//		new TelaCadastroVenda(controller);
		new GUI().montarTela();
	}
	
	public GUI(){
	}
	
	private void montarTela(){
		prepararFramePrincipal();
	}

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
	
	private void prepararMenuBar(){
		menuBarPrincipal = new JMenuBar();
		menuBarPrincipal.setVisible(true);
		JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBarPrincipal.add(fileMenu);
        menuBarPrincipal.add(editMenu);
        
        panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.black);
        panelPrincipal.setSize(200, 200);
        framePrincipal.add(panelPrincipal);
		
		framePrincipal.setJMenuBar(menuBarPrincipal);
	}
	
	
	
}
