package br.com.alura.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.repository.PedidoRepository;

@Controller 
@RequestMapping("/home") // Colocando aqui , todo método eu não preciso ficar colocando (/home) antes do endpoint do método
public class HomeController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
//	@RequestMapping("/home")
//	public ModelAndView home() {
//	    List<Pedido> pedidos = pedidoRepository.findAll();
//	    ModelAndView mv = new ModelAndView("home");
//	    mv.addObject("pedidos", pedidos);
//	    return mv; 
//	} 
	
	@GetMapping("")
	public String home(Model model, Principal principal) {
		
		Sort sort = Sort.by("dataEntrega").descending();
		
		PageRequest paginacao = PageRequest.of(0, 10,sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE,paginacao);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
//	
////	@GetMapping("/aguardando")
////	public String aguardando(Model model) {
////		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);
////		model.addAttribute("pedidos", pedidos);
////		return "home";
////	}
////	
////	@GetMapping("/aprovado")
////	public String aprovado(Model model) {
////		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.APROVADO);
////		model.addAttribute("pedidos", pedidos);
////		return "home";
////	}
////	
////	@GetMapping("/entregue")
////	public String entregue(Model model) {
////		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
////		model.addAttribute("pedidos", pedidos);
////		return "home";
////	}

	
	
//	@GetMapping("/{status}")
//	public String entregue(@PathVariable("status") String status,Model model) {
//		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
//		model.addAttribute("pedidos", pedidos);
//		model.addAttribute("status",status);
//		return "home";
//	}
//	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public String onError() {
//		return "redirect:/home";
//	}
	
	
}
