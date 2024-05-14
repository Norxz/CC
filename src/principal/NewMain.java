package principal;

/**
 *
 * @author espin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Suponiendo que V es el número de vértices
        int V = 5; // Reemplaza con el número real de vértices
        Graph graph = new Graph(V);

        // Añadir aristas al grafo
        graph.addEdge(0, 1);
        //graph.addEdge(1, 2);

        graph.addEdge(2, 3);
        //graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        // Implementación de búsqueda en profundidad (DFS) para encontrar componentes conectados[^3^][3]
        CC cc = new CC(graph);

        // Número de componentes conectados
        int M = cc.count();
        System.out.println(M + " componentes conectados");

        // Imprimir los vértices de cada componente conectado
        Bags<Integer>[] components = (Bags<Integer>[]) new Bags[M];
        for (int i = 0; i < M; i++) {
            components[i] = new Bags<Integer>();
        }
        for (int v = 0; v < graph.V(); v++) {
            components[cc.id(v)].add(v);
        }
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
         
    }
}
