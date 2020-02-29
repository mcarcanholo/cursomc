package com.elabbora.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elabbora.cursomc.domain.Pagamento;

//Basta criar o repository da superClasse
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	

}
