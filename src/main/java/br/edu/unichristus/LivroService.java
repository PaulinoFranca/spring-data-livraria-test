package br.edu.unichristus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	
	// Atributo do livro repository
	@Autowired
	private LivroRepository repo;
	
	
	public Livro buscarPeloID(Long idLivro) {
		return this.repo.findOne(idLivro);
	}
	
	public List<Livro> buscarPelosIDs(ArrayList<Long> idsLivro) {
		return this.repo.findAll(idsLivro);
	}
	
	// Titulo.
	
	public Livro buscarPeloTitulo (String titulo) {
		return this.repo.findByTitulo(titulo);
	}
	
	public List<Livro> buscarPeloTituloLike(String titulo) {
		//System.out.println("BUSCANDO OS LIVROS COM O TÍTULO LIKE " + titulo);
		return this.repo.findByTituloLike(titulo);
	}
	
	public List<Livro> buscarPeloTituloContendo(String titulo) {
		return this.repo.findByTituloContaining(titulo);
	}
	
	public List<Livro> buscarPeloTituloComecandoCom(String titulo) {
		return this.repo.findByTituloStartingWith(titulo);
	}
	
	public List<Livro> buscarPeloTituloTerminandoCom(String titulo) {
		return this.repo.findByTituloEndingWith(titulo);
	}
	
	public List<Livro> buscarPeloTituloIgnorandoCaixa(String titulo) {
		return this.repo.findByTituloIgnoreCase(titulo);
	}
	
	// Operadores relacionais
	
	public List<Livro> buscarPeloNumeroPaginasIgual(int numeroPaginas) {
		return this.repo.findByNumeroPaginasEquals(numeroPaginas);
	}
	
	public List<Livro> buscarPeloNumeroPaginasMaiorQue(int numeroPaginas) {
		return this.repo.findByNumeroPaginasGreaterThan(numeroPaginas);
	}
	
	public List<Livro> buscarPeloNumeroPaginasEntre(int min, int max) {
		return this.repo.findByNumeroPaginasBetween(min, max);
	}
	
	// Operadores lógicos
	
	public List<Livro> buscarPeloTituloContendo1ou2(String titulo1, String titulo2) {
		return this.repo.findByTituloContainingOrTituloContaining(titulo1, titulo2);
	}
	
	public List<Livro> buscarPeloTituloDiferenteQue(String titulo) {
		return this.repo.findByTituloNot(titulo);
	}
	
	public List<Livro> buscarPeloTituloContendoNumeroPaginasMaiorQue(String titulo,int numeroPaginas) {
		return this.repo.findByTituloContainingAndNumeroPaginasGreaterThan(titulo, numeroPaginas);
	}
	
	// Date
	
	public List<Livro> buscarPelaDataDepois(LocalDate dataPublicacao) {
		return this.repo.findByDataPublicacaoAfter(dataPublicacao);
	}
	
	public List<Livro> buscarPelaDataAntes(LocalDate dataPublicacao) {
		return this.repo.findByDataPublicacaoBefore(dataPublicacao);
	}
	
	public List<Livro> buscarPelaDataEntre(LocalDate dataPublicacao1, LocalDate dataPublicacao2) {
		return this.repo.findByDataPublicacaoBetween(dataPublicacao1, dataPublicacao2);
	}
	
	// OrderBY
	
	public List<Livro> buscarPeloTituloContendoCrescente(String titulo) {
		return this.repo.findByTituloContainingOrderByTituloAsc(titulo);
	}
	
	public List<Livro> buscarPeloTituloContendoDecrescente(String titulo) {
		return this.repo.findByTituloContainingOrderByTituloDesc(titulo);
	}
	
	// JOIN
	
	public List<Livro> buscarLivrosPelaEditora(Editora editora) {
		System.out.println("BUSCANDO POR LIVROS DA EDITORA: "+editora.getNome());
		return this.repo.findByEditora(editora);
	}
	
	public List<Livro> buscarLivroPorAutor(String primeiroNome) {
		System.out.println("BUSCANDO POR LIVROS DO AUTOR : "+primeiroNome);
		return this.repo.findByAutoresPrimeiroNome(primeiroNome);
	}
	
	//public List<Livro> buscarLivroPorAutorEEditora(Editora editora, String primeiroNome) {
		//System.out.println("BUSCANDO LIVRO DO AUTOR "+primeiroNome+" E DA EDITORA : "+editora.getNome());
	//return this.buscarLivroPorAutorEEditora(editora,primeiroNome);
	//}
	
	public List<Livro> buscarPeloLivroCujoAutorPais(String pais) {
		System.out.println("BUSCANDO LIVROS DE AUTORES QUE SAO DO PAIS: "+pais);
		return this.repo.findByAutoresPais(pais);
	}
	
	//Problema pode está aqui.
	public void save(Livro livro){
		this.repo.save(livro);
	}
	
	public void remover(Livro livro) {
		this.repo.delete(livro);
	}

	public void remover(Long livro) {
		this.repo.delete(livro);
	}
}
