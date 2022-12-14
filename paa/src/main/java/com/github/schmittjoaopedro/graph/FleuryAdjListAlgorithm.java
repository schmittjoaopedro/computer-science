package com.github.schmittjoaopedro.graph;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.*;

/**
 * http://people.ku.edu/~jlmartin/courses/math105-F11/Lectures/chapter5-part2.pdf
 * https://www.geeksforgeeks.org/fleurys-algorithm-for-printing-eulerian-path/
 */
public class FleuryAdjListAlgorithm {


    private static String problems[] = {
//            "graphs/euler-cycle-5_1.graph",
//            "graphs/euler-cycle-16_1.graph",
//            "graphs/euler-cycle-6_1.graph",
//            "graphs/euler-path-5_1.graph",
//            "graphs/euler-path-6_1.graph"
            "graphs/euler-cycle-teste1.graph"
    };

    public static void main(String[] args) throws Exception {
        for (String problem : problems) {
            String graphLines[] = FileUtils.readFileToString(new File(problem), "UTF-8").split("\n");
            processGraph(graphLines, problem);
        }
    }

    public static void processGraph(String[] graphLines, String problem) {
        int V = Integer.valueOf(graphLines[0].replaceAll("\\|V\\|=", ""));
        Graph graph = new Graph();
        for (int l = 1; l < graphLines.length; l++) {
            int i = Integer.valueOf(graphLines[l].replaceAll("\\(", "").replaceAll(",.*?\\)", ""));
            int j = Integer.valueOf(graphLines[l].replaceAll("\\)", "").replaceAll("\\(.*?,", ""));
            graph.addEdge(i, j);
        }

        try {
            System.out.println(problem);
            printRoute(getEulerPath(graph));
        } catch (Exception e) {
            System.out.println(problem + " not have 0 or 2 odd vertices = not Euler path neither Euler cycle.");
        }
    }

    public static void printRoute(List<Node> path) {
        StringBuilder route = new StringBuilder();
        for (Node vertex : path) {
            route.append(vertex.value).append("-");
        }
        route.deleteCharAt(route.length() - 1);
        System.out.println(route);
    }

    public static int getOddVerticesCount(Graph graph) {
        int oddCount = 0; // O(1)
        for (Node node : graph.getNodes()) { // O(|V|)
            if (node.degree() % 2 == 1) { // O(1)
                oddCount++; // O(1)
            }
        }
        return oddCount; // O(1)
    }

    public static Node getEulerPathOrigin(Graph graph) {
        for (Node node : graph.getNodes()) { // O(|V|)
            if (node.degree() % 2 == 1) { // O(1)
                return node; // O(1)
            }
        }
        throw new RuntimeException("Error on finding Euler path origin");
    }

    /**
     * No melhor caso temos O(|E|^2).
     * No pior caso temos O(|V|) + O(|E|^2) = O(|E|^2).
     * <p>
     * Assim a complexidade de tempo de pior caso ?? de O(|E|^2).
     * <p>
     * A complexidade de espa??o do pior caso pertence ao getEulerPath O(|E|^2),
     * porque a fun????o que busca origem ?? de O(1).
     */
    public static List<Node> getEulerPath(Graph graph) throws Exception {
        List<Node> path = new ArrayList<Node>(); // O(1)
        int oddCount = getOddVerticesCount(graph); // O(|V|)
        if (oddCount == 0) { // O(1)
            path.add(graph.getNodes().get(0)); // O(1)
            getEulerPath(graph, path, path.get(0));  // O(|E|^2)
        } else if (oddCount == 2) {
            path.add(getEulerPathOrigin(graph)); // O(|V|)
            getEulerPath(graph, path, path.get(0));  // O(|E|^2)
        } else {
            throw new Exception("Euler properties infringed.");
        }
        return path; // O(1)
    }

    /**
     * A fun????o getEulerPath recebe um n?? origem e executa uma verifica????o de isBridge para cada
     * n?? adjacente do n?? origem.
     * <p>
     * Como para cada n?? existem |degree(V_{from})| arestas, e a contagem de cada aresta ?? feita duas
     * vezes, (i,j) e (j,i). No pior caso iremos percorrer todas as arestas duas vezes 2|E| = O(|E|)
     * invocando a fun????o is bridge, que tem custo O(|E|), em cada itera????o.
     * <p>
     * No melhor caso, em que para cada v??rtice a primeira aresta da lista de adjac??ncias sempre satisfaz
     * a condi????o de n??o ponte e o circuito ?? fechado ao atingir o ??ltimo v??rtice, teremos |V| * O(|E|)
     * <p>
     * No pior caso, em que todas as arestas da lista de adjac??ncia dos v??rtices s??o percorridas,
     * temos complexidade de O(|V| + |E|) * O(|E|) = O(|E|^2).
     * <p>
     * Pela an??lise de pior caso a complexidade ?? de tempo ?? de O(|E|^2).
     * <p>
     * A an??lise da complexidade de espa??o dessa fun????o, por ser um processo recursivo e invocar uma DFS,
     * no pior caso tem complexidade O(|V|) + O(|V|) = O(|V|). Esse caso, 2*O(|V|) pode ocorrer porque todos
     * os v??rtices menos um podem estar no caminho corrente por??m para fechar o ciclo ainda s??o necess??rios
     * voltar por todos os v??rtices usando arestas diferentes.
     */
    public static void getEulerPath(Graph graph, List<Node> path, Node from) {
        Node[] nodes = from.adjacency.values().toArray(new Node[]{}); // O(1)
        for (Node to : nodes) { // O(degree(V_{from})
            if (!isBridge(graph, from, to)) { // O(|E|)
                path.add(to); // O(1)
                graph.delEdge(from, to); // O(1)
                getEulerPath(graph, path, to); // O(1)
                break; // O(1)
            }
        }
    }

    /**
     * A fun????o isBridge executa uma verifica????o para determinar se a visita da aresta
     * (from, to) n??o ir?? deixar o grafo disjunto. Essa verifica????o ?? necess??ria para
     * garantir as propriedades do caminho e ciclo euleriano.
     * <p>
     * Inicialmente ?? executado a DFS para determinar a quantidade de n??s que podem ser
     * alcan??ados a partir do n?? from n??o considerando a remo????o da aresta (from, to).
     * Ent??o ?? removido a aresta (from, to) e executado o DFS para recalcular a quantidade
     * de n??s que podem ser atingidos sem essa aresta.
     * Se a remo????o da aresta reduz a cobertura dos v??rtices ent??o essa aresta ?? ponte, o
     * que significa que ela ir?? separar o grafo e tornar uma das partes inacess??vel.
     * <p>
     * Como essa rotina basicamente executa duas DFS, o custo no pior caso a complexidade
     * de tempo ?? de O(|E|) + O(|E|) = O(|E|).
     * <p>
     * Como esse m??todo n??o ?? recursivo por??m invoca uma DFS que tem custo de O(|V|), a
     * complexidade de espa??o desse m??todo ?? de O(|V|).
     */
    public static boolean isBridge(Graph graph, Node from, Node to) {
        if (from.adjacency.size() == 1) { // O(1)
            return false; // O(1)
        }
        int bridgeCount = DFS(new HashSet<Node>(), to); // O(|E|)

        graph.delEdge(from, to); // O(1)
        int nonBridgeCount = DFS(new HashSet<Node>(), to); // O(|E|)

        graph.addEdge(from.value, to.value); // O(1)
        return nonBridgeCount < bridgeCount; // O(1)
    }

    /**
     * A busca em profundidade DFS (Depth-First Search) geralmente ?? aplicada para
     * encontrar todos os v??rtices de um grafo.
     * <p>
     * Para cada v??rtice um processo recursivo ?? iniciado onde visita-se, de forma sequencial,
     * os filhos adjacentes do v??rtice corrente que ainda n??o foram visitados.
     * <p>
     * Nesse caso, a execu????o do DFS ?? aplicado somente na estrutura do n?? "from" para
     * encontrar todos os v??rtices que podem ser encontrados a partir dele. Como estamos
     * considerando um grafo simples, para cada v??rtice ser?? executado |degree(V)|
     * compara????es.
     * <p>
     * sum_{v \in V} |degree(v)| = 2|E| = O(|E|)
     * <p>
     * A somat??ria resulta em 2|E| porque para um dado v??rtice i e um v??rtice j, o grau de
     * i considera j na contagem e o grau de j considera i na sua contagem, dessa forma
     * essa aresta ?? encontrada duas vezes.
     * <p>
     * Nota: esse custo de O(|E|) s?? ?? garantido pelo uso de um HashSet que garante o tempo de
     * consulta de inser????o de n??s visitado com complexidade de O(1).
     * <p>
     * Dessa forma a complexidade de tempo ?? de O(|E|)
     * <p>
     * Como o processo recursivo ?? aberto para cada v??rtice, temos que a complexidade de espa??o
     * ?? O(|V|).
     */
    public static int DFS(Set<Node> visited, Node from) {
        int count = 1; // O(1)
        visited.add(from); // O(1)
        Node[] nodes = from.adjacency.values().toArray(new Node[]{}); // O(1)
        for (Node to : nodes) { // O(degree(from))
            if (!visited.contains(to)) { // O(1)
                count = count + DFS(visited, to); // O(1)
            }
        }
        return count; // O(1)
    }

}
