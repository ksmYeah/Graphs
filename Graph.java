import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String start, String end) {
        if (adjacencyList.containsKey(start) && adjacencyList.containsKey(end)) {
            adjacencyList.get(start).add(end);
        }
    }

    public void dfs(String start) {
        Set<String> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(String vertex, Set<String> visited) {
        if (!visited.contains(vertex)) {
            System.out.print(vertex + " ");
            visited.add(vertex);
            for (String neighbor : adjacencyList.get(vertex)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            System.out.print(vertex + " ");
            for (String neighbor : adjacencyList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        System.out.println("DFS Traversal:");
        graph.dfs("A");
        System.out.println("\nBFS Traversal:");
        graph.bfs("A");
    }
}
