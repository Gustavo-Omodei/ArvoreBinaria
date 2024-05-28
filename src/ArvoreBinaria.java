class ArvoreBinaria {
    No raiz; 

    // Construtor da classe ArvoreBinaria
    public ArvoreBinaria() {
        this.raiz = null; // this esta especificando q é desta classe
    }

    // Método para inserir um novo elemento na árvore
    public void inserir(int conteudo) {
        raiz = inserirRecursivo(raiz, conteudo);
    }

    // Método privado recursivo para inserir um elemento na árvore
    private No inserirRecursivo(No noAtual, int conteudo) {
        // Se o nó atual for nulo, cria um novo nó com o conteúdo fornecido
        if (noAtual == null) {
            return new No(conteudo);
        }

        // Se o conteúdo fornecido for menor que o conteúdo do nó atual, insere à esquerda
        if (conteudo < noAtual.conteudo) {
            noAtual.esquerda = inserirRecursivo(noAtual.esquerda, conteudo);
        }
        // Se o conteúdo fornecido for maior que o conteúdo do nó atual, insere à direita
        else if (conteudo > noAtual.conteudo) {
            noAtual.direita = inserirRecursivo(noAtual.direita, conteudo);
        }

        return noAtual;
    }

    // Método para remover um elemento da árvore
    public void remover(int conteudo) {
        raiz = removerRecursivo(raiz, conteudo);
    }

    // Método privado recursivo para remover um elemento da árvore
    private No removerRecursivo(No noAtual, int conteudo) {
        // Se o nó atual for nulo, retorna nulo
        if (noAtual == null) {
            return null;
        }

        // Se o conteúdo fornecido for menor que o conteúdo do nó atual, remove à esquerda
        if (conteudo < noAtual.conteudo) {
            noAtual.esquerda = removerRecursivo(noAtual.esquerda, conteudo);
        }
        // Se o conteúdo fornecido for maior que o conteúdo do nó atual, remove à direita
        else if (conteudo > noAtual.conteudo) {
            noAtual.direita = removerRecursivo(noAtual.direita, conteudo);
        }
        // Se o conteúdo for igual ao conteúdo do nó atual
        else {
            // Se o nó atual não tiver filhos, retorna nulo
            if (noAtual.esquerda == null && noAtual.direita == null) {
                return null;
            }
            // Se o nó atual tiver apenas um filho à direita, retorna esse filho
            else if (noAtual.esquerda == null) {
                return noAtual.direita;
            }
            // Se o nó atual tiver apenas um filho à esquerda, retorna esse filho
            else if (noAtual.direita == null) {
                return noAtual.esquerda;
            }
            // Se o nó atual tiver dois filhos
            else {
                // Encontra o nó sucessor na subárvore direita
                No sucessor = encontrarMinimo(noAtual.direita);
                // Define o conteúdo do nó atual como o conteúdo do sucessor
                noAtual.conteudo = sucessor.conteudo;
                // Remove o sucessor da subárvore direita
                noAtual.direita = removerRecursivo(noAtual.direita, sucessor.conteudo);
            }
        }

        return noAtual;
    }

    // Método privado para encontrar o nó com o menor conteúdo em uma subárvore
    private No encontrarMinimo(No no) {
        // Percorre a subárvore pela esquerda até encontrar um nó nulo
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        // Retorna o nó encontrado
        return no;
    }
}