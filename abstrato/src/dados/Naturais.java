package dados;

import java.util.List;

public class Naturais extends Gerador {

	public void gerar(int quantidade) {
		for(int i = 0 ; i <= quantidade; i++) {
			sequencia.add(i);
		}
		
	}

}
