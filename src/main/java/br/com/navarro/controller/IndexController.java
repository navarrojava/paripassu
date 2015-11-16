package br.com.navarro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author navarro
 *
 */
@Controller
public class IndexController {

	// Sobre o static, no Logger --> http://slf4j.org/faq.html#declared_static
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
	public String index() {
		LOGGER.info("Novo acesso ao index");
		return "index";
	}
}
