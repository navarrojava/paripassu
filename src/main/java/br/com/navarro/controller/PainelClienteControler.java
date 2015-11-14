package br.com.navarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@Autowired
	IPainelClienteService iPainelUsuarioService;
	
	@RequestMapping("home")
    public String homeCliente(){
		
		return "cliente";
	}
	
	
	@RequestMapping("solicitar-senha")
	@ResponseBody
	public Senha solicitarSenha(@RequestParam("tipo") Senha.TipoSenha tipo){
		return iPainelUsuarioService.solicitaSenha(tipo);
	}
}
