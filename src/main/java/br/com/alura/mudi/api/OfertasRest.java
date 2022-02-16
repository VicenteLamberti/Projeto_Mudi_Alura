package br.com.alura.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mudi.model.Oferta;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	
//	@PostMapping
//	public ResponseEntity<Oferta> criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
//		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
//		if(!pedidoBuscado.isPresent()) {
//			return null;
//		}
//		
//		Pedido pedido = pedidoBuscado.get();
//		
//		Oferta novaOferta = requisicao.toOferta();
//		
//		novaOferta.setPedido(pedido);
//		
//		pedido.getOfertas().add(novaOferta);
//		
//		pedidoRepository.save(pedido);
//		
//		return ResponseEntity.ok(novaOferta);
//	}
	
	@PostMapping
	public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		
		Oferta novaOferta = requisicao.toOferta();
		
		novaOferta.setPedido(pedido);
		
		pedido.getOfertas().add(novaOferta);
		
		pedidoRepository.save(pedido);
		
		return novaOferta;
	}
	
	
}
