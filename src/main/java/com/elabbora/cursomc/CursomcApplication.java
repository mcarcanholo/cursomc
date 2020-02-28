package com.elabbora.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.elabbora.cursomc.domain.Categoria;
import com.elabbora.cursomc.domain.Cidade;
import com.elabbora.cursomc.domain.Estado;
import com.elabbora.cursomc.domain.Produto;
import com.elabbora.cursomc.repositories.CategoriaRepository;
import com.elabbora.cursomc.repositories.CidadeRepository;
import com.elabbora.cursomc.repositories.EstadoRepository;
import com.elabbora.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepositoy;
	
	@Autowired
	private ProdutoRepository produtoRepositoy;
	
	@Autowired
	private EstadoRepository estadoRepositoy;
	
	@Autowired
	private CidadeRepository cidadeRepositoy;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));		
			
		categoriaRepositoy.saveAll(Arrays.asList(cat1, cat2));
		produtoRepositoy.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		//Tem que seguir obrigatoriamente a sequencia de interdependencia (primento o lado OneToMany)
		estadoRepositoy.saveAll(Arrays.asList(est1, est2));
		cidadeRepositoy.saveAll(Arrays.asList(c1, c2, c3));
		
	}
	 
	

}
