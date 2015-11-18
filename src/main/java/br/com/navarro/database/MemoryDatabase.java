package br.com.navarro.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.navarro.model.Senha;
import br.com.navarro.validator.Validator;

/**
 * 
 * @author navarro
 *
 */
@Component
public class MemoryDatabase {

	private List<Senha> senhasNormais = new ArrayList<Senha>();
	private List<Senha> senhasPreferenciais = new ArrayList<Senha>();

	private int contadorNormal = 0;
	private int contadorPreferencial = 0;
	private int idContador = 0;

	public Senha proximaSenha() {
		if (Validator.isValid(senhasPreferenciais)) {
			return this.senhasPreferenciais.remove(0);
		} else if (Validator.isValid(senhasNormais)) {
			return this.senhasNormais.remove(0);
		} else
			return null;
	}

	public List<Senha> todasAsSenhas() {
		if (Validator.isValid(senhasPreferenciais)) {
			return senhasPreferenciais;
		} else if (Validator.isValid(senhasNormais)) {
			return senhasNormais;
		}
		return null;
	}

	public Senha geraSenha(Senha.TipoSenha tipoSenha) {

		switch (tipoSenha) {
		
		case NORMAL:
			senhasNormais.add(new Senha(idContador++, contadorNormal++, tipoSenha, true));
			return senhasNormais.get(senhasNormais.size() -1);
		case PREFERENCIAL:
			senhasPreferenciais.add(new Senha(idContador++, contadorPreferencial++, tipoSenha, true));
			return senhasPreferenciais.get(senhasPreferenciais.size() -1);

		default:
			break;
		}
		return null;
	}

	public void deletaTodasAsSenhas() {
		senhasNormais.clear();
		senhasPreferenciais.clear();
		contadorNormal = 0;
		contadorPreferencial = 0;
	}

	public Senha getSenha(Senha senhaParam) {
		if (Validator.isValid(senhaParam)) {

			switch (senhaParam.getTipoSenha()) {
			case PREFERENCIAL:
				for (Senha senha : senhasPreferenciais) {
					if (senhaParam.getId() == senha.getId())
						System.out.println("Senha Param: " + senhaParam.getId() + " SenhasPref..." + senha.getId());
					return senhaParam;
				}
			case NORMAL:
				for (Senha senha : senhasNormais) {
					if (senhaParam.getId() == senha.getId())
						System.out.println("Senha Param: " + senhaParam.getId() + " Normais..." + senha.getId());
					return senhaParam;
				}
			default:
				break;
			}
		}
		return new Senha();
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

	public int getContadorNormal() {
		return contadorNormal;
	}

	public void setContadorNormal(int contadorNormal) {
		this.contadorNormal = contadorNormal;
	}

	public int getContadorPreferencial() {
		return contadorPreferencial;
	}

	public void setContadorPreferencial(int contadorPreferencial) {
		this.contadorPreferencial = contadorPreferencial;
	}

	public int getIdContador() {
		return idContador;
	}

	public void setIdContador(int idContador) {
		this.idContador = idContador;
	}
}
