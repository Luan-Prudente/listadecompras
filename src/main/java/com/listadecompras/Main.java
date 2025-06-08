package com.listadecompras;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDAO dao = new ListaDAO();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            System.out.println("\n1 - Adicionar item");
            System.out.println("2 - Listar itens");
            System.out.println("3 - Buscar item por ID");
            System.out.println("4 - Atualizar item");
            System.out.println("5 - Remover item");
            System.out.println("6 - Marcar item como comprado");
            System.out.println("7 - Desmarcar item como comprado");
            System.out.println("8 - Limpar lista");
            System.out.println("0 - Sair");

            while (true) {
                System.out.print("Opção (0 a 8): ");
                try {
                    opcao = sc.nextInt();
                    sc.nextLine();
                    if (opcao >= 0 && opcao <= 8) break;
                    System.out.println("Digite um número entre 0 e 8.");
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Digite um número de 0 a 8.");
                    sc.nextLine();
                }
            }

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    int qtd = -1;
                    do {
                        System.out.print("Quantidade: ");
                        if (sc.hasNextInt()) {
                            qtd = sc.nextInt();
                            if (qtd <= 0) {
                                System.out.println("Digite um número maior que zero.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            sc.next();
                        }
                    } while (qtd <= 0);
                    sc.nextLine();

                    dao.adicionarItem(new Item(nome, qtd));
                    break;

                case 2:
                    List<Item> itens = dao.listarItens();
                    System.out.println("\n--- Lista de Compras ---");
                    if (itens.isEmpty()) {
                        System.out.println("A lista está vazia.");
                    } else {
                        for (Item i : itens) {
                            System.out.println("ID: " + i.getId() +
                                    " | Nome: " + i.getNome() +
                                    " | Quantidade: " + i.getQuantidade() +
                                    " | Comprado: " + (i.isComprado() ? "Sim" : "Não"));
                        }
                    }
                    break;

                case 3:
                    int idBuscar = -1;
                    do {
                        System.out.print("ID: ");
                        try {
                            idBuscar = sc.nextInt();
                            if (idBuscar < 0) {
                                System.out.println("ID deve ser positivo.");
                                idBuscar = -1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            sc.next();
                        }
                    } while (idBuscar < 0);
                    sc.nextLine();

                    Item buscado = dao.buscarPorId(idBuscar);
                    if (buscado != null)
                        System.out.println(buscado.getNome() + " x" + buscado.getQuantidade() +
                                " - Comprado: " + (buscado.isComprado() ? "Sim" : "Não"));
                    else
                        System.out.println("Item não encontrado.");
                    break;

                case 4:
                    int idAtualizar = -1;
                    do {
                        System.out.print("ID: ");
                        try {
                            idAtualizar = sc.nextInt();
                            if (idAtualizar < 0) {
                                System.out.println("ID deve ser positivo.");
                                idAtualizar = -1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            sc.next();
                        }
                    } while (idAtualizar < 0);
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    int novaQtd = -1;
                    do {
                        System.out.print("Nova quantidade: ");
                        if (sc.hasNextInt()) {
                            novaQtd = sc.nextInt();
                            if (novaQtd <= 0) {
                                System.out.println("Digite um número maior que zero.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            sc.next();
                        }
                    } while (novaQtd <= 0);
                    sc.nextLine();

                    String resposta;
                    do {
                        System.out.print("Comprado? (s/n): ");
                        resposta = sc.nextLine().trim().toLowerCase();
                    } while (!resposta.equals("s") && !resposta.equals("n"));

                    boolean comprado = resposta.equals("s");
                    dao.atualizarItem(new Item(idAtualizar, novoNome, novaQtd, comprado));
                    break;

                case 5:
                    int idRemover = -1;
                    do {
                        System.out.print("ID para remover: ");
                        try {
                            idRemover = sc.nextInt();
                            if (idRemover < 0) {
                                System.out.println("ID deve ser positivo.");
                                idRemover = -1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            sc.next();
                        }
                    } while (idRemover < 0);
                    sc.nextLine();

                    dao.removerItem(idRemover);
                    break;

                case 6:
                    int idMarcar = -1;
                    do {
                        System.out.print("ID para marcar como comprado: ");
                        try {
                            idMarcar = sc.nextInt();
                            if (idMarcar < 0) {
                                System.out.println("ID deve ser positivo.");
                                idMarcar = -1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            sc.next();
                        }
                    } while (idMarcar < 0);
                    sc.nextLine();

                    dao.marcarComoComprado(idMarcar);
                    break;

                case 7:
                    int idDesmarcar = -1;
                    do {
                        System.out.print("ID para desmarcar como comprado: ");
                        try {
                            idDesmarcar = sc.nextInt();
                            if (idDesmarcar < 0) {
                                System.out.println("ID deve ser positivo.");
                                idDesmarcar = -1;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Digite um número inteiro.");
                            sc.next();
                        }
                    } while (idDesmarcar < 0);
                    sc.nextLine();

                    dao.desmarcarComoComprado(idDesmarcar);
                    break;

                case 8:
                    String confirmar;
                    do {
                        System.out.print("Tem certeza que deseja limpar toda a lista? (s/n): ");
                        confirmar = sc.nextLine().trim().toLowerCase();
                    } while (!confirmar.equals("s") && !confirmar.equals("n"));

                    if (confirmar.equals("s")) {
                        dao.limparLista();
                        System.out.println("Lista apagada com sucesso!");
                    } else {
                        System.out.println("Operação cancelada.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção não reconhecida.");
            }
        }
    }
}
