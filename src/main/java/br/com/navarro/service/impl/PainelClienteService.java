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

	public Senha solicitaSenha(Senha.TipoSenha tipoSenha) {
		int numeroSenha = contadorNormal++;
		Senha senha = new Senha();
		
		senha.setId(numeroSenha + 1);
		senha.setNumero(numeroSenha);
		senha.setTipoSenha(tipoSenha);
		
		senha.setMascaraSenha(tipoSenha + String.format("%04d", numeroSenha));
		
		senha = memoryDatabase.geraSenha(senha, tipoSenha);
		return senha;
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
}
