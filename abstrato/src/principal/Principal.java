package principal;

import java.util.List;

import dados.Fatoriais;
import dados.Naturais;

public class Principal {

public static void main(String[] args) {
	Naturais n = new Naturais();
	Fatoriais f = new Fatoriais();
	Abundantes a = new Abundantes();
	
	System.out.println("Naturais");
	n.gerar(5);
	for(int a : n.getSequencia()) {
		System.out.print(a+ " ");
	}
	System.out.println("\nFatoriais");
	f.gerar(5);
	for(int a : f.getSequencia()) {
		System.out.print(a+ " ");
	}
	
}
}
