package catolica.joaoemiliano;

public class ListaPrioritaria {
    
    public int vetor[];
    public int tamanho;
    
    public ListaPrioritaria(int n) {
        this.vetor = new int[n + 1];
        this.tamanho = 0;
    }
    
    public void inserir(int num, int dist[]) {
        int ind;
        if (tamanho < vetor.length - 1) {
            tamanho++;
            ind=tamanho;
            while (ind>1 && dist[vetor[Pai(ind)]] > dist[num]) {
                vetor[ind] = vetor[Pai(ind)];
                ind= Pai(ind);
            }
            vetor[ind] = num;
        }
    }
    
    public static int Pai(int x) {
        return x / 2;
    }
    
    public void heap_fica(int i, int qtde, int dist[]) {
        
        int f_esq, f_dir, menor, aux;
        menor = i;
        if (2 * i + 1 <= qtde) {
            f_esq = 2 * 1;
            f_dir = 2 * i + 1;
            if (dist[vetor[f_esq]] < dist[vetor[f_dir]] && dist[vetor[f_esq]] < dist[vetor[i]]) {
                menor = 2 * i;
            } else if (dist[vetor[f_dir]] < dist[vetor[f_esq]] && dist[vetor[f_dir]] < dist[vetor[i]]) {
                menor = 2 * i + 1;
            }

        } else if (2 * i <= qtde) {
            f_esq = 2 * i;
            if (dist[vetor[f_esq]] < dist[vetor[i]]) {
                menor = 2 * i;
            }
        }
        if (menor != i) {
            aux = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = aux;
            heap_fica(menor, qtde, dist);
        }
    }
    
    public void constroiheap(int dist[]) {
        for (int i = tamanho/2; i>= 1; i--) {
            heap_fica(i, tamanho, dist);
        }
    }
    
    public int remover(int dist[]){
        if(tamanho==0) {
            System.out.println("Lista Vazia!");
        }
        else{
            int menor_prior=vetor[1];
            vetor[1]=vetor[tamanho];
            tamanho--;
            heap_fica(1, tamanho, dist);
            return menor_prior;
        }
        return 0;
    }
    
}
