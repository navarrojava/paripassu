package br.com.navarro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.navarro.database.MemoryDatabase;
import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelClienteService;

@Service
public class PainelClienteService implements IPainelClienteService {

	@Autowired
	private MemoryDatabase memoryDatabase;
	private int contadorNormal = 1;
	private int contadorPreferencial = 1;
	private int idContador = 0;

	@Override
	public Senha solicitaSenha(Senha.TipoSenha tipoSenha) {

		// FIXME: MOVER PARA A CLASSE MemoryDatabase.java
		// return memoryDatabase.geraSenha(tipoSenha);

		switch (tipoSenha) {
		case NORMAL:
//			return memoryDatabase.geraSenha(new Senha(idContador++, contadorNormal++, tipoSenha, true), tipoSenha);
			return memoryDatabase.geraSenha(tipoSenha);

		case PREFERENCIAL:
			return memoryDatabase.geraSenha(tipoSenha);
		default:
			return new Senha();
		}
	}

	@Override
	public Senha verificaSeFoiChamado(Senha senha) {
		return memoryDatabase.pegaUma(senha);
	}

	/* Getetrs e Setters */
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
