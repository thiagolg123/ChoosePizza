package br.com.thiago.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.thiago.enums.NomePizzas;
import br.com.thiago.enums.NotaPizza;
import br.com.thiago.model.Pessoa;
import br.com.thiago.model.Pizza;
import br.com.thiago.service.BuildDadosPedido;

public class TddTests {

	@Test
	public void deveMontarListaNomeDasPizzas() {
		List<Pizza> pizzas = new ArrayList<>();

		Pizza pizzaPortugues = new Pizza();
		pizzaPortugues.setNome(NomePizzas.PORTUGUESA);

		Pizza pizzaMarguerita = new Pizza();
		pizzaMarguerita.setNome(NomePizzas.MARGUERITA);

		pizzas.add(pizzaMarguerita);
		pizzas.add(pizzaPortugues);

		Assert.assertEquals("Portuguesa", pizzas.get(1).getNome().toString());
		Assert.assertEquals("Marguerita", pizzas.get(0).getNome().toString());
	}

	@Test
	public void deveMontarListaNotaDasPizzas() {
		List<Pizza> notaPizzas = new ArrayList<>();

		Pizza pizzaNotaUm = new Pizza();
		pizzaNotaUm.setNome(NomePizzas.PORTUGUESA);
		pizzaNotaUm.setNota(NotaPizza.UM);

		Pizza pizzaNotaDois = new Pizza();
		pizzaNotaDois.setNome(NomePizzas.MARGUERITA);
		pizzaNotaDois.setNota(NotaPizza.DOIS);

		notaPizzas.add(pizzaNotaUm);
		notaPizzas.add(pizzaNotaDois);

		Assert.assertEquals(1, notaPizzas.get(0).getNota().getValue());
		Assert.assertEquals(2, notaPizzas.get(1).getNota().getValue());
	}
	
	@Test
	public void deveMontarMapComNomeDasPessoasEDadosPizzas(){
		List<Pizza> pizzasRenato = new ArrayList<>();
		List<Pizza> pizzasLuca = new ArrayList<>();
				
		Pizza pizzaPortuguesaRenato = new Pizza(NomePizzas.PORTUGUESA, NotaPizza.QUATRO);
		Pizza pizzaMarguiritaRenato = new Pizza(NomePizzas.MARGUERITA, NotaPizza.CINCO);
		
		Pizza pizzaMarguiritaLuca = new Pizza(NomePizzas.MARGUERITA, NotaPizza.TRES);
		Pizza pizzaPortuguesaLuca = new Pizza(NomePizzas.PORTUGUESA, NotaPizza.UM);
		
		pizzasRenato.add(pizzaMarguiritaRenato);
		pizzasRenato.add(pizzaPortuguesaRenato);
		
		pizzasLuca.add(pizzaPortuguesaLuca);
		pizzasLuca.add(pizzaMarguiritaLuca);
		
		Pessoa Renato = new Pessoa("Renato");
		Pessoa Luca = new Pessoa("Luca");


		Map<String, List<Pizza>> dadosRenato = BuildDadosPedido.toMap(Renato, pizzasRenato);
		Map<String, List<Pizza>> dadosLuca = BuildDadosPedido.toMap(Luca, pizzasLuca);
		
		Assert.assertEquals("Portuguesa", dadosRenato.get("Renato").get(1).getNome().toString());
		Assert.assertEquals("Portuguesa", dadosLuca.get("Luca").get(0).getNome().toString());
	}
}
