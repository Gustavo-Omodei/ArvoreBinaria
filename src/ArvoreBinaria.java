public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int conteudo) {
        raiz = inserirRecursivo(raiz, conteudo);
    }

    public No inserirRecursivo(No noAtual, int conteudo) {
        if (noAtual == null) {
            return new No(conteudo);
        }

        if (conteudo < noAtual.conteudo) {
            noAtual.esquerda = inserirRecursivo(noAtual.esquerda, conteudo);
        } else if (conteudo > noAtual.conteudo) {
            noAtual.direita = inserirRecursivo(noAtual.direita, conteudo);
        }

        return noAtual;
    }

    public void remover
}
