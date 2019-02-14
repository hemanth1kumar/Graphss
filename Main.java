public class Main {
    public static void main(String[] args) {
        int V = 5;
        GraphClass graph = new GraphClass(V);
        graph.addEdge(0,1);
        graph.bfs(0);
    }
}
