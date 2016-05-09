package br.uefs.ecomp.comprascabo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import br.uefs.ecomp.comprascabo.controller.Controller;
import br.uefs.ecomp.comprascabo.exceptions.CampoObrigatorioInexistenteException;
import br.uefs.ecomp.comprascabo.model.Cliente;

public class TelaCadastroFornecedor extends JFrame {
	
	private Controller controller;
	
	private JButton salvar;
	private JButton cancelar;
	private JButton limpar;
	private JButton visualizar;
	
	private JTextField nome;
	private JTextField dataNascimento;
	private JTextField cnpj;
	private JTextField estado;
	private JTextField cidade;
	private JTextField rua;
	private JTextField bairro;
	private JTextField numero;
	private JTextField numeroTel;
	private JTextField email;
	
	private JLabel lNome;
	private JLabel lDataNascimento;
	private JLabel lCnpj;
	private JLabel lEstado;
	private JLabel lCidade;
	private JLabel lRua;
	private JLabel lBairro;
	private JLabel lNumero;
	private JLabel lNumeroTel;
	private JLabel lEmail;
	private JLabel titulo;
	
	public TelaCadastroFornecedor(Controller controller) {
		this.controller = controller;
		this.setLayout(null); //sem layout pr�-definido
		this.setLocationRelativeTo(null); //deixa a janela no centro na tela
		this.setResizable(false); //n�o pode ser redimensionada
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ao fechar a janela, fecha o programa
		this.setTitle("Cadastro de Fornecedor");
		this.setSize(560, 360);
		
		salvar = new JButton("Salvar");
		limpar = new JButton("Limpar");
		cancelar = new JButton("Cancelar");
		visualizar = new JButton("Visualizar");
		
		nome = new JTextField();
		dataNascimento = new JTextField();
		cnpj = new JTextField();
		estado = new JTextField();
		cidade = new JTextField();
		rua = new JTextField();
		bairro = new JTextField();
		numero = new JTextField();
		numeroTel = new JTextField();
		email = new JTextField();
		
		lNome = new JLabel("Nome:");
		lDataNascimento = new JLabel("Data de Nascimento:");
		lCnpj = new JLabel("CPF:");
		lEstado = new JLabel("Estado:");
		lCidade = new JLabel("Cidade:");
		lRua = new JLabel("Rua:");
		lBairro = new JLabel("Bairro:");
		lNumero = new JLabel("N�mero:");
		lNumeroTel = new JLabel("Telefone:");
		lEmail = new JLabel("E-mail:");
		titulo = new JLabel("Cadastro de Fornecedor");
		
		titulo.setBounds(10, 15, 150, 14);
		lNome.setBounds(10, 50, 46, 14);
		nome.setBounds(56, 50, 320, 20);
		lDataNascimento.setBounds(300, 90, 170, 14);
		dataNascimento.setBounds(425, 90, 100, 20);
		lCnpj.setBounds(10, 90, 46, 14);
		cnpj.setBounds(42, 90, 150, 20);
		lEstado.setBounds(10, 130, 46, 14);
		estado.setBounds(60, 130, 150, 20);
		lCidade.setBounds(300, 130, 46, 14);
		cidade.setBounds(350, 130, 150, 20);
		lRua.setBounds(10, 170, 46, 14);
		rua.setBounds(42, 170, 150, 20);
		lBairro.setBounds(210, 170, 46, 14);
		bairro.setBounds(257, 170, 150, 20);
		lNumero.setBounds(425, 170, 51, 14);
		numero.setBounds(485, 170, 50, 20);
		lEmail.setBounds(10, 210, 46, 14);
		email.setBounds(56, 210, 270, 20);
		lNumeroTel.setBounds(340, 210, 56, 14);
		numeroTel.setBounds(404, 210, 100, 20);
		
		salvar.setBounds(40, 260, 110, 50);
		visualizar.setBounds(160, 260, 110, 50);
		limpar.setBounds(280, 260, 110, 50);
		cancelar.setBounds(400, 260, 110, 50);
		
		salvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		visualizar.addActionListener(new ActionVisualizarCliente(controller));
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
		this.add(lDataNascimento);
		this.add(dataNascimento);
		this.add(lCnpj);
		this.add(cnpj);
		this.add(lEstado);
		this.add(estado);
		this.add(lCidade);
		this.add(cidade);
		this.add(lRua);
		this.add(rua);
		this.add(lBairro);
		this.add(bairro);
		this.add(lNumero);
		this.add(numero);
		this.add(lEmail);
		this.add(email);
		this.add(lNumeroTel);
		this.add(numeroTel);
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
		dataNascimento.setText("");
		cnpj.setText("");
		estado.setText("");
		cidade.setText("");
		rua.setText("");
		bairro.setText("");
		numero.setText("");
		numeroTel.setText("");
		email.setText("");
	}
	
	public void salvar() {
		 String nomeAux = nome.getText();
		 String dataNascimentoAux = dataNascimento.getText();
		 String cpfAux = cnpj.getText();
		 String estadoAux = estado.getText();
		 String cidadeAux = cidade.getText();
		 String ruaAux = rua.getText();
		 String bairroAux = bairro.getText();
		 String numeroAux = numero.getText();
		 String numeroTelAux = numeroTel.getText();
		 String emailAux = email.getText();
		 
		 if(nomeAux.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vazio");
			}
			if(nome == null) {
				JOptionPane.showMessageDialog(null, "Nulo");
			}
			Cliente cliente = new Cliente();
			cliente.setNome(nomeAux);
			cliente.setDataNascimento(dataNascimentoAux);
			cliente.setCpf(cpfAux);
			cliente.setEstado(estadoAux);
			cliente.setCidade(cidadeAux);
			cliente.setRua(ruaAux);
			cliente.setBairro(bairroAux);
			cliente.setNumero(numeroAux);
			cliente.setNumeroTel(numeroTelAux);
			cliente.setEmail(emailAux);
			try {
				controller.cadastrarCliente(nomeAux, dataNascimentoAux, cpfAux, estadoAux, cidadeAux, ruaAux, bairroAux, numeroAux, numeroTelAux, emailAux);
				controller.escreverCliente(cliente);
			} catch (CampoObrigatorioInexistenteException e) {
				JOptionPane.showMessageDialog(null, "ERRO! Campo Obrigat�rio n�o preenchido");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void main (String[] args) {
		TelaCadastroFornecedor cad = new TelaCadastroFornecedor(new Controller());
	}
}