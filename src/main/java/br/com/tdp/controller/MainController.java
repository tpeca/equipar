package br.com.tdp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
//	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	
	/***
	 * ESSE MÉTODO CARREGA A PÁGINA(index.html) DE LOGIN DA NOSSA APLICAÇÃO
	 * @return
	 */
	@RequestMapping(value="/")	
	public String index(){	
	    return "index";
	}
	
}
