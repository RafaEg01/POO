package negocio;

import dados.Livro;
import dados.Cliente;
import dados.Reserva;
import java.util.ArrayList; 


public class ReservaLivro {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public void cadastraCliente(Cliente cliente){
		this.clientes.add(cliente);
	}
	
	public void cadastraLivro(Livro livro) {
		this.livros.add(livro);
	}
	
	public ArrayList<Cliente> mostraClientes(){
		return this.clientes;
	}

	public ArrayList<Livro> mostraLivros(){
		return this.livros;
	}
	
	public void mostrarClientes() {
		for(Cliente clientes: this.mostraClientes()) {
			System.out.println(clientes.toString());
		}
	}
	
	public void mostrarLivros() {
		for(Livro livros: livros) {
			if(livros.isDisponivel() == true) {
				System.out.print(livros.toString());
			}
		}
	}

	public Livro buscaLivro(int numLivro) {
		for(Livro l: livros) {
			if(l.getNumLivro() == numLivro) {
				return l;
			}
		}
		return null;
	}
	
	public Cliente buscaCliente(String cpf) {
		for(Cliente c : clientes) {
			if(c.getCpf().equals(cpf)) {
				return c;
			}
		}
		return null;
	}
	
	public void reservaLivro(Cliente cliente, Reserva reserva) {
		cliente.reservaLivro(reserva);
	}
	
	public ArrayList<Reserva> mostrarReservas(String cpfCliente) {
		Cliente c = buscaCliente(cpfCliente);
		if(c!=null) {
			return c.getReservas();
		}
		return new ArrayList<Reserva>();
	}

	
	

}
