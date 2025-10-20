import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        arvore.inicializar();

        int opcao = -1;

        System.out.println("=== ÁRVORE BINÁRIA - CÓDIGO MORSE ===");

        while (opcao != 0) {
            System.out.println("\n==============================");
            System.out.println("1 - Exibir Árvore");
            System.out.println("2 - Buscar letra (código Morse → letra)");
            System.out.println("3 - Buscar código (letra → código Morse)");
            System.out.println("4 - Inserir novo caractere");
            System.out.println("5 - Remover caractere");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            String entrada = sc.nextLine();
            if (entrada.length() == 0) continue;

            opcao = entrada.charAt(0) - '0'; 

            if (opcao == 1) {
                System.out.println("\n--- Estrutura da Árvore ---");
                arvore.exibir();

            } else if (opcao == 2) {
                System.out.print("Digite o código Morse (ex: ... --- ...): ");
                String codigo = sc.nextLine();

                int i = 0;
                String letra = "";
                String mensagem = "";
                while (i < codigo.length()) {
                    char ch = codigo.charAt(i);
                    if (ch == ' ') {
                        if (letra.length() > 0) {
                            char traduzido = arvore.buscar(letra);
                            mensagem = mensagem + traduzido;
                            letra = "";
                        }
                    } else {
                        letra = letra + ch;
                    }
                    i = i + 1;
                }
                if (letra.length() > 0) {
                    char traduzido = arvore.buscar(letra);
                    mensagem = mensagem + traduzido;
                }

                System.out.println("Resultado: " + mensagem);

            } else if (opcao == 3) {
                System.out.print("Digite a letra que deseja converter: ");
                String letra = sc.nextLine();

                if (letra.length() == 0) {
                    System.out.println("Entrada inválida.");
                    continue;
                }

                char caractere = letra.charAt(0);
                String codigo = arvore.buscarCodigo(Character.toUpperCase(caractere));
                System.out.println("Código Morse: " + codigo);

            } else if (opcao == 4) {
                System.out.print("Digite o caractere que deseja inserir: ");
                String letra = sc.nextLine();

                if (letra.length() == 0) {
                    System.out.println("Entrada inválida.");
                    continue;
                }

                char caractere = letra.charAt(0);

                System.out.print("Digite o código Morse correspondente: ");
                String codigo = sc.nextLine();

                arvore.inserir(codigo, Character.toUpperCase(caractere));
                System.out.println("Caractere inserido com sucesso!");

            } else if (opcao == 5) {
                System.out.print("Digite o código Morse do caractere que deseja remover: ");
                String codigo = sc.nextLine();

                arvore.remover(codigo);
                System.out.println("Remoção concluída (nó limpo).");

            } else if (opcao == 0) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}