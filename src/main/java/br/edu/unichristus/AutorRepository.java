package br.edu.unichristus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	
	public List<Autor> findByPrimeiroNome(String primeiroNome);
	
	public List<Autor> findByPais(String pais);
	
	public List<Autor> findByLivrosTitulo (String titulo);

	

}
