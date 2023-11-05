public class HashTable {
    private int tamanho;
    private Registro[] table;
    private int colisoes;

    public HashTable(int tamanho) {
        this.tamanho = tamanho;
        this.table = new Registro[tamanho];
        this.colisoes = 0;
    }

    // FUNCOES HASH PARA CALCULO DA POSICAO
    private int calculoHash_1(Integer key) {
        int digitos123 = key / 1000000;
        int digitos456 = (key / 1000) % 1000;
        int digitos789 = key % 1000;
        long hash = digitos123 * 31 + digitos456 * 17 + digitos789 * 13;
        return (int) ((hash & 0x7fffffffL) % tamanho);
    }

    private int calculoHash_2(Integer key) {
        long hash = key;
        long result = ((hash * 17) / 3) % tamanho;
        return (int) result;
    }

    private int calculoHash_3(Integer key) {
        int hash = key;
        return ((hash * 19) & 0x7fffffff) % tamanho;
    }

    // FUNCOES PARA BUSCA DE ACORDO COM CADA FUNCAO HASH

    public void put_1(Integer key, Integer valor) {
        int posicao = calculoHash_1(key);

        Registro novo = new Registro(key, valor);
        if (table[posicao] == null) {
            table[posicao] = novo;

        } else {
            Registro existente = table[posicao];
            while (existente.getNext() != null) {
                existente = existente.getNext();
            }
            existente.setNext(novo);
            colisoes++;
        }
    }

    public void put_2(Integer key, Integer valor) {
        int posicao = calculoHash_2(key);

        Registro novo = new Registro(key, valor);
        if (table[posicao] == null) {
            table[posicao] = novo;

        } else {
            Registro existente = table[posicao];
            while (existente.getNext() != null) {
                existente = existente.getNext();
            }
            existente.setNext(novo);
            colisoes++;
        }
    }

    public void put_3(Integer key, Integer valor) {
        int posicao = calculoHash_3(key);

        Registro novo = new Registro(key, valor);
        if (table[posicao] == null) {
            table[posicao] = novo;

        } else {
            Registro existente = table[posicao];
            while (existente.getNext() != null) {
                existente = existente.getNext();
            }
            existente.setNext(novo);
            colisoes++;
        }
    }

    public void imprimeTabela() {
        /*for (int i = 0; i < tamanho; i++) {
            Registro registro = table[i];
            if (registro != null) {
                System.out.print("Posicao " + i + ":  ");
                while (registro != null) {
                    System.out.print(registro.getValor() + "  ");
                    registro = registro.getNext();
                }
                System.out.println();
            }
        }*/
        System.out.println("Número de colisoes: " + colisoes);
    }

    public void buscaHash1(int key) {
        long inicio = System.nanoTime();
        int posicao = calculoHash_1(key);
        int comparacao = 0;
        Registro existente = table[posicao];
        boolean encontrado = false;

        while (existente != null) {
            comparacao++;
            if (existente.getKey() == key) {
                long termino = System.nanoTime();
                System.out.println("O numero " + key + " foi encontrado em um tempo de " + (termino - inicio)+ " com " +
                        comparacao + " numeros de comparacoes");
                encontrado = true;
                break;
            }
            existente = existente.getNext();
        }
        if (!encontrado) {
            long termino = System.nanoTime();
            System.out.println("O número " + key + " não foi encontrado em um tempo de " + (termino - inicio) + " com " +
                    comparacao + " numeros de comparacoes");
        }
    }

    public void buscaHash2(int key) {
        long inicio = System.nanoTime();
        int posicao = calculoHash_2(key);
        int comparacao = 0;
        Registro existente = table[posicao];
        boolean encontrado = false;

        while (existente != null) {
            comparacao++;
            if (existente.getKey() == key) {
                long termino = System.nanoTime();
                System.out.println("O numero " + key + " foi encontrado em um tempo de " + (termino - inicio)+ " com " +
                      comparacao + " numeros de comparacoes");
                encontrado = true;
                break;
            }
            existente = existente.getNext();
        }
        if (!encontrado) {
            long termino = System.nanoTime();
            System.out.println("O número " + key + " não foi encontrado em um tempo de " + (termino - inicio) + " com " +
                  comparacao + " numeros de comparacoes");
        }
    }

    public void buscaHash3(int key) {
        long inicio = System.nanoTime();
        int posicao = calculoHash_3(key);
        int comparacao = 0;
        Registro existente = table[posicao];
        boolean encontrado = false;

        while (existente != null) {
            comparacao++;
            if (existente.getKey() == key) {
                long termino = System.nanoTime();
                System.out.println("O numero " + key + " foi encontrado em um tempo de " + (termino - inicio)+ " com " +
                        comparacao + " numeros de comparacoes");
                encontrado = true;
                break;
            }
            existente = existente.getNext();
        }
        if (!encontrado) {
            long termino = System.nanoTime();
            System.out.println("O número " + key + " não foi encontrado em um tempo de " + (termino - inicio) + " com " +
                    comparacao + " numeros de comparacoes");
        }
    }
}