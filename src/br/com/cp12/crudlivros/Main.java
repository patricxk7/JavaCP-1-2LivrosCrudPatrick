package br.com.cp12.crudlivros;

import dao.LivrosDAO;
import factory.DAOFactory;
import model.Livros;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LivrosDAO livrosDAO = DAOFactory.getLivrosDAO();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n==============================");
            System.out.println("        CRUD DE LIVROS");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro por ID");
            System.out.println("4 - Atualizar livro");
            System.out.println("5 - Deletar livro");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                if (opcao == 1) {

                    Livros livro = new Livros();

                    System.out.print("Digite o titulo: ");
                    livro.setTitulo(scanner.nextLine());

                    System.out.print("Digite o escritor: ");
                    livro.setEscritor(scanner.nextLine());

                    System.out.print("Digite o ano de lancamento: ");
                    livro.setAnoLancamento(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Digite o genero: ");
                    livro.setGenero(scanner.nextLine());

                    System.out.print("Digite a nota: ");
                    livro.setNotas(scanner.nextDouble());
                    scanner.nextLine();

                    livrosDAO.salvar(livro);

                    System.out.println("\nLivro cadastrado com sucesso!");

                }

                else if (opcao == 2) {

                    List<Livros> livros = livrosDAO.listarTodos();

                    System.out.println("\n========== LIVROS ==========");

                    if (livros.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {

                        for (Livros livro : livros) {
                            System.out.println("------------------------------");
                            System.out.println("ID: " + livro.getId());
                            System.out.println("Titulo: " + livro.getTitulo());
                            System.out.println("Escritor: " + livro.getEscritor());
                            System.out.println("Ano: " + livro.getAnoLancamento());
                            System.out.println("Genero: " + livro.getGenero());
                            System.out.println("Nota: " + livro.getNotas());
                        }

                    }

                }

                else if (opcao == 3) {

                    System.out.print("Digite o ID do livro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Livros livro = livrosDAO.buscarPorId(id);

                    if (livro != null) {

                        System.out.println("\n========== LIVRO ==========");
                        System.out.println("ID: " + livro.getId());
                        System.out.println("Titulo: " + livro.getTitulo());
                        System.out.println("Escritor: " + livro.getEscritor());
                        System.out.println("Ano: " + livro.getAnoLancamento());
                        System.out.println("Genero: " + livro.getGenero());
                        System.out.println("Nota: " + livro.getNotas());

                    } else {

                        System.out.println("Livro nao encontrado.");

                    }

                }

                else if (opcao == 4) {

                    System.out.print("Digite o ID do livro que deseja atualizar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Livros livro = livrosDAO.buscarPorId(id);

                    if (livro != null) {

                        System.out.print("Digite o novo titulo: ");
                        livro.setTitulo(scanner.nextLine());

                        System.out.print("Digite o novo escritor: ");
                        livro.setEscritor(scanner.nextLine());

                        System.out.print("Digite o novo ano de lancamento: ");
                        livro.setAnoLancamento(scanner.nextInt());
                        scanner.nextLine();

                        System.out.print("Digite o novo genero: ");
                        livro.setGenero(scanner.nextLine());

                        System.out.print("Digite a nova nota: ");
                        livro.setNotas(scanner.nextDouble());
                        scanner.nextLine();

                        livrosDAO.atualizar(livro);

                        System.out.println("\nLivro atualizado com sucesso!");

                    } else {

                        System.out.println("Livro nao encontrado.");

                    }

                }

                else if (opcao == 5) {

                    System.out.print("Digite o ID do livro que deseja deletar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Livros livro = livrosDAO.buscarPorId(id);

                    if (livro != null) {

                        livrosDAO.deletar(id);

                        System.out.println("\nLivro deletado com sucesso!");

                    } else {

                        System.out.println("Livro nao encontrado.");

                    }

                }

                else if (opcao == 0) {

                    System.out.println("\nPrograma encerrado.");

                }

                else {

                    System.out.println("\nOpcao invalida.");

                }

            } catch (SQLException e) {

                System.out.println("\nErro ao acessar o banco de dados:");
                e.printStackTrace();

            }
        }

        scanner.close();
    }
}