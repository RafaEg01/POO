package dados;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableGastoModel extends AbstractTableModel {
	
	private List<Gasto> gastos = new LinkedList<Gasto>();
	
	public int getColumnCount() {
		return 4;
	}
	
	public List<Gasto> getValores() {
		return gastos;
	}

	public int getRowCount() {
		return gastos.size();
	}
	
	public Object getValueAt(int linha, int coluna) {
	    switch (coluna) {
	        case 0: 
	            return gastos.get(linha).getNome();
	        case 1: 
	            return gastos.get(linha).getValor();
	        case 2:
	        	return gastos.get(linha).getTipogasto();
	        case 3:
	        	return gastos.get(linha).getData();
	           
	    }
		return null;
	}
	
	public String getColumnName(int coluna) {
		switch(coluna) {
		case 0:
			return "Nome";
		case 1:
			return "Valor";
		case 2:
			return "Tipo Gasto";
		case 3:
			return "Data";
			
		}
		return null;
	}
	
	public void adicionarGasto(Gasto gasto) {
		gastos.add(gasto);
		this.fireTableStructureChanged();
	}
	
	public void removeRow(int linha) {
        Gasto p = this.gastos.get(linha);
        this.gastos.remove(linha);
        super.fireTableRowsDeleted(linha, linha);
    }

}
