package br.edu.unichristus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repo;
	
	public void salvar(Autor autor) {
		this.repo.save(autor);
		System.out.println("AUTOR "+ autor.getAutorID() + "SALVO");
	}
	
	public List<Autor> buscarTodos() {
		System.out.println("BUSCANDO TODOS OS AUTORES: ");
		return this.repo.findAll();
	}
	
	public Autor buscarPeloID(Long idAutor) {
		System.out.println("BUSCANDO PELO AUTOR COM ID: "+idAutor);
		return this.repo.findOne(idAutor);
	}
	
	public List<Autor> buscarPelosIDs(ArrayList<Long> idsAutores) {
		System.out.println("Buscando pelos autores com ids: "+idsAutores);
		return this.repo.findAll(idsAutores);
	}
	
	public void remover(Long idAutor) {
		this.repo.delete(idAutor);
		System.out.println("Removi o autor com ID: "+idAutor);
	}
	
	public void remover(Autor autor) {
		this.repo.delete(autor);
		System.out.println("Removi o autor com ID "+ autor.getAutorID());
	}

	//
	public List<Autor> buscarPeloNome(String primeiroNome) {
		return this.repo.findByPrimeiroNome(primeiroNome);
	}
	
	public List<Autor> buscarPeloPais(String pais) {
		return this.repo.findByPais(pais);
	}
	
	public List<Autor> buscarPorAutoresUmLivro(String titulo) {
		System.out.println("BUSCANDO AUTORES DO LIVRO: "+titulo);
		return this.repo.findByLivrosTitulo(titulo);
	}
	
	
}
