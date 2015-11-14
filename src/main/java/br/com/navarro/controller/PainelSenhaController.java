package br.com.navarro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("painel")
public class PainelSenhaController {
	@RequestMapping("/home")
	public String homePainel() {
		
		return "painel";
	}
}
