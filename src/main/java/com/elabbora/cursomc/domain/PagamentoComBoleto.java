package com.elabbora.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.elabbora.cursomc.domain.enums.EstadoPagamento;

//Extends, vai herdar tudo que pagamento tem
@Entity
public class PagamentoComBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	//Como PagamentoComBoleto extends Pagamento, source - Genenate Construtor SuperClass e adicionar os campos que faltam na mão
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
		// TODO Auto-generated constructor stub
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	

}
