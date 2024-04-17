package dados;

import java.util.ArrayList;
import java.util.List;

public abstract class Gerador {
	protected List<Integer> sequencia = new ArrayList();
	

	public void setSequencia(List<Integer> sequencia) {
		this.sequencia = sequencia;
	}

	public abstract void gerar(int quantidade);

	public List<Integer> getSequencia(){
		return sequencia;
	}
}
