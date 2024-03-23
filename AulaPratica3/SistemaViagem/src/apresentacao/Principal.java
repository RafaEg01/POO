package apresentacao;

import java.util.Scanner;
import dados.Cidade;
import dados.Cliente;
import dados.Reserva;
import negocio.ReservaPassagem;


public class Principal {
	private static ReservaPassagem sistema  = new ReservaPassagem();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		showMenu();
	}


	public static void menu() { 
		System.out.println("Escolha uma opção:");
		System.out.println("0 - Encerrar");
		System.out.println("1 - Fazer Reserva");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Cadastrar Cidade");
		System.out.println("4 - Mostrar Reservas");
	}
	
	public static void showMenu() {
		int escolha = -1;
		while(escolha != 0) {
			menu();
			escolha = Integer.parseInt(scan.nextLine());
			switch(escolha) {
			case 1:
				fazerReserva();
			break;
			
			case 2:
				cadastrarCliente();
			break;
			
			case 3:
				cadastrarCidade();
			break;
			
			case 4:
				mostrarReservas();
			break;
			}
		
		}
	}
	
	public static Cliente infoCliente() {
		System.out.println("Digite o Nome do Cliente:");
		String nome = scan.nextLine();
		System.out.println("Digite o Cpf do Cliente:");
		String cpf = scan.nextLine();
		System.out.println("Digite o Endereco do Cliente:");
		String endereco = scan.nextLine();
		System.out.println("Digite o Telefone do Cliente:");
		long telefone = Long.parseLong(scan.nextLine());
		
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCpf(cpf);
		c.setEndereco(endereco);
		c.setTelefone(telefone);
		
		return c;
	}
	
	public static void cadastrarCliente() {
		sistema.cadastraCliente(infoCliente());
	}
	
	public static Cidade infoCidade() {
		System.out.println("Digite o Nome da Cidade");
		String nome = scan.nextLine();
		System.out.println("Digite o Estado da Cidade");
		String estado = scan.nextLine();
		
		Cidade ci = new Cidade();
		ci.setNome(nome);
		ci.setEstado(estado);
		
		return ci;
	}
	
	public static void cadastrarCidade() {
		sistema.cadastraCidade(infoCidade());
	}
	
	public static void fazerReserva() {
		sistema.mostrarCliente();
		String cpf = scan.nextLine();
		Cliente c = sistema.buscaCliente(cpf);
		
		if(c != null) {
			int escolha = -1;
			while (escolha != 0) {
					System.out.println("Selecione uma das seguintes opções");
					System.out.println("0 - Sair");
					System.out.println("1 - Reservar Ida");
					System.out.println("2 - Reservar Ida e Volta");
					escolha = Integer.parseInt(scan.nextLine());
					switch(escolha) {
				
					case 0:
						break;
					case 1:
						Reserva r = infoReserva();
						sistema.reservaIda(c, r);
					break;
				case 2:
					Reserva r1 = infoReserva();
					Reserva volta = infoReserva();
					sistema.reservaVolta(c, r1, volta);
					break;
				default:
					break;
				}
			}
			
		}
	}
	
	public static Reserva infoReserva() {
		System.out.println("Digite número da reserva");
		int num = Integer.parseInt(scan.nextLine());
		System.out.println("Digite Data do Voo");
		String data = scan.nextLine();
		System.out.println("Digite Hora do Voo");
		String hora = scan.nextLine();
		System.out.println("Digite o preço do Voo");
		float preco = Float.parseFloat(scan.nextLine()) ;
		System.out.println("Digite a Classe do Voo");
		String classe = scan.nextLine();
		System.out.println("Digite a Poltrona");
		int poltrona = Integer.parseInt(scan.nextLine());
		
		sistema.mostrarCidade();
		System.out.println("Qual cidade de Origem");
		String cidadeorigem = scan.nextLine();
		Cidade origem = sistema.buscaOrigem(cidadeorigem);
		
		sistema.mostrarCidade();
		System.out.println("Qual cidade de Destino");
		String cidadedestino = scan.nextLine();
		Cidade destino = sistema.buscaDestino(cidadedestino);
			
		Reserva r = new Reserva();
		r.setDataVoo(data);
		r.setHoraVoo(hora);
		r.setPreco(preco);
		r.setClasseVoo(classe);
		r.setPoltrona(poltrona);
		r.setOrigem(origem);
		r.setDestino(destino);
		
		
		return r;
		
	}
	
	public static void mostrarReservas() {
		sistema.mostrarCliente();
		String cpf = scan.nextLine();
		Cliente c = sistema.buscaCliente(cpf);
		for(Reserva r :sistema.mostrarReservas(c.getCpf())) {
			System.out.println(r.toString());
		}
	}
	
	
}
	
