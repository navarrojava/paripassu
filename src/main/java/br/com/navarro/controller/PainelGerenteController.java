package br.com.navarro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.navarro.model.Message;
import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelGerenteService;
/**
 * 
 * @author navarro
 *
 */
@Controller
@RequestMapping("gerente")
public class PainelGerenteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PainelClienteControler.class);

	@Autowired
	IPainelGerenteService iPainelGerenteService;

	@RequestMapping("home")
	public String homeGerente() {
		return  "redirect:/ng/gerente.html";
	}

	@RequestMapping("proxima-senha")
	@ResponseBody	
	public Senha ChamarProximaSenha() {
		LOGGER.info("Chamada de nova senha - ChamarProximaSenha() ");
		return iPainelGerenteService.chamaProximaSenha();
	}

	@RequestMapping("todas-as-senhas")
	@ResponseBody
	public List<Senha> todasAsSenhas() {
		LOGGER.info("Todas as senhas -  todasAsSenhas()");
		return iPainelGerenteService.todasAsSenhas();
	}

	@RequestMapping(value="zerar-contador",  method = RequestMethod.GET)
	public @ResponseBody Message zerarContador(){
		LOGGER.info("Zerado o contador - zerarContador()");
		return iPainelGerenteService.zeraContadorSenha();
	}
}
