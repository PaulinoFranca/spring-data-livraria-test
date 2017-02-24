package br.edu.unichristus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {
	
	@Autowired
	private EditoraRepository repo;
	
	public Editora buscarPeloID(Long editoraID) {
		return this.repo.findOne(editoraID);
	}
	
	public Editora buscarPeloNome(String nome) {
		return this.repo.findByNome(nome);
	}
	
	public List<Editora> buscarPeloAnoFundacaoEntre(int min, int max) {
		return this.repo.findByAnoFundacaoBetween(min, max);
	}
	
	public List<Editora> buscarPelaCidade(String cidade) {
		return this.repo.findByCidade(cidade);
	}
	
	public List<Editora> buscarPorNomeIniciandoComouCom(String nome1, String nome2) {
		return this.repo.findByNomeStartingWithOrNomeStartingWith(nome1, nome2);
	}
	
	public List<Editora> buscarPorCidadeEPorAnoFundacao(String cidade, int anoFundacao) {
		return this.repo.findByCidadeContainingAndAnoFundacaoAfter(cidade, anoFundacao);
	}
	public void remover(Editora editora) {
		this.repo.delete(editora);
	}
	
	public void save(Editora editora) {
		this.repo.save(editora);
	}
	
	
	
}
