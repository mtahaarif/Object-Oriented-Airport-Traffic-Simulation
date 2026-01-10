package Project;
public class ShortestPath implements Path {

    private static final int V = 6; // No of vertices

    private static int selectMinVertex(int[] value, boolean[] processed) {
        int minimum = Integer.MAX_VALUE;
        int vertex = -1;

        for (int i = 0; i < V; ++i) {
            if (!processed[i] && value[i] < minimum) {
                vertex = i;
                minimum = value[i];
            }
        }

        return vertex;
    }

    static int dijkstra(int startNode,int endNode) {

        int[][] graph = airportNetwork;
        int[] parent = new int[V]; // Stores Shortest Path Structure
        int[] value = new int[V]; // Keeps shortest path values to each vertex from source
        boolean[] processed = new boolean[V]; // TRUE->Vertex is processed

        // Initialize values for all nodes
        for (int i = 0; i < V; ++i) {
            parent[i] = -1; // No parent initially
            value[i] = Integer.MAX_VALUE; // Initialize distances to infinity
            processed[i] = false; // No node is processed initially
        }

        // Set values for the start node
        parent[startNode] = -1; // Start node has no parent
        value[startNode] = 0; // Start node has value=0 to get picked 1st

        // Include (V-1) edges to cover all V-vertices
        for (int i = 0; i < V - 1; ++i) {
            // Select best Vertex by applying greedy method
            int u = selectMinVertex(value, processed);
            processed[u] = true; // Include new Vertex in shortest Path Graph

            // Relax adjacent vertices (not yet included in shortest path graph)
            for (int j = 0; j < V; ++j) {
                // 3 conditions to relax:-
                // 1. Edge is present from U to j.
                // 2. Vertex j is not included in shortest path graph
                // 3. Edge weight is smaller than current edge weight
                if (graph[u][j] != 0 && !processed[j] && value[u] != Integer.MAX_VALUE
                        && (value[u] + graph[u][j] < value[j])) {
                    value[j] = value[u] + graph[u][j];
                    parent[j] = u;
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (i == endNode) {
                System.out.println("*Shortest Distance from Node" + startNode + " to Node" + endNode + " is: " + value[i]);
                return value[endNode];
            }
        }
        return -1;
    }
}



/* For Printing Shortest Path Graph
   for (int i = 0; i < V; ++i) {
       if (i != startNode) {
           System.out.println("Shortest Distance from Node " + startNode + " to Node " + i + ": " + value[i]);
       }
   } */

