package br.edu.unifcv.biblioteca;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Operacoes biblioteca = new Operacoes();

		boolean continuar = true;
		do {

			System.out.println("\n------------- [MENU] -------------\n");
			System.out.println("[1] Cadastrar Livro");
			System.out.println("[2] Excluir Livro");
			System.out.println("[3] Alugar Livro");
			System.out.println("[4] Devolver Livro");
			System.out.println("[5] Exibir Livro");
			System.out.println("[6] Sair");
			System.out.print("\nResposta: ");

			String nomeLivro, autor, descricao, dataLancamento;
			Scanner input = new Scanner(System.in);

			switch (input.nextInt()) {
			case 1:

				int opcaoCadastrarNovamente = 1;
				while (opcaoCadastrarNovamente == 1) {

					System.out.println("\n------------- [CADASTRAR] -------------\n");
					System.out.print("Nome do Livro: ");
					nomeLivro = input.next();
					System.out.print("Descrição: ");
					descricao = input.next();
					System.out.print("Autor: ");
					autor = input.next();
					System.out.print("Data de Lançamento: ");
					dataLancamento = input.next();
					biblioteca.Cadastrar(nomeLivro, autor, descricao, dataLancamento);

					System.out.print("\nDeseja cadastrar outro livro? \n[1] Sim \n[2] Não \nResposta: ");
					opcaoCadastrarNovamente = input.nextInt();
					if (opcaoCadastrarNovamente == 1) {
						opcaoCadastrarNovamente = 1;
					} else if (opcaoCadastrarNovamente != 1 && opcaoCadastrarNovamente != 2) {
						System.out.println("Opção invalida!");
						opcaoCadastrarNovamente = 2;
					} else {
						opcaoCadastrarNovamente = 2;
					}

				}
				break;

			case 2:
				System.out.println("\n------------- [EXCLUIR] -------------\n");
				System.out.print("Digite o Nome do Livro: ");
				nomeLivro = input.next();
				biblioteca.Excluir(nomeLivro);
				break;
			case 3:
				System.out.println("\n------------- [ALUGAR] -------------\n");
				System.out.print("Digite o Nome do Livro: ");
				nomeLivro = input.next();
				biblioteca.Alugar(nomeLivro);
				break;

			case 4:
				System.out.println("\n------------- [DEVOLVER] -------------\n");
				System.out.print("Digite o Nome do Livro: ");
				nomeLivro = input.next();
				biblioteca.Devolver(nomeLivro);
				break;
			case 5:

				int opcaoExibir;
				System.out.println("\n------------- [EXIBIR] -------------\n");
				System.out.println("[1] Exibir Alugados");
				System.out.println("[2] Exibir Todos");
				System.out.println("[3] Exibir Ordenado");
				System.out.print("\nResposta: ");
				opcaoExibir = input.nextInt();

				switch (opcaoExibir) {

				case 1:
					System.out.println("\n------------- [EXIBIR ALUGADOS] -------------\n");
					biblioteca.ExibirAlugado();
					break;

				case 2:
					System.out.println("\n------------- [EXIBIR TODOS] -------------\n");
					biblioteca.ExibirTodos();
					break;

				case 3:
					System.out.println("\n------------- [EXIBIR ORDENADO] -------------\n");
					biblioteca.ExibirOrdenado();
					break;

				}
				break;

			case 6:
				System.out.println("Você saiu do sistema!");
				System.exit(0);
				break;

			default:

				System.out.println("Opção Invalida!");

				break;
			}

		} while (continuar == true);

	}

}
