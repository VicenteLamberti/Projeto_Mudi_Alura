package br.com.alura.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {

	@NotBlank //Padrão da mensagem de erro é não deve estar em branco
	private String nomeProduto;
	@NotBlank
	private String urlProduto;
	@NotBlank
	private String urlImagem ;

	private String descricao ;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(getNomeProduto());
		pedido.setUrlImagem(getUrlImagem());
		pedido.setUrlProduto(getUrlProduto());
		pedido.setDescricao(getDescricao());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
	
	
}                            
