package apresentacao;

import java.time.LocalDate;

import dados.Gasto;
import dados.TipoGasto;
import dados.Usuario;
import sistema.Sistema;
import telas.InterfaceGrafica;


public class Principal {
	
public static Sistema sistema = new Sistema();	
	
public static void main(String[] args) {
	
	Usuario testeusu = new Usuario("Rafael","123","19","14493158956");
	sistema.cadastrarUsuario(testeusu);
	
	
	InterfaceGrafica inter = new InterfaceGrafica(sistema);
	inter.login.setVisible(true);
	

}

}
