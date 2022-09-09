package fechamentotransitivo;

public class FechamentoTransitivo {

    public static void main(String[] args) {
        
        boolean M1[][] = 
        {{false,true,true,false,false,false,false},
         {true,false,false,true,false,false,true},
         {true,false,false,false,false,true,true},
         {false,false,false,false,false,true,false},
         {false,false,false,true,false,true,false},
         {false,false,false,false,false,false,false},
         {false,false,false,true,true,true,false}
        };
        
        System.out.println("\n\nM2: ");
        boolean M2[][] = new FechamentoTransitivo().grauDoGrafo(M1,M1);
        
        new FechamentoTransitivo().imprimirMatriz(M2);
        System.out.println("\n\nM3:");
        
        boolean M3[][] = new FechamentoTransitivo().grauDoGrafo(M2,M1);
        
        new FechamentoTransitivo().imprimirMatriz(M3);
        
    }
    
    
    public void imprimirMatriz(boolean vetorImp[][]){
        for (int i = 0; i < vetorImp.length; i++) {
            for (int j = 0; j < vetorImp.length; j++) {
                System.out.print(vetorImp[i][j] + "   -   ");
            }
            System.out.println("");
        }
    }
    
    
    public boolean[][] grauDoGrafo(boolean matrizUm[][], boolean matrizDois[][]){

        boolean vetor[][] = new boolean[matrizUm.length][matrizUm.length];
        
        for (int i = 0; i < matrizUm.length; i++) {
            for (int j = 0; j < matrizUm.length; j++) {
                for (int k = 0; k < matrizUm.length; k++) {
                    if(matrizUm[i][k] == true && matrizDois[k][j] == true){
                        vetor[i][j] = true;
                        break;
                    }else{
                        vetor[i][j] = false;
                    }
                }
            }
        }
        
        return vetor;
    }
}