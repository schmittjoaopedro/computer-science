package FrameHome.Controller;

public class GeneratorGrafos {

    public static boolean[][] inicarGrafio(int tamanho) {

        int vetorLinha[] = new int[tamanho];

        for (int i = 0; i < vetorLinha.length; i++) {
            vetorLinha[i] = i + 1;
        }
        return conectarGrafos(vetorLinha);
    }

    public static boolean[][] conectarGrafos(int vetorLinha[]) {

        boolean vetor[][] = new boolean[vetorLinha.length][vetorLinha.length];

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[i].length; j++) {
                double flag = Math.random();
                if (flag > 0.7) {
                    vetor[i][j] = true;
                } else {
                    vetor[i][j] = false;
                }
            }
        }

        return vetor;
    }
}
