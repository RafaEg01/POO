package dados;

public class Reserva {
	private int numReserva;
	private String dataRetirada;
	private String dataEntrega;
	private Livro livro;
	
	public int getNumReserva() {
		return numReserva;
	}
	
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public String getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public String toString() {
		return "\nReserva\nnumReserva =" + numReserva + "\nData da Retirada = " + dataRetirada + "\nData Da Entrega =" + dataEntrega + "\nLivro = " + livro;
	}
	
	

}
