package apresentacao;
import dados.Imobiliaria;
import dados.Imovel;


import java.util.Scanner;

public class Principal {
	private static Imobiliaria sistema  = new Imobiliaria();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		showMenu();
	}
	
public static void showMenu() {
	int escolha = -1;
	while(escolha!= 0) {
		System.out.println("\n 0 - Sair");
		System.out.println("\n 1 - Adicionar novo imovel");
		System.out.println("\n 2 - Mostrar imoveis");
		escolha = Integer.parseInt(scan.nextLine());
			switch(escolha) {
				case 0:
					break;
				case 1:
					cadastraImovel();
					break;
				case 2:
					mostraImovel();
					break;
	}
	
	}
}

public static void cadastraImovel() {
	sistema.cadastrarImovel(infoImovel());
}
public static Imovel infoImovel() {
	System.out.println("Insira a largura do Imovel");
	float largura = Float.parseFloat(scan.nextLine());
	System.out.println("Insira o comprimento do Imovel");
	float comprimento = Float.parseFloat(scan.nextLine());
	System.out.println("Insira o preco do Imovel");
	float preco = Float.parseFloat(scan.nextLine());
	
	Imovel i = new Imovel();
	
	i.setLargura(largura);
	i.setComprimento(comprimento);
	i.setPreco(preco);
	i.setArea(largura,comprimento);
	
	return i;

	
}
public static void mostraImovel() {
	System.out.println("\nQual area minima desejada");
	int x = Integer.parseInt(scan.nextLine());
	sistema.filtrarPorArea(x);
}
}


