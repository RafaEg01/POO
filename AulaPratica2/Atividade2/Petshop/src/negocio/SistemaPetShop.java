package negocio;
import java.util.Scanner;

import dados.*;

public class SistemaPetShop{
	private static Veterinario[] veterinarios = new Veterinario[50];
	private static int numVeterinarios = 0;
	static Scanner scan = new Scanner(System.in);

	public static void Menu() {
		System.out.println("Escolha o que deseja fazer");
		System.out.println("1 - Cadastrar veterinario");
		System.out.println("2 - Mostrar veterinarios");
		System.out.println("3 - Cadastrar endereco veterinario");
		System.out.println("4 - Cadastrar animal");
		System.out.println("5 - Mostrar animais");
		System.out.println("6 - Cadastrar dono");
		System.out.println("7 - Sair");

	}

	public static void main(String[] args) {
		int escolha = -1;
		while (escolha != 0) {
			Menu();
			escolha = Integer.parseInt( scan.nextLine());
			switch(escolha) {
			case 1 :
				cadastrarVet();
				break;
			case 2:
				mostrarVet();
				break;
			case 3:
				cadastraEnderecoVet();
				break;
			case 4:
				cadastraAnimalVet();
				break;
			case 5:
				mostrarAnimal();
				break;
			case 6:
				cadastraDono();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Opção não valida");

			}
		}
	}
	public  static void cadastrarVet() {
		if(numVeterinarios < 50) {
			Veterinario v = new Veterinario();
			System.out.println("Digite nome do veterinario");
			String nome;
			nome = scan.nextLine();
			v.setNome(nome);
			System.out.println("Digite o salario");
			v.setSalario(Double.parseDouble(scan.nextLine()));
			veterinarios[numVeterinarios] = v;
			numVeterinarios++;

		}else {
			System.out.println("Limite de veterinarios excedido");
		}

	}
	public  static void mostrarVet() {
		for(int i = 0; i < numVeterinarios; i++ ) {
			System.out.println("Codigo Vet - " + i);
			System.out.println(veterinarios[i].toString() + "\n");
		}

	}


	public static void cadastraEnderecoVet() {
		Veterinario vet = escolheVet();
		if(vet != null) {
			vet.setEndereco(cadastraEndereco());
		}	
	}



	public static Endereco cadastraEndereco() {

		Endereco e = new Endereco();
		System.out.println("Digite a rua");
		e.setRua(scan.nextLine());
		System.out.println("Digite o numero");
		e.setNumero(Integer.parseInt(scan.nextLine()));
		System.out.println("Digite o bairro");
		e.setBairro(scan.nextLine());
		System.out.println("Digite a cidade");
		e.setCidade(scan.nextLine());
		System.out.println("Digite o estado");
		e.setEstado(scan.nextLine());
		System.out.println("Digite o cep");
		e.setCep(scan.nextLine());

		return e;

	}

	public static Veterinario escolheVet() {
		mostrarVet();
		System.out.println("Escolha o veterinario");
		int escolha;
		escolha = Integer.parseInt(scan.nextLine());
		if(escolha > numVeterinarios) {
			return null;
		}else {
			return veterinarios[escolha];
		}
	}



	public  static void cadastraAnimalVet() {
		Veterinario vet = escolheVet();
		if(vet != null) {
			vet.setAnimais(infoAnimal());
		}

	}

	public static Animal infoAnimal() {
		Animal animal = new Animal();
		System.out.println("Nome do animal");
		animal.setNome(scan.nextLine());
		System.out.println("Especie do animal");
		animal.setEspecie(scan.nextLine());
		System.out.println("Descricao animal");
		animal.setDescricao(scan.nextLine());

		return animal;

	}
	public static void mostrarAnimal() {
		Veterinario vet = escolheVet();
		if(vet != null) {
			for(int i = 0 ; i < vet.getNumAnimal(); i++){
				System.out.println("Codigo Animal - " + i);
				System.out.println(vet.getAnimais()[i].toString() + "\n");

			}
		}

	}

	public static Animal escolheAnimal() {
		Veterinario vet = escolheVet();

		if(vet != null) {
			for(int i = 0 ; i < vet.getNumAnimal(); i++){
				System.out.println("Codigo Animal - " + i);
				System.out.println(vet.getAnimais()[i].toString() + "\n");

			}
		}

		System.out.println("Escolha o Animal");
		int codigo;
		codigo = Integer.parseInt(scan.nextLine());

		if(codigo > vet.getNumAnimal()) {
			System.out.println("Numero invalido");
			return null;
		}else {
			return vet.getAnimais()[codigo];
		}
	}

	public static void cadastraDono() {
		Animal animal = escolheAnimal();
		if(animal != null) {
			animal.setDono(infoDono());
		}
	}


	public static Dono infoDono() {
		Dono dono = new Dono();
		System.out.println("Nome Dono");
		dono.setNome(scan.nextLine());
		System.out.println("Digite Cpf Dono");
		dono.setCpf(scan.nextLine());
		dono.setEndereco(cadastraEndereco());

		return dono;
	}






}




