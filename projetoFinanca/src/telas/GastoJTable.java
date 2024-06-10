package telas;

import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import dados.Gasto;
import dados.TableGastoModel;
import dados.TipoGasto;

public class GastoJTable extends JScrollPane {
	
	TableGastoModel gastos = new TableGastoModel();
	JTable table = new JTable(gastos);
	
	public TableGastoModel getGastos() {
		return gastos;
	}

	public GastoJTable() {
		
		setViewportView(table);
		
	}

	public JTable getTable() {
		return table;
	}

}
