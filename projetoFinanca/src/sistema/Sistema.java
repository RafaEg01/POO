package sistema;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dados.Gasto;
import dados.TipoGasto;
import dados.Usuario;

public class Sistema {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Usuario logadoAtual = null;

	public Usuario getLogadoAtual() {
		return logadoAtual;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void logout() {
		this.logadoAtual = null;
	}

	public void setUsuarios(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public boolean cadastrarUsuario(Usuario u) {
		if(u != null) {
			for(Usuario t : usuarios) {
				if(t.getLogin().equals(u.getLogin())) {
					return false;
				}
			}
			Usuario usuario = new Usuario(u.getLogin(),u.getSenha(),u.getIdade(),u.getCpf());
			setUsuarios(usuario);
			return true;
		}
		return false;
	}



	public Usuario loginUsuario(String login, String senha) {
		if(login != null && senha != null) {
			for(Usuario u : usuarios) {
				if(login.equals(u.getLogin()) && senha.equals(u.getSenha())) {
					this.logadoAtual = u;
					return u;
				}
			}
		}else {
			return null;	
		}
		return null;

	}

	public boolean cadastrarGasto(Usuario u, Gasto g) {
		if(u != null && g != null) {
			LinkedList<Gasto> aux = new LinkedList<Gasto>();
			aux = u.getContas().get(g.getTipogasto());
			aux.add(g);
			u.getContas().put(g.getTipogasto(), aux);
			return true;
		}else {
			System.out.println("Entrada de valores Invalidas");
			return false;
		}

	}

	public LinkedList<Gasto> visualizarGasto(Usuario u) {
		LinkedList<Gasto> aux = new LinkedList<Gasto>();
		for(TipoGasto tipo : TipoGasto.values()) {
			aux.addAll(u.getContas().get(tipo));
		}
		return aux;
	}

	public void removeGasto(Usuario u,Gasto g) {
		int cont = 0;
		TipoGasto tipogasto = g.getTipogasto();
		LinkedList<Gasto> aux = new LinkedList<Gasto>();
		aux = u.getContas().get(tipogasto);
		for(Gasto a: aux) {
			if(a.getNome().equals(g.getNome())) {
				aux.remove(cont);
				u.getContas().put(tipogasto, aux);
			}
			cont++;
		}

	}

}
