package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
public class SpringDataLivrariaApplication implements CommandLineRunner {
	
	@Autowired
	private LivroService servicoLivros;
	
	@Autowired
	private EditoraService servicoEditora;
	

	@Override
	public void run(String... arg0)  {
		
		Livro livro = new Livro("Java como Progamar",LocalDate.now(), 250, new BigDecimal("15.00"));
		this.servicoLivros.save(livro);
		
		Livro livro1 = this.servicoLivros.buscarPeloID(8L);
		livro1.setTitulo("XDD");
		this.servicoLivros.save(livro1);
		System.out.println(livro1);
		
		//Lista  de array
		
		List<Livro> livros2 = this.servicoLivros.buscarPelosIDs(new ArrayList<Long>() {{
			add(3L);
			add(5L);
			add(2L);
		}});
		
		for (Livro l : livros2) {
			System.out.println(l);
		}
		
		//Deletando um livro
		this.servicoLivros.remover(this.servicoLivros.buscarPeloID(1L));
		this.servicoLivros.remover(2L);
		
		// Checando se o livro foi excluido
		//System.out.println(this.servicoLivros.BuscarPeloID(1L));
		
		//Buscando pelo findByTitulo
		System.out.println(this.servicoLivros.buscarPeloTitulo("Guerra e Paz"));
		
		//Buscando pelo finByTituloLike sem forEach
		System.out.println(this.servicoLivros.buscarPeloTituloLike("%de%"));
		
		//bucando pelo finbyTituloContaining com forEach
		
		for (Livro l : this.servicoLivros.buscarPeloTituloContendo("o")) {
			System.out.println("Containing=> "+l);
		}
		
		//Buscando pelo findbytitulostartingwith com forEach
		for (Livro l : this.servicoLivros.buscarPeloTituloComecandoCom("um")){
			System.out.println("StartingWith=> "+l);
		}
		
		//Buscando pelo findBytitulotendingwith com forEach
		for (Livro l : this.servicoLivros.buscarPeloTituloTerminandoCom("PAZ")) {
			System.out.println("endingWith=> "+l);
		}
		
		for (Livro l : this.servicoLivros.buscarPeloTituloIgnorandoCaixa("Guerra e Paz")){
			System.out.println("IgnoreCase=> "+l);
		}
		
		// Buscando pelo findByequals
		
		for (Livro l : this.servicoLivros.buscarPeloNumeroPaginasIgual(300)) {
			System.out.println("Equals => "+l);
		}
		
		//Buscando pelo finbygreatherthan
		
		for (Livro l : this.servicoLivros.buscarPeloNumeroPaginasMaiorQue(200)) {
			System.out.println("Greather than=> "+l);
		}
		
		//Buscando pelo findbyBetween
		
		for (Livro l : this.servicoLivros.buscarPeloNumeroPaginasEntre(200, 300)) {
			System.out.println("Between=> "+l);
		}
		
		// finbyTituloCotaining1or2
		
		for (Livro l : this.servicoLivros.buscarPeloTituloContendo1ou2("de", "um")) {
			System.out.println("Contaning1or2=> "+l);
		}
		
		// FInbytituloNot
		for (Livro l : this.servicoLivros.buscarPeloTituloDiferenteQue("Guerra e Paz")) {
			System.out.println("Not=> "+l);
		}
		
		// findByTituloContainingAndNumeroPaginasGreaterThan
		
		for (Livro l : this.servicoLivros.buscarPeloTituloContendoNumeroPaginasMaiorQue("de", 20)) {
			System.out.println("TituloContendonumeropaginasmaiorque=> "+l);
		}
		
		// Date
	
		for (Livro l : this.servicoLivros.buscarPelaDataDepois(LocalDate.of(1995, 01, 01))) {
			System.out.println("DataDepois => "+l);
		}
		
		for (Livro l : this.servicoLivros.buscarPelaDataAntes(LocalDate.of(1972, 12, 31))) {
			System.out.println("DataAntes=> "+l);
		}
		
		for (Livro l : this.servicoLivros.buscarPelaDataEntre(LocalDate.of(1943,01,01), LocalDate.of(1955, 11, 15))) {
			System.out.println("DataEntre=> "+l);
		}
		
		// OrderBy
		
		for (Livro l : this.servicoLivros.buscarPeloTituloContendoCrescente("o")) {
			System.out.println("OrdebYASC=> "+l);
		}
		
		for (Livro l : this.servicoLivros.buscarPeloTituloContendoDecrescente("de")) {
			System.out.println("OrderBYDESC=> "+l);
		}
		
		
		//Editora
		
		Editora editora = new Editora("Saraiva", "Sao Paulo",1937);
		this.servicoEditora.save(editora);
		
		// 1. Alterar a cidade da editora Bookman para Porto Alegre
		Editora editora2 = this.servicoEditora.buscarPeloNome("Bookman");
		editora2.setCidade("Porto Alegre");
		this.servicoEditora.save(editora2);
		System.out.println(editora2);
		
		//2. Remover a editora Moderna
		this.servicoEditora.remover(this.servicoEditora.buscarPeloNome("Moderna"));
		
		// 3. Buscar as editoras com ano de fundação entre 1970 e 2010
		for (Editora e : this.servicoEditora.buscarPeloAnoFundacaoEntre(1970, 2010)){
			System.out.println("Entre1970e2010=> "+e);
		}
		
		// 4. Buscar as editoras com sede no Rio de Janeiro
		System.out.println(this.servicoEditora.buscarPelaCidade("Rio de Janeiro"));
	
		//5. Buscar as editoras cujo nome inicie pelas letras ‘A’ ou ‘B’
		for (Editora e : this.servicoEditora.buscarPorNomeIniciandoComouCom("A", "B")){
			System.out.println("IniciandoComAouB=> "+e);
		}
        //6. Buscar as editoras do Rio de Janeiro, cujo ano de fundação seja posterior a 2000
		for (Editora e : this.servicoEditora.buscarPorCidadeEPorAnoFundacao("Rio de Janeiro", 1998)) {
			System.out.println("CidadeEanoFUndacao=> "+e);
		}
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplication.class, args);
	}

	
}
