package br.com.navarro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelGerenteService;

@Controller
@RequestMapping("gerente")
public class PainelGerenteController {
	private static final Logger LOG = LoggerFactory.getLogger(PainelClienteControler.class);

	
	@Autowired
	IPainelGerenteService iPainelGerenteService;

	@RequestMapping("home")
	public String homeGerente() {

		return "gerente";
	}

	@RequestMapping("proxima-senha")
	@ResponseBody	
	public Senha ChamarProximaSenha() {
		LOG.info("Chamada de Nova Senha");
		return iPainelGerenteService.chamaProximaSenha();
		
	}

	@RequestMapping("todas-as-senhas")
	@ResponseBody
	public List<Senha> todasAsSenhas() {
		return iPainelGerenteService.todasAsSenhas();
	}

	@RequestMapping("zerar-contaor")
	public void zerarContador(){
		iPainelGerenteService.zeraContadorSenha();
	}
	
	
	@RequestMapping("painel")
	public String painel() {

		return "painel";
	}
}
