
public class Main {
public static void main(String[] args) {
	
	Grupo grupo = new Grupo();
	Pessoa p1 = new Pessoa();
	p1.setNome("Miguel");
	p1.setIdade(25);
	p1.setAltura(1.90f);
	p1.setMassa(77.0f);
	p1.calculaImc();
//	System.out.println(p1.toString()); 
	
	Pessoa p2 = new Pessoa();
	p2.setNome("Kaue");
	p2.setIdade(39);
	p2.setAltura(1.85f);
	p2.setMassa(116.0f);
	p2.calculaImc();
//	System.out.println(p2.toString()); 
	

	Pessoa p3 = new Pessoa();
	p3.setNome("Luiza");
	p3.setIdade(51);
	p3.setAltura(1.83f);
	p3.setMassa(83.0f);
	p3.calculaImc();
//	System.out.println(p3.toString()); 
	

	Pessoa p4 = new Pessoa();
	p4.setNome("Arthur");
	p4.setIdade(37);
	p4.setAltura(1.70f);
	p4.setMassa(110.0f);
	p4.calculaImc();
//	System.out.println(p4.toString()); 
	

	Pessoa p5 = new Pessoa();
	p5.setNome("Carlos");
	p5.setIdade(53);
	p5.setAltura(1.78f);
	p5.setMassa(78.0f);
	p5.calculaImc();
//	System.out.println(p5.toString()); 
	
	
	grupo.setPessoas(p1);
	grupo.setPessoas(p2);
	grupo.setPessoas(p3);
	grupo.setPessoas(p4);
	grupo.setPessoas(p5);
	grupo.sortByImc();
	System.out.println(grupo.toString());
//	System.out.println("hello world\n");
}
}
