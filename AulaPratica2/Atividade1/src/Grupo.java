
public class Grupo {
	private Pessoa pessoas[] = new Pessoa[5];
	private int numPessoas = 0;
	
	public Pessoa[] getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(Pessoa p) {
		if(numPessoas < 5) {
		pessoas[this.numPessoas] = p;
		this.numPessoas++;
		}else {
			System.out.println("Não foi possivel adicionar mais uma pessoa nesse grupo\n");
		}
	}
	
	public int getNumPessoas() {
		return numPessoas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		System.out.println("Pessoas: ");
		for(int i = 0; i < numPessoas; i++) {
			System.out.println(pessoas[i] + "\n");
		}
		return "Numero de pessoas: " + numPessoas + "\n";
	}

	
	public void sortByImc() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j< 5; j++) {
				if(this.pessoas[j].calculaImc() > this.pessoas[i].calculaImc()) {
					Pessoa aux = this.pessoas[j];
					this.pessoas[j] = this.pessoas[i];
					this.pessoas[i] = aux;
				}
			}
		}
	
	}
	
}
