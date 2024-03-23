package dados;
import java.util.ArrayList;

public class Cliente {
	private String cpf;
	private String nome;
	private String endereco;
	private long telefone;
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	public void reservaIda(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void reservaVolta(Reserva ida, Reserva volta){
		ida.setVolta(volta);
		this.reservas.add(ida);
	}

	
	public String toString() {
		return "Cliente [cpf = " + cpf + ", nome = " + nome + ", endereco = " + endereco + ", telefone = " + telefone + "]\n";
	}
	
	
	
}
