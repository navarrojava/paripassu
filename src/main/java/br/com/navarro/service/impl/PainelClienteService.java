package br.com.navarro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.navarro.database.MemoryDatabase;
import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelClienteService;
import br.com.navarro.validator.Validator;

@Service
public class PainelClienteService implements IPainelClienteService {

	@Autowired
	private MemoryDatabase memoryDatabase;

	@Override
	public Senha solicitaSenha(Senha.TipoSenha tipoSenha) {
		return memoryDatabase.geraSenha(tipoSenha);
	}

	@Override
	public Senha verificaSeFoiChamado(Senha senha) {
		return Validator.isValid(senha) ? memoryDatabase.getSenha(senha) : null;
	}
}
