package br.com.navarro.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.navarro.model.Senha;
/**
 * 
 * @author navarro
 *
 */
@Component
public class MemoryDatabase {

	private List<Senha> senhasNormais = new ArrayList<Senha>();
	private List<Senha> senhasPreferenciais = new ArrayList<Senha>();

	// private ArrayList<Senha> senhasNormais = new ArrayList<Senha>();

	public Senha proximaSenha() {
		Senha senha = null;
		if (senhasPreferenciais != null && !senhasPreferenciais.isEmpty()) {
			 senha  = this.senhasPreferenciais.remove(0);
		} else if (senhasNormais != null && !senhasNormais.isEmpty()){
			senha = this.senhasNormais.remove(0);
		}
		return senha;
	}

	

	public List<Senha> todasAsSenha() {

		if (senhasPreferenciais.size() > 0) {
			return senhasPreferenciais;
		} else if (senhasNormais.size() > 0) {
			return senhasNormais;
		}
		return null;
	}

	public Senha geraSenha(Senha senha1, Senha.TipoSenha tipoSenha) {

		switch (tipoSenha) {
		case N:
			senhasNormais.add(senha1);
			return senha1;
		case P:
			senhasPreferenciais.add(senha1);
			return senha1;
		default:
			break;
		}
		return senha1;
	}



	
	/* Getters e Setters */
	
	public List<Senha> getSenhasNormais() {
		return senhasNormais;
	}



	public void setSenhasNormais(List<Senha> senhasNormais) {
		this.senhasNormais = senhasNormais;
	}



	public List<Senha> getSenhasPreferenciais() {
		return senhasPreferenciais;
	}



	public void setSenhasPreferenciais(List<Senha> senhasPreferenciais) {
		this.senhasPreferenciais = senhasPreferenciais;
	}


	
	
}
