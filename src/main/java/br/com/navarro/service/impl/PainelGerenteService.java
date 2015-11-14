package br.com.navarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.navarro.database.MemoryDatabase;
import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelGerenteService;

@Service
public class PainelGerenteService implements IPainelGerenteService {

	@Autowired
	MemoryDatabase memoryDatabase;
	
	@Autowired
	Senha senha;
	
	@Override
	public Senha chamaProximaSenha()  {
		senha  = memoryDatabase.proximaSenha();
		return senha;
	}

	@Override
	public void zeraContadorSenha() {

	}

	@Override
	public List<Senha> todasAsSenhas() {
		List<Senha> ads = memoryDatabase.todasAsSenha();
		return ads;
	}

}
