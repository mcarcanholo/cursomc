package com.elabbora.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA (1, "Pessoa Física"),
	PESSOAJURIDICA (2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	//Contrutor de ENUM é private
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		 if (cod == null) {
			 return null;			 
		 }
		 //for para percorrer todos os itens do Enum
		 for (TipoCliente x : TipoCliente.values()) {
			 if (cod.equals(x.getCod())) {
				 return x;
			 }
		 }		 
		 throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	

}
