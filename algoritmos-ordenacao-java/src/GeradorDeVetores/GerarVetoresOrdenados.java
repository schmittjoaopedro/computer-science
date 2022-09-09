package GeradorDeVetores;

public final class GerarVetoresOrdenados {

    private int[] vetorDeRetorno;

    public int[] getVetorGerado(int size) {
        vetorDeRetorno = new int[size];
        for (int i = 0; i < vetorDeRetorno.length; i++) {
            vetorDeRetorno[i] = i;
        }
        return vetorDeRetorno;
    }
}
