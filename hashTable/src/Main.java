import java.util.Random;

public class Main {
    public static void main(String[] args) {
        preencherTabelas();
    }

    public static void preencherTabelas() {
        int tamanhoVetor;
        int[] tamanhos = {28571, 142857, 714286, 1428571, 7142857};
        int[] tamanhoDados = {20000, 100000, 500000, 1000000, 5000000};

        for (tamanhoVetor = 0; tamanhoVetor < tamanhos.length; tamanhoVetor++) {
            for (int i = 0; i < tamanhoDados.length; i++) {

                System.out.println("\n=/=/=/=/=/=/=/=/=/=/=/=/=/=/");
                System.out.println("\t\t TABELA " + (i + 1));
                System.out.println("=/=/=/=/=/=/=/=/=/=/=/=/=/=/");

                System.out.println("Preenchendo " + tamanhoDados[i] + " elementos em uma tabela hash " +
                        "com " + tamanhos[tamanhoVetor] + " posicoes");
                HashTable tabela1 = new HashTable(tamanhos[tamanhoVetor]);
                preencher_1(tabela1, tamanhoDados[i], 4913);
                tabela1.imprimeTabela();
                tabela1.buscaHash1(347818085);
                tabela1.buscaHash1(522533032);
                tabela1.buscaHash1(97794697);
                tabela1.buscaHash1(633426214);
                tabela1.buscaHash1(702625509);
                System.out.println(" ");

                tabela1 = new HashTable(tamanhos[tamanhoVetor]);
                preencher_2(tabela1, tamanhoDados[i], 4913);
                tabela1.buscaHash2(314545425);
                tabela1.buscaHash2(448257877);
                tabela1.buscaHash2(248000166);
                tabela1.buscaHash2(704428047);
                tabela1.buscaHash2(531191770);
                System.out.println(" ");

                tabela1 = new HashTable(tamanhos[tamanhoVetor]);
                preencher_3(tabela1, tamanhoDados[i], 4913);
                tabela1.buscaHash3(148146266);
                tabela1.buscaHash3(963059614);
                tabela1.buscaHash3(876539176);
                tabela1.buscaHash3(616782480);
                tabela1.buscaHash3(980408097);
                System.out.println(" ");
            }
        }
    }

    public static void preencher_1(HashTable tabela, int quantidade, long seed) {
        Random gerador = new Random(seed);

        long inicio = System.nanoTime();
        for (int i = 0; i < quantidade; i++) {
            Integer novoRegistro = gerador.nextInt(1000000000);
            tabela.put_1(novoRegistro, novoRegistro);
        }
        long termino = System.nanoTime();
        System.out.println("Tempo preenchimento da Tabela com primeira funcao Hash: " + (termino - inicio));
        tabela.imprimeTabela();
    }

    public static void preencher_2(HashTable tabela, int quantidade, long seed) {
        Random gerador = new Random(seed);

        long inicio = System.nanoTime();
        for (int i = 0; i < quantidade; i++) {
            Integer novoRegistro = gerador.nextInt(1000000000);
            tabela.put_2(novoRegistro, novoRegistro);
        }
        long termino = System.nanoTime();
        System.out.println("Tempo preenchimento da Tabela com segunda funcao Hash: " + (termino - inicio));
        tabela.imprimeTabela();
    }

    public static void preencher_3(HashTable tabela, int quantidade, long seed) {
        Random gerador = new Random(seed);

        long inicio = System.nanoTime();
        for (int i = 0; i < quantidade; i++) {
            Integer novoRegistro = gerador.nextInt(1000000000);
            tabela.put_3(novoRegistro, novoRegistro);
        }
        long termino = System.nanoTime();
        System.out.println("Tempo preenchimento da Tabela com terceira funcao Hash: " + (termino - inicio));
        tabela.imprimeTabela();
    }

}