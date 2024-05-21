public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(3);
        arvore.inserir(7);
        arvore.inserir(12);
        arvore.inserir(20);

        System.out.println("Árvore em ordem:");
        exibirEmOrdem(arvore.raiz);
    }

    public static void exibirEmOrdem(No no) {
        if (no != null) {
            exibirEmOrdem(no.esquerda);
            System.out.print(no.conteudo + " ");
            exibirEmOrdem(no.direita);
        }
    }
}
