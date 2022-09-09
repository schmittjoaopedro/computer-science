package GeradorDeVetores;

import java.util.Random;

public class GerarVetoresAleatorios {

    private Random geradorDeNumeroAleatorios;
    private int tamanhoDoArrayASerGerado;

    public GerarVetoresAleatorios(int tamanhoDoArrayASerGerado) {
        this.tamanhoDoArrayASerGerado = tamanhoDoArrayASerGerado;
        geradorDeNumeroAleatorios = new Random();
    }

    public synchronized int[] getArrayDesordenadoComValoresDefinidos() {

        int[] arrayFlagReceptorDeValoresAleatorios = new int[tamanhoDoArrayASerGerado];

        for (int flag = 0; flag < arrayFlagReceptorDeValoresAleatorios.length; flag++) {
            arrayFlagReceptorDeValoresAleatorios[flag] = geradorDeNumeroAleatorios.nextInt(100);
        }

        return arrayFlagReceptorDeValoresAleatorios;
    }
}
