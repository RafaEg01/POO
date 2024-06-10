package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dados.Usuario;
import sistema.Sistema;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InterfaceCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame cadastro;
	private JTextField Login;
	private JTextField CPF;
	private JTextField Idade;
	private JPasswordField Senha;

	/**
	 * Launch the application.
	 */
	public InterfaceCadastro(Sistema principal) {
		cadastro = new JFrame();
		cadastro.setResizable(false);
		cadastro.setTitle("ProjetoFinança");
		cadastro.setBounds(100, 100, 400, 375);
		cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastro.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLogin.setBounds(97, 11, 99, 25);
		cadastro.getContentPane().add(lblLogin);
		
		Login = new JTextField();
		Login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Login.setColumns(10);
		Login.setBounds(97, 37, 200, 30);
		cadastro.getContentPane().add(Login);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(97, 74, 99, 14);
		cadastro.getContentPane().add(lblSenha);
		
		Senha = new JPasswordField();
		Senha.setBounds(97, 90, 200, 30);
		cadastro.getContentPane().add(Senha);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(97, 130, 99, 14);
		cadastro.getContentPane().add(lblCpf);
		
		CPF = new JTextField();
		CPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CPF.setColumns(10);
		CPF.setBounds(97, 145, 200, 30);
		cadastro.getContentPane().add(CPF);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdade.setBounds(97, 191, 99, 14);
		cadastro.getContentPane().add(lblIdade);
		
		Idade = new JTextField();
		Idade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Idade.setColumns(10);
		Idade.setBounds(97, 206, 200, 30);
		cadastro.getContentPane().add(Idade);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estaVazio(Login) && estaVazio(Senha) && estaVazio(CPF) && estaVazio(Idade) ) {
					Usuario aux = new Usuario(Login.getText(),new String(Senha.getPassword()),CPF.getText(),Idade.getText());
					System.out.println("Valor Login = " + Login.getText());
					if(principal.cadastrarUsuario(aux) == true) {
						JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Erro ao Cadastrar", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Entradas de dados Invalidas", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(100, 247, 194, 37);
		cadastro.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceGrafica login = new InterfaceGrafica(principal);
				login.login.setVisible(true);
				cadastro.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(138, 292, 119, 23);
		cadastro.getContentPane().add(btnNewButton_1);
		
		
	}
	protected boolean estaVazio(JTextField campo) {
	    return campo.getText() != null && !campo.getText().trim().isEmpty();
	}
}
