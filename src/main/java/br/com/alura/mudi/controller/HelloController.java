package br.com.alura.mudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/oi")  
	public String hello(HttpServletRequest req) {
		req.setAttribute("nome", "VICENTE NOME VINDO DO CONTROLLER METODO hello usando HttpServletRequest");
		return "OiMundo";
	}
	
	@GetMapping("/oi2")  
	public String hello2(Model model) {
		model.addAttribute("nome", "VICENTE NOME VINDO DO CONTROLLER METODO hello usando Model addAttribute");
		return "OiMundo";
	}
}
