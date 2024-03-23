package apresentacao;

import java.util.Scanner;
import dados.Pessoa;
import dados.Sorteador;



public class Principal {
	private static Sorteador sorteia  = new Sorteador();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		showMenu();
	}
	public static void showMenu() {
		int escolha = -1;
		while(escolha !=0) {
			System.out.println("\nEscolha uma opção");
			System.out.println("0 - Sair");
			System.out.println("1 - Adicionar pessoa");
			System.out.println("2 - Mostrar pessoa aleatoria e Remover");
			escolha = Integer.parseInt(scan.nextLine());


			switch(escolha) {
			case 0:
				break;
			case 1:
				cadastraPessoa();
				break;
			case 2:
				mostraPessoa();
				break;
			}
		}
	}

	public static void cadastraPessoa() {
		sorteia.cadastrarPessoa(infoPessoa());
	}

	public static Pessoa infoPessoa() {
		System.out.println("\nQual nome da pessoa");
		String nome = scan.nextLine();
		System.out.println("\nQual idade da pessoa");
		int idade = Integer.parseInt(scan.nextLine());
		System.out.println("\nQual cpf da pessoa");
		String cpf = scan.nextLine();

		Pessoa c = new Pessoa();
		c.setNome(nome);
		c.setIdade(idade);
		c.setCpf(cpf);

		return c;

	}
	public static void mostraPessoa() {
		Pessoa p = sorteia.sortearProximo();
		if(p!= null) {
			System.out.print(p.toString());
		}else {
			System.out.println("\nAcabaram todas as pessoas");
		}
		
	}
}