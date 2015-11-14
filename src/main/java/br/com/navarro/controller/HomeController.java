package br.com.navarro.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.navarro.model.Senha;
import br.com.navarro.service.IPainelGerenteService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private IPainelGerenteService service;
	@Autowired
	private Senha senha;
	
	@RequestMapping("/")
	public String index() {
		
		return "index";
	}
	
	

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public @ResponseBody ArrayList<Senha> home(Locale locale, Model model) throws Exception {

		ArrayList<Senha> arraySenha = new ArrayList<Senha>();

		senha.setId(1);
		senha.setNumero(0001);
		senha.setTipoSenha(br.com.navarro.model.Senha.TipoSenha.GERAL);
		

		arraySenha.add(senha);
		arraySenha.add(senha);

		service.chamaProximaSenha();

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return arraySenha;
	}

}
