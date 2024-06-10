package dados;



import java.time.LocalDate;


public class Gasto {
	private String nome;
	private LocalDate data;
	private String descricao;
	private float valor;
	private TipoGasto tipogasto;
	private static int total = 0;

	
	public Gasto(String nome,LocalDate data,String descricao,float valor,TipoGasto tipogasto){
		Gasto.total++;
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
		this.tipogasto = tipogasto;
	}
	

	public static int getTotal() {
		return total;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public TipoGasto getTipogasto() {
		return this.tipogasto;
	}

	public void setTipogasto(TipoGasto tipo) {
		this.tipogasto = tipo;
	}

	@Override
	public String toString() {
		return "\n\nGasto \n[nome = " + nome + ",\ndata = " + data + ",\ndescricao = " + descricao + ",\nvalor = " + valor
				+ ",\ntipogasto = " + tipogasto + "]";
	}
	
	

	
	
}
