package br.com.navarro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelClienteService;
/**
 * 
 * @author navarro
 *
 */
@Controller
@RequestMapping("cliente")
public class PainelClienteControler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PainelClienteControler.class);

	@Autowired
	IPainelClienteService iPainelUsuarioService;
	
	@RequestMapping("home")
    public String homeCliente(){
		LOGGER.info("Acesso ao home cliente -  homeCliente()");
		return  "redirect:/ng/cliente.html";
	}
	
	@RequestMapping("solicitar-senha")
	@ResponseBody
	public Senha solicitarSenha(@RequestParam("tipo") Senha.TipoSenha tipo){
		return iPainelUsuarioService.solicitaSenha(tipo);
	}
	
	@RequestMapping("verifica-se-fui-chamado")
	@ResponseBody
    public Senha verificaSeFuiChamado(@RequestBody Senha senha){
		return iPainelUsuarioService.verificaSeFoiChamado(senha);
	}
	
}
