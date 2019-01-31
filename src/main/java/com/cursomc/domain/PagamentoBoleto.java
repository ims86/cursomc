package com.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Date dtVencimento;
	private Date dtPagamento;
	
	public PagamentoBoleto() {
		
	}

	public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dtVencimento, Date dtPagamento) {
		super(id, estado, pedido);
		this.dtPagamento = dtPagamento;
		this.dtVencimento = dtVencimento;

	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	
	
	
	

}
