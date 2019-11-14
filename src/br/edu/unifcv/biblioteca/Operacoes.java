package br.edu.unifcv.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Operacoes implements Opcoes {

	List<Livros> biblioteca = new ArrayList<>();
	Scanner input = new Scanner(System.in);

	@Override
	public void Cadastrar(String nomeLivro, String autor, String descricao, String dataLancamento) {
		Livros livros = new Livros(nomeLivro, autor, descricao, dataLancamento);

		int cadastro = 0;
		for (int i = 0; i < biblioteca.size(); i++) {
			if (biblioteca.get(i).getNomeLivro().equals(nomeLivro)) {
				System.out.println("\nERROR! \nLivro já cadastrado!");
				cadastro = 1;
			}
		}

		if (cadastro == 0) {
			biblioteca.add(livros);
			System.out.println("\nLivro cadastrado com sucesso!");
		}
	}

	@Override
	public void Excluir(String nomeLivro) {
		int excluir = 0;

		for (int i = 0; i < biblioteca.size(); i++) {
			if (biblioteca.get(i).getNomeLivro().equals(nomeLivro) && !biblioteca.get(i).Alugado) {
				System.out.println("\n" + biblioteca.get(i).toString());
				System.out.print("\nDeseja excluir este livro? \n[1] Sim \n[2] Não \nResposta: ");

				excluir = 1;

				switch (input.nextInt()) {
				case 1:
					biblioteca.remove(i);
					System.out.println("\nLivro removido com sucesso!");
					break;
				}
			} else if (biblioteca.get(i).getNomeLivro().equals(nomeLivro) && biblioteca.get(i).Alugado) {
				System.out.println("ERROR! \nLivro alugado!");
				excluir = 1;
			}
		}

		if (excluir == 0) {
			System.out.println("\nERROR! \nLivro não encontrado!");
		}
	}

	@Override

	public void Alugar(String nomeLivro) {
		int alugar = 0;
		for (Livros livros : biblioteca) {
			if (livros.getNomeLivro().equals(nomeLivro) && !livros.Alugado) {
				System.out.println("\n" + livros.toString());
				System.out.println("\nLivro disponível para locação!");
				System.out.print("\nDeseja alugar este livro? \n[1] Sim \n[2] Não \nResposta: ");

				switch (input.nextInt()) {
				case 1:
					livros.Alugado = true;
					System.out.println("\nLivro " + livros.getNomeLivro() + " alugado com sucesso!");
					break;

				case 2:
					System.out.println("");
					;
				}
				alugar = 1;

			} else if (livros.getNomeLivro().equals(nomeLivro) && livros.Alugado) {
				System.out.println("\nERROR! \nLivro alugado!");
				alugar = 1;
				livros.Alugado = true;
			}
		}

		if (alugar == 0) {
			System.out.println("\nERROR! \nLivro não encontrado!");
		}

	}

	@Override
	public void Devolver(String nomeLivro) {

		int devolver = 0;
		for (Livros livros : biblioteca) {
			if (livros.getNomeLivro().equals(nomeLivro) && livros.Alugado) {
				System.out.println("\n" + livros.toString());
				System.out.print("\nDeseja devolver este livro? \n[1] Sim \n[2] Não \nResposta: ");
				devolver = 1;
				switch (input.nextInt()) {
				case 1:
					livros.Alugado = false;
					System.out.println("\nLivro devolvido com sucesso!");
					break;
				}

			} else if (livros.getNomeLivro().equals(nomeLivro) && !livros.Alugado) {
				System.out.println("\nERROR! \nLivro não alugado!");
				devolver = 1;
			}
		}

		if (devolver == 0) {
			System.out.println("\nERROR! \nLivro não encontrado!");
		}
	}

	@Override
	public void ExibirTodos() {
		for (Livros a : biblioteca) {
			System.out.println(a.toString() + "\n");
		}

	}

	@Override
	public List<Livros> ExibirOrdenado() {
		Collections.sort(biblioteca, (livro1, livro2) -> Character.compare(livro1.getNomeLivro().charAt(0),
				livro2.getNomeLivro().charAt(0)));

		for (Livros livros : biblioteca) {
			System.out.println(livros.toString() + "\n");
		}

		return biblioteca;
	}

	@Override
	public void ExibirAlugado() {
		for (Livros livros : this.biblioteca) {
			if (livros.Alugado) {
				System.out.println(livros + "\n");
			}
		}
	}

}
