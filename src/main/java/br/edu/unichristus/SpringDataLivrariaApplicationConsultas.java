package br.edu.unichristus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringDataLivrariaApplicationConsultas implements CommandLineRunner {
	
	@Autowired
	private LivroService servicoLivros;
	
	@Autowired
	private EditoraService servicoEditora;
	
	@Autowired 
	private AutorService servicoAutor;
	

	@Override
	public void run(String... arg0)  {
		
		Editora e = new Editora ("Érica","Rio de Janeiro",1937);
		
		Autor a = new Autor("Antonio", "José", "Brasil");
		
		Livro l = new Livro("Java em 30 dias", LocalDate.now(), 250, new BigDecimal("15.00"));
		l.setEditora(e);
		
		a.setLivros(new ArrayList<Livro>() {
			{
			add(l);
		}});
		
		this.servicoEditora.save(e);
		this.servicoLivros.save(l);
		this.servicoAutor.salvar(a);
		
		Livro l2 = new Livro("Java em 90 dias", LocalDate.of(2015, 3, 30), 300, new BigDecimal("50.00"));
		l2.setEditora(this.servicoEditora.buscarPeloNome("Campus"));
		Autor a2 = this.servicoAutor.buscarPeloID(7L);
		a2.getLivros().add(l2);
		
		this.servicoLivros.save(l2);
		this.servicoAutor.salvar(a2);
		
		// Todos os livros de uma editora.
		for (Livro li : this.servicoLivros.buscarLivrosPelaEditora(this.servicoEditora.buscarPeloNome("Campus"))) {
			System.out.println(li);
		}
		// Todos os livros de um autor.
		for (Livro li : this.servicoLivros.buscarLivroPorAutor("antonio") ) {
			System.out.println(li);
		}
		
		// errado
		//for (Livro li : this.servicoLivros.buscarLivroPorAutorEEditora(this.servicoEditora.buscarPeloNome("Saraiva"),"antonio")) {
			//System.out.println(li);
		//}
		
		// Todos os autores de um livro
		for (Autor au : this.servicoAutor.buscarPorAutoresUmLivro("Guerra e Paz")){
			System.out.println(au);
		}
		
		// Livros de autores de um determinado PAIS
		for (Livro li : this.servicoLivros.buscarPeloLivroCujoAutorPais("Brasil")) {
			System.out.println(li);
		}
		
		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataLivrariaApplicationConsultas.class, args);
	}

	
}
