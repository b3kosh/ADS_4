public class Experiment {
    //
    public static void runTraversals(Graph g, int startNode, boolean printOrder) {
        if (printOrder) System.out.print("BFS Order: ");
        long startBfs = System.nanoTime();
        g.bfs(startNode);
        long endBfs = System.nanoTime();

        if (printOrder) System.out.print("DFS Order: ");
        long startDfs = System.nanoTime();
        g.dfs(startNode);
        long endDfs = System.nanoTime();

        System.out.println("BFS Time: " + (endBfs - startBfs) + " ns");
        System.out.println("DFS Time: " + (endDfs - startDfs) + " ns");
        System.out.println("-------------------------");
    }
}