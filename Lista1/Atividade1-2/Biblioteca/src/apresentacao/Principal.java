package apresentacao;

import java.util.Scanner;
import dados.Livro;
import dados.Cliente;
import dados.Reserva;
import java.util.ArrayList; 
import negocio.ReservaLivro;



public class Principal {
	private static ReservaLivro sistema  = new ReservaLivro();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		showMenu();
	}
	
public static void showMenu() {
	int escolha = -1;
	while(escolha != 0) {
		System.out.println("\nEscolha qual operação deseja fazer");
		System.out.println("0 - Sair");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Cadastrar Livro");
		System.out.println("3 - Fazer Reserva");
		System.out.println("4 - Mostrar Reservas");
		escolha = Integer.parseInt(scan.nextLine());
		switch(escolha) {
		case 0:
			break;
		case 1:
			cadastrarCliente();
			break;
		case 2:
			cadastrarLivro();
			break;
		case 3:
			fazerReserva();
			break;
		case 4:
			mostrarReservas();
		default:
			break;
		}
	}
}

public static void cadastrarCliente() {
	sistema.cadastraCliente(infoCliente());
}

public static Cliente infoCliente() {
	System.out.println("\nQual nome do Cliente");
	String nome = scan.nextLine();
	System.out.println("\nQual cpf do Cliente");
	String cpf = scan.nextLine();
	System.out.println("\nQual telefone do Cliente");
	int telefone = Integer.parseInt(scan.nextLine());
	System.out.println("\nQual endereco do Cliente");
	String endereco = scan.nextLine();
	
	Cliente c = new Cliente();
	c.setNome(nome);
	c.setCpf(cpf);
	c.setTelefone(telefone);
	c.setEndereco(endereco);
	
	return c;
}

public static void cadastrarLivro() {
	sistema.cadastraLivro(infoLivro());
}

public static Livro infoLivro() {
	System.out.println("\nQual nome do Livro");
	String nome = scan.nextLine();
	System.out.println("\nQual autor do Livro");
	String autor = scan.nextLine();
	System.out.println("\nQual numero do Livro");
	int numLivro = Integer.parseInt(scan.nextLine());
	
	Livro l = new Livro();
	l.setNome(nome);
	l.setAutor(autor);
	l.setNumLivro(numLivro);
	
	return l;
}

public static void fazerReserva() {
	sistema.mostrarClientes();
	System.out.println("\nDigite o cpf para quem você deseja reservar o livro");
	String cpf = scan.nextLine();
	Cliente c = sistema.buscaCliente(cpf);
	Reserva r = infoReserva();
	sistema.reservaLivro(c , r);
}

public static Reserva infoReserva() {
	sistema.mostrarLivros();
	System.out.println("\nEscolha o livro pelo numero,");
	int numLivro = Integer.parseInt(scan.nextLine());
	Livro l = sistema.buscaLivro(numLivro);
	l.setDisponivel(false);
	
	System.out.println("\nQual numero da Reserva");
	int numReserva = Integer.parseInt(scan.nextLine());
	System.out.println("\nQual data da Retirada");
	String dataRetirada = scan.nextLine();
	System.out.println("\nQual data da Entrega");
	String dataEntrega = scan.nextLine();
	
	Reserva r = new Reserva();
	r.setNumReserva(numReserva);
	r.setDataRetirada(dataRetirada);
	r.setDataEntrega(dataEntrega);
	r.setLivro(l);
	return r;
}

public static void mostrarReservas() {
	sistema.mostrarClientes();
	System.out.println("\nDigite o cpf para quem você quer consultar as reservas");
	String cpf = scan.nextLine();
	Cliente c = sistema.buscaCliente(cpf);
	for(Reserva r :sistema.mostrarReservas(c.getCpf())) {
		System.out.println(r.toString());
	}
	
}




}




