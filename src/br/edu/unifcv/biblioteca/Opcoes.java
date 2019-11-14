package br.edu.unifcv.biblioteca;

import java.util.List;

public interface Opcoes {
	
	
	void Cadastrar(String nomeLivro, String autor, String descriçao, String dataLançamento);
	
	void Excluir(String nomeLivro);
	
	void Alugar(String nomeLivro);
	
	void Devolver(String nomeLivro);
		
	void ExibirTodos();
	
	List<Livros> ExibirOrdenado();
	
	void ExibirAlugado();
	

}
