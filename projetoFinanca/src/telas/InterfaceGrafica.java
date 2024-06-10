package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sistema.Sistema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class InterfaceGrafica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame login;
	private JTextField Login;
	private JPasswordField Senha;

	
	public InterfaceGrafica(Sistema principal) {
		login = new JFrame();
		login.setResizable(false);
		login.setTitle("ProjetoFinança");
		login.getContentPane().setEnabled(false);
		login.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 235);
		login.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(estaVazio(Login) && estaVazio(Senha)) {
					if(principal.loginUsuario(Login.getText(), new String(Senha.getPassword())) != null) {
						InterfacePrincipal tela = new InterfacePrincipal(principal);
						tela.telaPrincipal.setVisible(true);
						login.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "Conta não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);

					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Campos não foram preenchidos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_1.setBounds(104, 141, 194, 37);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(100, 21, 99, 14);
		panel.add(lblNewLabel);
		
		Login = new JTextField();
		Login.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Login.setBounds(100, 36, 200, 30);
		panel.add(Login);
		Login.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(100, 85, 99, 14);
		panel.add(lblSenha);
		
		Senha = new JPasswordField();
		Senha.setBounds(100, 100, 200, 30);
		panel.add(Senha);
		login.setBounds(100, 100, 400, 275);
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InterfaceCadastro cadastro = new InterfaceCadastro(principal);
					cadastro.cadastro.setVisible(true);
					login.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(141, 189, 119, 23);
		panel.add(btnNewButton);
		
		
	}
	
	protected boolean estaVazio(JTextField campo) {
	    return campo.getText() != null && !campo.getText().trim().isEmpty();
	}

	
}
