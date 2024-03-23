package dados;

public class Dono {
private String nome;
private Endereco endereco;
private String cpf;


public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Endereco getEndereco() {
	return endereco;
}
public void setEndereco(Endereco endereco) {
	this.endereco = endereco;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
@Override
public String toString() {
	return "Dono [nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + "]";
}


}
