package br.com.navarro.controller;

/**
 * 
 * @author navarro
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("painel")
public class PainelSenhaController {
	
	@RequestMapping("/home")
	public String homePainel() {
		return "redirect:/ng/painel.html";
	}
}
