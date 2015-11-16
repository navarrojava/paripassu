package br.com.navarro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.navarro.database.MemoryDatabase;
import br.com.navarro.model.Message;
import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelGerenteService;

@Service
public class PainelGerenteService implements IPainelGerenteService {

	@Autowired
	MemoryDatabase memoryDatabase;
	
	@Override
	public Senha chamaProximaSenha() {
		return memoryDatabase.proximaSenha();
	}

	@Override
	public List<Senha> todasAsSenhas() {
		return memoryDatabase.todasAsSenhas();
	}

	@Override
	public Message zeraContadorSenha() {
		memoryDatabase.deletaTodasAsSenhas();
		return new Message(1, "Painel zerado com sucesso!");
	}
}
