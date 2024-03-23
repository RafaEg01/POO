package negocio;

import java.util.ArrayList;

import dados.Cidade;
import dados.Cliente;
import dados.Reserva;


public class ReservaPassagem {
	private ArrayList<Cidade> cidades = new ArrayList<Cidade>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private int numReservas = 0;

public void cadastraCliente(Cliente cliente){
	this.clientes.add(cliente);
}

public void cadastraCidade(Cidade cidade) {
	this.cidades.add(cidade);
}

public ArrayList<Cliente> mostraClientes(){
	return this.clientes;
}

public ArrayList<Cidade> mostraCidades(){
	return this.cidades;
}

public void mostrarCliente() {
	for(Cliente clientes: this.mostraClientes()) {
		System.out.println(clientes.toString());
	}
}

public void mostrarCidade() {
	for(Cidade cidades:this.mostraCidades()) {
		System.out.println(cidades.toString());
	}
}

public Cliente buscaCliente(String cpf) {
	for(Cliente c : clientes) {
		if(c.getCpf().equals(cpf)) {
			return c;
		}
	}
	return null;
}

public Cidade buscaOrigem(String origem) {
	for(Cidade c : cidades) {
		if(c.getNome().equals(origem)) {
			return c;
		}
	}
	return null;
}

public Cidade buscaDestino(String destino) {
	for(Cidade c : cidades) {
		if(c.getNome().equals(destino)) {
			return c ;
		}
	}
	return null;
}

public void reservaIda(Cliente cliente, Reserva ida) {
	ida.setNumReserva(this.numReservas);
	this.numReservas++;
	cliente.reservaIda(ida);
}

public void reservaVolta(Cliente cliente, Reserva ida, Reserva volta) {
	ida.setNumReserva(this.numReservas);
	this.numReservas++;
	volta.setNumReserva(this.numReservas);
	this.numReservas++;
	cliente.reservaVolta(ida, volta);
}

public ArrayList<Reserva> mostrarReservas(String cpfCliente) {
	Cliente c = buscaCliente(cpfCliente);
	if(c!=null) {
		return c.getReservas();
	}
	return new ArrayList<Reserva>();
}

}