public class Main {
    //
    public static void main(String[] args) {
        int[] sizes = {10, 30, 100};

        for (int size : sizes) {
            System.out.println("Graph Size: " + size);
            Graph g = new Graph();


            for (int i = 0; i < size; i++) {
                g.addVertex(new Vertex(i));
            }

            for (int i = 0; i < size; i++) {
                g.addEdge(i, (i + 1) % size);
                g.addEdge(i, (i * 2) % size);
            }

            System.out.println("Graph Structure:");
            g.printGraph();

            Experiment.runTraversals(g, 0, size == 10);
        }
    }
}
