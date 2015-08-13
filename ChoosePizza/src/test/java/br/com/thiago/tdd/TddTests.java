package br.com.thiago.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.thiago.enums.NomePizzas;
import br.com.thiago.enums.NotaPizza;
import br.com.thiago.model.Analise;
import br.com.thiago.model.Pessoa;
import br.com.thiago.model.Pizza;
import br.com.thiago.service.BuildAnaliseDeDados;
import br.com.thiago.service.BuildDadosPedido;

/**
 * Acho que ficou meio feio, mas primeira versão :D
 * 
 * @author thiago.goncalves
 *
 */
public class TddTests {
	
	@Test
	public void deveMontarListaNomeDasPizzas() {
		List<Pizza> pizzas = new LinkedList<>();

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
		List<Pizza> notaPizzas = new LinkedList<>();

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
		List<Pizza> pizzasRenato = new LinkedList<>();
		List<Pizza> pizzasLuca = new LinkedList<>();
				
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
		
		Assert.assertEquals(NomePizzas.PORTUGUESA, dadosRenato.get("Renato").get(1).getNome());
		Assert.assertEquals("Portuguesa", dadosLuca.get("Luca").get(0).getNome().toString());
	}
	
	
	@Test
	public void devePegarMaiorNotaComNomeDaPizzaConformeNomePassado(){
		Pizza pizzaComMaiorNota = new BuildAnaliseDeDados("Renato", buildDadosDoPedido()).getPizzaMaiorNota();
				
		Assert.assertEquals(NomePizzas.ESCAROLA, pizzaComMaiorNota.getNome());
		Assert.assertEquals(NotaPizza.CINCO, pizzaComMaiorNota.getNota());
	}

	
	@Test
	public void deveAnalisarDadosConformeNomePassado(){
		Analise analise  = 	new BuildAnaliseDeDados("Renato", buildDadosDoPedido())
								.getAnaliseByName()
								.buildAnalise();
		
		System.out.println(analise.toString());
		Assert.assertEquals("Renato divide pizza de Escarola com Renata", analise.toString());
	}
	
	
	
	//Geradores de dados
	
	private List<Pessoa> buildPessoas(){
		List<Pessoa> pessoas = new LinkedList<>();
		Pessoa Renato = new Pessoa("Renato");
		Pessoa Marcelo = new Pessoa("Marcelo");
		Pessoa Renata = new Pessoa("Renata");
		Pessoa Luca = new Pessoa("Luca");
		
		pessoas.add(Renato);
		pessoas.add(Marcelo);
		pessoas.add(Renata);
		pessoas.add(Luca);

		return pessoas;
	}
	
	/**
	 * Verboso!! Estrutura de dados um pouco maluca
	 * 
	 * @return Retorna List da estrutura para analise
	 */
	private List<Map<String, List<Pizza>>> buildDadosDoPedido(){
		List<Map<String, List<Pizza>>> dadosParaAnalise = new LinkedList<>();
		List<List<Pizza>> listPizzas = new LinkedList<>();
		
		List<Pizza> pizzasRenato = new LinkedList<>();
		List<Pizza> pizzasMarcelo = new LinkedList<>();
		List<Pizza> pizzasRenata = new LinkedList<>();
		List<Pizza> pizzasLuca = new LinkedList<>();
		
		pizzasRenato.add(new Pizza(NomePizzas.PORTUGUESA, NotaPizza.TRES));
		pizzasRenato.add(new Pizza(NomePizzas.MARGUERITA, NotaPizza.UM));
		pizzasRenato.add(new Pizza(NomePizzas.ESCAROLA, NotaPizza.CINCO));
		
		pizzasMarcelo.add(new Pizza(NomePizzas.PORTUGUESA, NotaPizza.UM));
		pizzasMarcelo.add(new Pizza(NomePizzas.MARGUERITA, NotaPizza.CINCO));
		pizzasMarcelo.add(new Pizza(NomePizzas.ESCAROLA, NotaPizza.TRES));
		
		pizzasRenata.add(new Pizza(NomePizzas.PORTUGUESA, NotaPizza.CINCO));
		pizzasRenata.add(new Pizza(NomePizzas.MARGUERITA, NotaPizza.UM));
		pizzasRenata.add(new Pizza(NomePizzas.ESCAROLA, NotaPizza.QUATRO));
		
		pizzasLuca.add(new Pizza(NomePizzas.PORTUGUESA, NotaPizza.QUATRO));
		pizzasLuca.add(new Pizza(NomePizzas.MARGUERITA, NotaPizza.DOIS));
		pizzasLuca.add(new Pizza(NomePizzas.ESCAROLA, NotaPizza.UM));
		
		
		listPizzas.add(pizzasRenato);
		listPizzas.add(pizzasMarcelo);
		listPizzas.add(pizzasRenata);
		listPizzas.add(pizzasLuca);
		
		for(int i=0; i<4; i++){
			dadosParaAnalise.add(
				BuildDadosPedido.toMap(buildPessoas().get(i), listPizzas.get(i))
			);
		}
		
		return dadosParaAnalise;
	}
}
