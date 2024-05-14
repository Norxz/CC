Java

    public class CC {
Esta línea declara la clase CC.

Java

    private boolean[] marked; // Marca los vértices visitados
    private int[] id;         // Identificador del componente conectado
    private int count;        // Número de componentes conectados
Estas son las variables de instancia de la clase CC. marked es un array de booleanos que indica si un vértice ha sido visitado o no. id es un array de enteros que almacena el identificador del componente conectado para cada vértice. count es un entero que almacena el número de componentes conectados.

Java

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
Este es el constructor de la clase CC. Inicializa los arrays marked e id con el número de vértices en el grafo G.

Java

        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }
Este bucle itera sobre todos los vértices en el grafo G. Si un vértice no ha sido marcado como visitado, realiza una búsqueda en profundidad desde ese vértice y luego incrementa el contador de componentes conectados.

Java

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
Este es el método de búsqueda en profundidad. Marca el vértice v como visitado y asigna el contador actual de componentes conectados al vértice v.

Java

        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
Este bucle itera sobre todos los vértices adyacentes al vértice v. Si un vértice adyacente no ha sido marcado como visitado, realiza una búsqueda en profundidad desde ese vértice.

Java

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }
Este método verifica si dos vértices v y w están en el mismo componente conectado.

Java

    public int id(int v) {
        return id[v];
    }

Este método devuelve el identificador del componente conectado del vértice v.

Java

    public int count() {
        return count;
    }
}

Este método devuelve el número de componentes conectados en el grafo.
