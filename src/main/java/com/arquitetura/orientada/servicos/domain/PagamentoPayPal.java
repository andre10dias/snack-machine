package com.arquitetura.orientada.servicos.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.arquitetura.orientada.servicos.domain.enums.EstadoPagamento;

@Entity
public class PagamentoPayPal extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Date dataPagamento;

	public PagamentoPayPal() {
		// TODO Auto-generated constructor stub
	}

	public PagamentoPayPal(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataPagamento) {
		super(id, estadoPagamento, pedido);
		this.dataPagamento = dataPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	

}
