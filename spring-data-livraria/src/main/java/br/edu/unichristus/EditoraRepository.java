package br.edu.unichristus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

	public Editora findByNome(String nome);
	
	public List<Editora> findByAnoFundacaoBetween(int min, int max);
	
	public List<Editora> findByCidade(String cidade);
	
	public List<Editora> findByNomeStartingWithOrNomeStartingWith(String nome1, String nome2);
	
	public List<Editora> findByCidadeContainingAndAnoFundacaoAfter(String cidade,int anoFundacao);
 }
