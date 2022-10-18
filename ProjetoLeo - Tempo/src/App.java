import java.util.Random;

public class App {

	/**
	 * Troca dois elementos de posição em um vetor.
	 * 
	 * @param dados O vetor com os dados.
	 * @pos1 Primeira posição para trocar.
	 * @pos2 Posição a ser trocada com a primeira.
	 */
	static void trocar(int[] dados, int pos1, int pos2) {
		int aux = dados[pos1];
		dados[pos1] = dados[pos2];
		dados[pos2] = aux;
	}

	/**
	 * Gerador de vetores aleatórios: recebe como parâmetros o tamanho do vetor e se
	 * ele deve ser gerado em ordem crescente ou não.
	 * 
	 * @param tamanho  Tamanho do vetor a gerar (número positivo).
	 * @param ordenado TRUE para receber um vetor ordenado; FALSE caso contrário.
	 * @return Um vetor de inteiros nas condições especificadas pelos parâmetros.
	 */
	static public int[] geraVetor(int tamanho, boolean ordenado) {
		Random sorteio = new Random(42);
		int[] dados = new int[tamanho];
		for (int i = 0; i < dados.length; i++) {
			dados[i] = i + 1;
		}
		if (!ordenado) {
			for (int i = 0; i < dados.length * 3; i++) {
				int pos1 = sorteio.nextInt(dados.length);
				int pos2 = sorteio.nextInt(dados.length);
				trocar(dados, pos1, pos2);
			}
		}
		return dados;
	}

	/**
	 * Ordenação por bolha. Pára a ordenação se percebe o vetor já ordenado.
	 * 
	 * @param dados O vetor a ser ordenado.
	 */
	static public void bolha(int[] dados) {
		for (int i = dados.length - 1; i > 0; i--) {
			int trocas = 0;
			for (int j = 0; j < i; j++) {
				if (dados[j] > dados[j + 1]) {
					trocar(dados, j, j + 1);
					trocas++;
				}
			}
			if (trocas == 0)
				return;
		}
	}

	/**
	 * Particionamento do vetor para a ordenação quicksort. Usa como pivô a última
	 * posição do vetor.
	 * 
	 * @param dados  Vetor a ser particionado.
	 * @param inicio Posição inicial do particionamento.
	 * @param fim    Posição final do particionamento (inclusivo, ou seja: este
	 *               valor é a posição do vetor que será usada como pivô).
	 * @return A posição entre 'inicio' e 'fim' onde ocorreu o particionamento.
	 */
	static public int particao(int[] dados, int inicio, int fim) {
		int posicao = inicio - 1;
		int pivot = dados[fim];
		for (int i = inicio; i < fim; i++) {
			if (dados[i] < pivot) {
				posicao++;
				trocar(dados, posicao, i);
			}
		}
		posicao++;
		trocar(dados, posicao, fim);
		return posicao;
	}

	/**
	 * Método quicksort recursivo para ordenar um vetor de inteiros.
	 * 
	 * @param dados  O vetor com os dados.
	 * @param inicio O limite inicial para a ordenação recursiva.
	 * @param fim    O limite final (inclusivo) para a ordenação recursiva.
	 */
	static public void quicksort(int[] dados, int inicio, int fim) {
		if (inicio >= fim)
			return;
		else {
			int particao = particao(dados, inicio, fim);
			quicksort(dados, inicio, particao - 1);
			quicksort(dados, particao + 1, fim);
		}
	}

	/**
	 * Escreva aqui no método principal sua automação do teste, de acordo com as
	 * especificações do exercício.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		double inicio, termino, total = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(62500, false);
			inicio = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino = System.nanoTime();
			total += termino - inicio;
			System.out.println(i);
		}
		System.out.println((total / 50.0) / 1000000000.0);
		double inicio0, termino0, total0 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(125000, false);
			inicio0 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino0 = System.nanoTime();
			total0 += termino0 - inicio0;
			System.out.println(i);
		}
		System.out.println((total0 / 50.0) / 1000000000.0);
		double inicio1, termino1, total1 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(250000, false);
			inicio1 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino1 = System.nanoTime();
			total1 += termino1 - inicio1;
			System.out.println(i);
		}
		System.out.println((total1 / 50.0) / 1000000000.0);
		double inicio2, termino2, total2 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(375000, false);
			inicio2 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino2 = System.nanoTime();
			total2 += termino2 - inicio2;
			System.out.println(i);
		}
		System.out.println((total2 / 50.0) / 1000000000.0);
		double inicio3, termino3, total3 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(62500, true);
			inicio3 = System.nanoTime();
			bolha(Vetorbolha);
			termino3 = System.nanoTime();
			total3 += termino3 - inicio3;
			System.out.println(i);
		}
		System.out.println((total3 / 50.0) / 1000000000.0);
		double inicio4, termino4, total4 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(125000, true);
			inicio4 = System.nanoTime();
			bolha(Vetorbolha);
			termino4 = System.nanoTime();
			total4 += termino4 - inicio4;
			System.out.println(i);
		}
		System.out.println((total4 / 50.0) / 1000000000.0);
		double inicio5, termino5, total5 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(250000, true);
			inicio5 = System.nanoTime();
			bolha(Vetorbolha);
			termino5 = System.nanoTime();
			total5 += termino5 - inicio5;
			System.out.println(i);
		}
		System.out.println((total5 / 50.0) / 1000000000.0);
		double inicio6, termino6, total6 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(375000, true);
			inicio6 = System.nanoTime();
			bolha(Vetorbolha);
			termino6 = System.nanoTime();
			total6 += termino6 - inicio6;
			System.out.println(i);
		}
		System.out.println((total6 / 50.0) / 1000000000.0);
		double inicio7, termino7, total7 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(62500, false);
			inicio7 = System.nanoTime();
			bolha(Vetorbolha);
			termino7 = System.nanoTime();
			total7 += termino7 - inicio7;
			System.out.println(i);
		}
		System.out.println((total7 / 50.0) / 1000000000.0);
		double inicio8, termino8, total8 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(125000, false);
			inicio8 = System.nanoTime();
			bolha(Vetorbolha);
			termino8 = System.nanoTime();
			total8 += termino8 - inicio8;
			System.out.println(i);
		}
		System.out.println((total8 / 50.0) / 1000000000.0);
		double inicio9, termino9, total9 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(250000, false);
			inicio9 = System.nanoTime();
			bolha(Vetorbolha);
			termino9 = System.nanoTime();
			total9 += termino9 - inicio9;
			System.out.println(i);
		}
		System.out.println((total9 / 50.0) / 1000000000.0);
		double inicio10, termino10, total10 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorbolha[] = geraVetor(375000, false);
			inicio10 = System.nanoTime();
			bolha(Vetorbolha);
			termino10 = System.nanoTime();
			total10 += termino10 - inicio10;
			System.out.println(i);
		}
		System.out.println((total10 / 50.0) / 1000000000.0);
		double inicio11, termino11, total11 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(62500, true);
			inicio11 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino11 = System.nanoTime();
			total11 += termino11 - inicio11;
			System.out.println(i);
		}
		System.out.println((total11 / 50.0) / 1000000000.0);
		double inicio12, termino12, total12 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(125000, true);
			inicio12 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino12 = System.nanoTime();
			total12 += termino12 - inicio12;
			System.out.println(i);
		}
		System.out.println((total12 / 50.0) / 1000000000.0);
		double inicio13, termino13, total13 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(250000, true);
			inicio13 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino13 = System.nanoTime();
			total13 += termino13 - inicio13;
			System.out.println(i);
		}
		System.out.println((total13 / 50.0) / 1000000000.0);
		double inicio14, termino14, total14 = 0;
		for (int i = 0; i < 50; i++) {
			int Vetorquick[] = geraVetor(375000, true);
			inicio14 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino14 = System.nanoTime();
			total14 += termino14 - inicio14;
			System.out.println(i);
		}
		System.out.println((total14 / 50.0) / 1000000000.0);
		double inicio15, termino15, total15 = 0;
		for (int i = 0; i < 10; i++) {
			int Vetorquick[] = geraVetor(375000, false);
			inicio15 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino15 = System.nanoTime();
			total15 += termino15 - inicio15;
			System.out.println(i);
		}
		System.out.println((total15 / 10.0) / 1000000000.0);
		double inicio16, termino16, total16 = 0;
		for (int i = 0; i < 10; i++) {
			int Vetorquick[] = geraVetor(375000, true);
			inicio16 = System.nanoTime();
			quicksort(Vetorquick, 0, Vetorquick.length - 1);
			termino16 = System.nanoTime();
			total16 += termino16 - inicio16;
			System.out.println(i);
		}
		System.out.println((total16 / 10.0) / 1000000000.0);

	}
}