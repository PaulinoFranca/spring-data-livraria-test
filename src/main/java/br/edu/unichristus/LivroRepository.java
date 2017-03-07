package br.edu.unichristus;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	public Livro findByTitulo(String titulo);
	
	public List<Livro> findByTituloLike(String titulo);
	
	public List<Livro> findByTituloContaining(String titulo);
	
	public List<Livro> findByTituloStartingWith(String titulo);
	
	public List<Livro> findByTituloEndingWith(String titulo);
	
	public List<Livro> findByTituloIgnoreCase(String titulo);
	
	public List<Livro> findByNumeroPaginasEquals(int numeroPaginas);
	
	public List<Livro> findByNumeroPaginasGreaterThan(int numeroPaginas);	
	
	public List<Livro> findByNumeroPaginasBetween(int min, int max);
	
	public List<Livro> findByTituloContainingOrTituloContaining(String titulo1, String titulo2);
	
	public List<Livro> findByTituloNot(String titulo);
	
	public List<Livro> findByTituloContainingAndNumeroPaginasGreaterThan(String titulo, int numeroPaginas);
	
	public List<Livro> findByDataPublicacaoAfter(LocalDate dataPublicacao);
	
	public List<Livro> findByDataPublicacaoBefore(LocalDate dataPublicacao);
	
	public List<Livro> findByDataPublicacaoBetween(LocalDate dataPublicacao1, LocalDate dataPublicacao2);
	
	public List<Livro> findByTituloContainingOrderByTituloAsc(String titulo);
	
	public List<Livro> findByTituloContainingOrderByTituloDesc(String titulo);
	
	public List<Livro> findByEditora(Editora editora);
	
	public List<Livro> findByAutoresPrimeiroNome (String primeiroNome);
	//erro
	//public List<Livro> findByEditoraAndAutoresPrimeiroNome (Editora editora,String primeiroNome); 
	
	public List<Livro> findByAutoresPais (String pais);
	
}

