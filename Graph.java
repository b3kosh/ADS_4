import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adjList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        this.adjList = new HashMap<>();
        this.vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
        vertices.put(v.getId(), v);
    }

    public void addEdge(int from, int to, int weight) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            Vertex src = vertices.get(from);
            Vertex dest = vertices.get(to);
            Edge edge = new Edge(src, dest, weight);
            adjList.get(from).add(edge);
        }
    }

    public void printGraph() {
        for (Map.Entry<Integer, List<Edge>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            List<String> edgesStr = new ArrayList<>();
            for (Edge edge : entry.getValue()) {
                edgesStr.add(edge.getDestination().getId() + "(w:" + edge.getWeight() + ")");
            }
            System.out.println(edgesStr);
        }
    }

    public void dijkstra(int start) {
        int numVertices = adjList.size();
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < numVertices; i++) {
            int minVertex = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int j = 0; j < numVertices; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    minVertex = j;
                }
            }

            if (minVertex == -1) {
                break;
            }

            visited[minVertex] = true;

            List<Edge> neighbors = adjList.getOrDefault(minVertex, new ArrayList<>());
            for (Edge edge : neighbors) {
                int neighborId = edge.getDestination().getId();

                if (!visited[neighborId]) {
                    int currentWeight = edge.getWeight();
                    if (distances[minVertex] != Integer.MAX_VALUE &&
                            distances[minVertex] + currentWeight < distances[neighborId]) {
                        distances[neighborId] = distances[minVertex] + currentWeight;
                    }
                }
            }
        }

        System.out.println("Dijkstra Shortest Paths from node " + start + ":");
        for (int i = 0; i < numVertices; i++) {
            String distStr = (distances[i] == Integer.MAX_VALUE) ? "Unreachable" : String.valueOf(distances[i]);
            System.out.println("  To node " + i + " -> Distance: " + distStr);
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            List<Edge> neighbors = adjList.getOrDefault(v, new ArrayList<>());
            for (Edge edge : neighbors) {
                int neighborId = edge.getDestination().getId();
                if (!visited.contains(neighborId)) {
                    visited.add(neighborId);
                    queue.add(neighborId);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");

        List<Edge> neighbors = adjList.getOrDefault(v, new ArrayList<>());
        for (Edge edge : neighbors) {
            int neighborId = edge.getDestination().getId();
            if (!visited.contains(neighborId)) {
                dfsRecursive(neighborId, visited);
            }
        }
    }
}