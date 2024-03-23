package dados;

import java.util.ArrayList;

public class Imobiliaria {
	private String nome = "Anage";
	private ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}
	public void setImoveis(ArrayList<Imovel> imoveis) {
		this.imoveis = imoveis;
	}
	
	public void addImovel(Imovel imovel) {
		this.imoveis.add(imovel);
	}
	
	public void filtrarPorArea(float x) {
		for(Imovel i: imoveis) {
			if(i.getArea() >= x) {
				System.out.println("\n" + this.nome + i.toString());
			}
		}
	}
	
	public void cadastrarImovel(Imovel imovel){
			this.imoveis.add(imovel);
	}
	
	public String toString() {
		return "\nImobiliaria\nNome=" + nome + "\nImoveis = " + imoveis;
	}
	
	

}
