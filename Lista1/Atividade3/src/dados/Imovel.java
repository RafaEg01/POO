package dados;

public class Imovel {
	private float largura;
	private float comprimento;
	private float preco;
	private float area;
	
	
	public float getLargura() {
		return largura;
	}
	public void setLargura(float largura) {
		this.largura = largura;
	}
	public float getComprimento() {
		return comprimento;
	}
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public void setArea(float largura,float comprimento) {
		this.area =  largura*comprimento;
	}
	public float getArea() {
		return area;
	}
	
	public String toString() {
		return "\nImovel \nLargura = " + largura + "\nComprimento = " + comprimento + "\nPreco = " + preco + "\nArea = " + area +" m^2";
	}

}
