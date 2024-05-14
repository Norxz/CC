public class Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

Estas son las variables de instancia de la clase Graph. V es el número de vértices en el grafo, E es el número de aristas y adj es una matriz de listas de adyacencia.

Java

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

Este es el constructor de la clase Graph. Inicializa el número de vértices con el valor pasado como argumento, establece el número de aristas en 0 y crea una nueva lista de adyacencia para cada vértice.

Java

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

Estos son los métodos getter para el número de vértices y aristas. Devuelven el número de vértices y aristas respectivamente.

Java

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

Este método añade una arista entre los vértices v y w. Añade w a la lista de adyacencia de v y v a la lista de adyacencia de w. Luego incrementa el número de aristas E en 1.

Java

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

Este método devuelve una lista iterable de los vértices adyacentes al vértice v.

Java

    public String toString() {
        String s = V + " vértices, " + E + " aristas\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}

Este método devuelve una representación en cadena del grafo. Para cada vértice, imprime el vértice y sus vértices adyacentes.




Java
 
    public class GraphProcessing {

Esta línea declara la clase GraphProcessing. Esta clase contiene métodos estáticos para procesar un grafo.

Java

    public static int degree(Graph G, int v) {
    
Este método estático calcula el grado de un vértice v en el grafo G. El grado de un vértice es el número de aristas que conectan con él.

Java

        int degree = 0;
        
Se inicializa una variable degree en 0 para llevar la cuenta del grado del vértice.

Java

        for (int w : G.adj(v)) {
            degree++;
        }
Este bucle itera sobre todos los vértices adyacentes a v (es decir, todos los vértices w tal que hay una arista entre v y w) y por cada vértice adyacente incrementa el contador degree.

Java

        return degree;
    }
Finalmente, el método devuelve el grado del vértice v.

Java

    public static int maxDegree(Graph G) {
Este método estático calcula el grado máximo en el grafo G.

Java

        int max = 0;
Se inicializa una variable max en 0 para llevar la cuenta del grado máximo.

Java

        for (int v = 0; v < G.V(); v++)
            if (degree(G, v) > max)
                 max = degree(G, v);
Este bucle itera sobre todos los vértices en G, calcula el grado de cada vértice y si el grado del vértice actual es mayor que el valor actual de max, entonces actualiza max con el grado del vértice actual.

Java

        return max;
    }
Finalmente, el método devuelve el grado máximo en el grafo G.

Java

    public static double averageDegree(Graph G) {
Este método estático calcula el grado promedio en el grafo G.

Java

        return 2.0 * G.E() / G.V();
    }
El grado promedio es el número total de aristas multiplicado por 2 (ya que cada arista se cuenta dos veces, una vez por cada vértice) dividido por el número de vértices. El método devuelve este valor.

Java

    public static int numberOfSelfLoops(Graph G) {
Este método estático calcula el número de bucles de autovuelta en el grafo G.

Java

        int count = 0;
Se inicializa una variable count en 0 para llevar la cuenta del número de bucles de autovuelta.

Java

        for (int v = 0; v < G.V(); v++)
            for (int w : G.adj(v))
                if (v == w) count++;
Este bucle anidado itera sobre todos los vértices en G y para cada vértice, itera sobre todos sus vértices adyacentes. Si un vértice es adyacente a sí mismo (es decir, v == w), entonces incrementa el contador count.

Java

        return count / 2; // cada arista contada dos veces
    }
Finalmente, el método devuelve el número de bucles de autovuelta en el grafo G. Se divide el contador count por 2 porque cada bucle de autovuelta se cuenta dos veces en el bucle anterior.
