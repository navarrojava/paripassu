package br.com.navarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.navarro.database.MemoryDatabase;
import br.com.navarro.model.Message;
import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelClienteService;
import br.com.navarro.service.IPainelGerenteService;

@Service
public class PainelGerenteService implements IPainelGerenteService {

	@Autowired MemoryDatabase memoryDatabase;
	@Autowired Senha senha;
	@Autowired IPainelClienteService iPainelClienteService;

	@Override
	public Senha chamaProximaSenha() {
		senha = memoryDatabase.proximaSenha();
		return senha;
	}

	@Override
	public List<Senha> todasAsSenhas() {
		List<Senha> ads = memoryDatabase.todasAsSenha();
		return ads;
	}

	@Override
	public Message zeraContadorSenha() {

		try {
			memoryDatabase.setSenhasNormais(null);
			memoryDatabase.setSenhasPreferenciais(null);
			iPainelClienteService.setContadorNormal(0);
			iPainelClienteService.setContadorPreferencial(0);
		} catch (Exception e) {
			
		}
		
		return new Message(1, "Painel Zerado Com Sucesso");
	}

}
