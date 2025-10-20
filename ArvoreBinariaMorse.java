
public class ArvoreBinariaMorse {
    Node raiz;

    public ArvoreBinariaMorse() {
        raiz = new Node();
    }
    public void inserir(String codigo, char caractere) {
        Node atual = raiz;
        int i = 0;

        while (i < codigo.length()) {
            char simbolo = codigo.charAt(i);

            if (simbolo == '.') {
                if (atual.left == null) {
                    atual.left = new Node();
                }
                atual = atual.left;
            } else if (simbolo == '-') {
                if (atual.right == null) {
                    atual.right = new Node();
                }
                atual = atual.right;
            }

            i = i + 1;
        }

        atual.c = caractere;
    }
    public char buscar(String codigo) {
        Node atual = raiz;
        int i = 0;

        while (i < codigo.length()) {
            char simbolo = codigo.charAt(i);

            if (simbolo == '.') {
                if (atual.left == null) return '?';
                atual = atual.left;
            } else if (simbolo == '-') {
                if (atual.right == null) return '?';
                atual = atual.right;
            }
            i = i + 1;
        }
        return atual.c;
    }
    public String buscarCodigo(char letra) {
        String caminho = buscarCodigoRec(raiz, letra, "");
        if (caminho == "") {
            return "(não encontrado)";
        }
        return caminho;
    }

    private String buscarCodigoRec(Node atual, char letra, String caminho) {
        if (atual == null) {
            return "";
        }

        if (atual.c == letra) {
            return caminho;
        }
        String esquerda = buscarCodigoRec(atual.left, letra, caminho + ".");
        if (esquerda != "") {
            return esquerda;
        }
        String direita = buscarCodigoRec(atual.right, letra, caminho + "-");
        if (direita != "") {
            return direita;
        }

        return "";
    }
    public void remover(String codigo) {
        removerRec(raiz, codigo, 0);
    }

    private void removerRec(Node atual, String codigo, int pos) {
        if (atual == null) return;

        if (pos == codigo.length()) {
            atual.c = ' ';
            return;
        }

        char simbolo = codigo.charAt(pos);

        if (simbolo == '.') {
            removerRec(atual.left, codigo, pos + 1);
        } else if (simbolo == '-') {
            removerRec(atual.right, codigo, pos + 1);
        }
    }
    public void exibir() {
        exibirRec(raiz, "");
    }

    private void exibirRec(Node atual, String prefixo) {
        if (atual != null) {
            System.out.println(prefixo + "(" + atual.c + ")");
            exibirRec(atual.left, prefixo + " .");
            exibirRec(atual.right, prefixo + " -");
        }
    }
    public void inicializar() {
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }
}