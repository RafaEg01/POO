public class Pessoa {
	private String nome;
	private int idade;
	private float altura;
	private float massa;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setMassa(float massa) {
		this.massa = massa;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public float getAltura() {
		return this.altura;
	}
	
	public float getMassa() {
		return this.massa;
	}
	
	
	
	public float calculaImc() {
		return this.massa/(this.altura*this.altura);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + nome + "\nAltura: " + altura + "\nMassa: " + massa +"\nIMC: " + calculaImc();
	}
	
	
	
}

