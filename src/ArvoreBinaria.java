class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int conteudo) {
        raiz = inserirRecursivo(raiz, conteudo);
    }

    private No inserirRecursivo(No noAtual, int conteudo) {
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

    public void remover(int conteudo) {
        raiz = removerRecursivo(raiz, conteudo);
    }

    private No removerRecursivo(No noAtual, int conteudo) {
        if (noAtual == null) {
            return null;
        }

        if (conteudo < noAtual.conteudo) {
            noAtual.esquerda = removerRecursivo(noAtual.esquerda, conteudo);
        } else if (conteudo > noAtual.conteudo) {
            noAtual.direita = removerRecursivo(noAtual.direita, conteudo);
        } else {
            if (noAtual.esquerda == null && noAtual.direita == null) {
                return null;
            } else if (noAtual.esquerda == null) {
                return noAtual.direita;
            } else if (noAtual.direita == null) {
                return noAtual.esquerda;
            } else {
                No sucessor = encontrarMinimo(noAtual.direita);
                noAtual.conteudo = sucessor.conteudo;
                noAtual.direita = removerRecursivo(noAtual.direita, sucessor.conteudo);
            }
        }

        return noAtual;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }
}