package telas;

import javax.swing.JFrame;

import sistema.Sistema;
import javax.swing.JButton;
import java.awt.Font;

import dados.Gasto;
import dados.TableGastoModel;
import dados.TipoGasto;
import dados.Usuario;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class InterfacePrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame telaPrincipal;
	private JButton btnLogout;
	private JButton btnAdicionarGasto;
	private JButton btnRemoverGasto;
	private JTextField soma;
	

	public InterfacePrincipal(Sistema principal) {
		telaPrincipal = new JFrame();
		telaPrincipal.setTitle("ProjetoFinança");
		telaPrincipal.setResizable(false);
		telaPrincipal.setBounds(100, 100, 600, 500);
		telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaPrincipal.getContentPane().setLayout(null);

		GastoJTable gastos = new GastoJTable();
		gastos.setBounds(290, 11, 275, 385);
		telaPrincipal.getContentPane().add(gastos);
	
		
		
		

		JButton btnNewButton = new JButton("Atualizar Tabela");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Usuario u = principal.getLogadoAtual();
			if(principal.visualizarGasto(u) == null) {
			JOptionPane.showMessageDialog(null, "Usuario não possui nenhum Gasto", "Erro", JOptionPane.ERROR_MESSAGE);
			}else {
				System.out.println(principal.visualizarGasto(u)); 
				for(Gasto g : principal.visualizarGasto(u)) {
					if(gastos.getGastos().getValores().contains(g) == false) {
						gastos.getGastos().adicionarGasto(g);
					}
				}
			}
	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(305, 416, 250, 30);
		telaPrincipal.getContentPane().add(btnNewButton);

		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.logout();
				InterfaceGrafica login = new InterfaceGrafica(principal);
				login.login.setVisible(true);
				telaPrincipal.setVisible(false);
				JOptionPane.showMessageDialog(null, "Logout feito com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout.setBounds(20, 416, 250, 30);
		telaPrincipal.getContentPane().add(btnLogout);

		btnAdicionarGasto = new JButton("Adicionar Gasto");
		btnAdicionarGasto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfaceCadastroGasto cadastrogasto = new InterfaceCadastroGasto(principal);
				cadastrogasto.CadastroGasto.setVisible(true);
				telaPrincipal.setVisible(false);;
			}
		});
		btnAdicionarGasto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdicionarGasto.setBounds(20, 11, 250, 30);
		telaPrincipal.getContentPane().add(btnAdicionarGasto);

		btnRemoverGasto = new JButton("Remover Gasto");
		btnRemoverGasto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			

				if(gastos.getTable().getSelectedRowCount()==1) {
					final int indiceRowModel = gastos.getTable().getSelectedRow();
					Gasto p = gastos.getGastos().getValores().get(indiceRowModel);
					principal.getLogadoAtual().getContas().get(p.getTipogasto()).remove(p);
					gastos.getGastos().removeRow(indiceRowModel);
					 
					
				}else {
					if(gastos.getTable().getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "Tabela está vazia");
					}else {
						JOptionPane.showMessageDialog(null, "Selecione Alguma Linha para Deletar");
					}
					
				}
				 
				
			}
		});
		btnRemoverGasto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoverGasto.setBounds(20, 52, 250, 30);
		telaPrincipal.getContentPane().add(btnRemoverGasto);

		JButton btnLogout_1 = new JButton("Gerar Gráficos");
		btnLogout_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout_1.setBounds(20, 93, 250, 30);
		telaPrincipal.getContentPane().add(btnLogout_1);
		
		soma = new JTextField();
		soma.setHorizontalAlignment(SwingConstants.CENTER);
		soma.setFont(new Font("Tahoma", Font.PLAIN, 18));
		soma.setBounds(21, 349, 250, 40);
		telaPrincipal.getContentPane().add(soma);
		soma.setColumns(10);
		
		JButton btnLogout_1_1 = new JButton("Gerar Valor da Fatura");
		btnLogout_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float aux = 0;
				
				for(int i = 0; i < gastos.getTable().getRowCount(); i++) {
					aux += Float.parseFloat(gastos.getTable().getValueAt(i, 1).toString());
				}
				
				soma.setText(Float.toString(aux));
			}
		});
		btnLogout_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout_1_1.setBounds(20, 308, 250, 30);
		telaPrincipal.getContentPane().add(btnLogout_1_1);
	}
}
