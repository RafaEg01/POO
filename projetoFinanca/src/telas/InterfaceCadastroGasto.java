package telas;

import javax.swing.JFrame;

import sistema.Sistema;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dados.Gasto;
import dados.TipoGasto;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

public class InterfaceCadastroGasto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame CadastroGasto;
	private JTextField nome;
	private JTextField valor;
	private JTextField data;
	private JTextField descricao;
	final String CUSTOM_PATTERN = "dd-MM-yyyy";
	final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(CUSTOM_PATTERN);

	public InterfaceCadastroGasto(Sistema principal){
		CadastroGasto = new JFrame();
		CadastroGasto.setBounds(100, 100, 450, 500);
		CadastroGasto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CadastroGasto.setTitle("ProjetoFinança");
		CadastroGasto.getContentPane().setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(TipoGasto.values()));
		comboBox.setBounds(10, 160, 120, 40);
		CadastroGasto.getContentPane().add(comboBox);


		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) throws DateTimeException {
				if(estaVazio(nome) && estaVazio(valor) && estaVazio(data) && estaVazio(descricao)) {
					LocalDate tempo = isValidLocalDate(data.getText(), DATE_TIME_FORMATTER);
					if(tempo == null) {
						InterfacePrincipal tela = new InterfacePrincipal(principal);
						tela.telaPrincipal.setVisible(true);
						CadastroGasto.setVisible(false);
						JOptionPane.showMessageDialog(null, "Data não foi preenchida no padrão dd--MM--yyyy", "Erro", JOptionPane.ERROR_MESSAGE);
					}else {
						Gasto gasto = new Gasto(nome.getText(),tempo,descricao.getText(),Float.parseFloat(valor.getText()),TipoGasto.valueOf(comboBox.getSelectedItem().toString()));
						if(principal.cadastrarGasto(principal.getLogadoAtual(), gasto)) {							
					
							
							
							InterfacePrincipal tela = new InterfacePrincipal(principal);
							tela.telaPrincipal.setVisible(true);
							CadastroGasto.setVisible(false);
							
							JOptionPane.showMessageDialog(null, "Gasto Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Gasto", "Erro", JOptionPane.ERROR_MESSAGE);
						}

					}
				}else {
					JOptionPane.showMessageDialog(null, "Campos não foram preenchidos corretamente", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(100, 350, 250, 40);
		CadastroGasto.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfacePrincipal tela = new InterfacePrincipal(principal);
				tela.telaPrincipal.setVisible(true);				CadastroGasto.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBounds(150, 399, 150, 30);
		CadastroGasto.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 10, 120, 30);
		CadastroGasto.getContentPane().add(lblNewLabel);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValor.setBounds(10, 70, 120, 30);
		CadastroGasto.getContentPane().add(lblValor);

		JLabel lblTipoDoGasto = new JLabel("Tipo do Gasto");
		lblTipoDoGasto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipoDoGasto.setBounds(10, 130, 120, 30);
		CadastroGasto.getContentPane().add(lblTipoDoGasto);


		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblData.setBounds(10, 210, 120, 30);
		CadastroGasto.getContentPane().add(lblData);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescrio.setBounds(10, 270, 120, 30);
		CadastroGasto.getContentPane().add(lblDescrio);

		nome = new JTextField();
		nome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nome.setBounds(10, 40, 200, 30);
		CadastroGasto.getContentPane().add(nome);


		valor = new JTextField();
		valor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		valor.setColumns(10);
		valor.setBounds(10, 100, 200, 30);
		CadastroGasto.getContentPane().add(valor);

		data = new JTextField();
		data.setFont(new Font("Tahoma", Font.PLAIN, 18));
		data.setColumns(10);
		data.setBounds(10, 240, 200, 30);
		CadastroGasto.getContentPane().add(data);

		descricao = new JTextField();
		descricao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		descricao.setColumns(10);
		descricao.setBounds(9, 300, 200, 30);
		CadastroGasto.getContentPane().add(descricao);


	}
	protected boolean estaVazio(JTextField campo) {
		return campo.getText() != null && !campo.getText().trim().isEmpty();
	}

	public static LocalDate isValidLocalDate(String dateStr, DateTimeFormatter dateFormatter) {

		LocalDate date = null;
		try {
			date = LocalDate.parse(dateStr, dateFormatter);
		} catch (DateTimeParseException e) {
			//handle exception
			e.printStackTrace();
		}
		return date;
	}
}
