package GeradorDeVetores;

public class GerarVetoresIntercalados {

    public int[] gerarVetorInverso(int size) {
        int[] vet = new int[size];

        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                vet[i] = i;
            } else {
                vet[i] = vet.length - i;
            }
        }
        return vet;
    }
}
