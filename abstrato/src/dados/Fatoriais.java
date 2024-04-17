package dados;

public class Fatoriais extends Gerador{
	
	
	public void gerar(int quantidade) {
		int mult = 1;
		if(quantidade != 0) {
		for(int i = 0 ; i <= quantidade ; i++) {
			for(int j = 1; j <= i; j++) {
				mult *= j;
			}
			sequencia.add(mult);
			mult = 1;
		}
		}else {
			sequencia.add(1);
		}
		
	}

}
