package dados;

public class Livro {
	private String nome;
	private String autor;
	private int numLivro;
	private boolean disponivel = true;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getNumLivro() {
		return numLivro;
	}
	public void setNumLivro(int numLivro) {
		this.numLivro = numLivro;
	}
	public boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public String toString() {
		return "\nLivro\nNome = " + nome + "\nAutor = " + autor + "\nnumLivro=" + numLivro;
	}
	
	

}