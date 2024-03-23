package dados;

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Random;

public class Sorteador {
	private ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();

	public ArrayList<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(ArrayList<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		this.pessoa.add(pessoa);
	}
	public Pessoa sortearProximo() {
		Random gerador = new Random();
		pessoa.toArray();
		if(pessoa.size() != 0) {
			Pessoa p = pessoa.get(gerador.nextInt(pessoa.size()));
			Pessoa aux = p;
			pessoa.remove(p);
			return aux;
		}else {
			return null;
		}
		
	}
}
