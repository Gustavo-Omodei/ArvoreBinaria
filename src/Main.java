public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        arvore.inserir(10);

        System.out.print("Árvore em ordem: ");
        exibirEmOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\nDetalhes das relações na árvore:");
        exibirDetalhesEmOrdem(arvore.raiz, null, "raiz");

        // ----------------Remoção de exemplos----------------------------
        arvore.remover(14);

        System.out.println("\nÁrvore em ordem após remoções: ");
        exibirEmOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\nDetalhes das relações na árvore após remoções:");
        exibirDetalhesEmOrdem(arvore.raiz, null, "raiz");
    }

    // Método para exibir os elementos da árvore em ordem
    public static void exibirEmOrdem(No no) {
        if (no != null) {
            exibirEmOrdem(no.esquerda);
            System.out.print(no.conteudo + " ");
            exibirEmOrdem(no.direita);
        }
    }

    // Método para exibir os detalhes das relações na árvore em ordem
    public static void exibirDetalhesEmOrdem(No no, No pai, String direcao) {
        if (no != null) {
            exibirDetalhesEmOrdem(no.esquerda, no, "esquerda");
            if (pai != null) {
                System.out.println(no.conteudo + " está à " + direcao + " de " + pai.conteudo);
            } else {
                System.out.println(no.conteudo + " é a " + direcao);
            }
            exibirDetalhesEmOrdem(no.direita, no, "direita");
        }
    }
}