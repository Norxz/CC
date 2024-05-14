
package principal;

/**
 *
 * @author espin
 */
public class CC {
    private boolean[] marked; // Marca los vértices visitados
    private int[] id;         // Identificador del componente conectado
    private int count;        // Número de componentes conectados

    // Constructor que procesa el grafo para encontrar componentes conectados
    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    // Método de búsqueda en profundidad para marcar todos los vértices conectados
    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    // Verifica si dos vértices están conectados
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    // Devuelve el identificador del componente conectado de un vértice
    public int id(int v) {
        return id[v];
    }

    // Devuelve el número de componentes conectados
    public int count() {
        return count;
    }
}
