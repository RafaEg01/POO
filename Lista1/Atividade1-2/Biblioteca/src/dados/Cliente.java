package dados;
import java.util.ArrayList; 

public class Cliente {
	private String nome;
	private String cpf;
	private int telefone;
	private String endereco;
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void reservaLivro(Reserva reserva) {
		this.reservas.add(reserva);
	}
	public String toString() {
		return "\nCliente\nNome = "+nome+"\nCpf = "+cpf+"\nTelefone = "+telefone+"\nEndereco = "+endereco;
	}
	
	
	
	

}
