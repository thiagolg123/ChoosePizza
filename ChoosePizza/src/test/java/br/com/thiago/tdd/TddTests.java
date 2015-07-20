package br.com.thiago.tdd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import br.com.thiago.domain.NomePizzas;
import br.com.thiago.service.DadosService;
import br.com.thiago.service.impl.DadosNomePizza;

public class TddTests {

	@Test
	public void deveRecolherNomeDasPizzas() {
		DadosService<String> dadosService = new DadosNomePizza();
		
		List<String> nomePizzas = dadosService.getDados(new NomePizzas());
				 
		assertEquals("queijo", nomePizzas.get(0));
	}

}
