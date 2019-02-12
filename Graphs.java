import java.util.LinkedList;
import java.util.ListIterator;

public class Graphs {
    int V;
    LinkedList<Integer> adjList[];
    Graphs(int v) {
        this.V = v;
        for(int i=0;i<V;i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    void addEdge(int a, int b) {
        adjList[a].add(b);
    }
    void bfs(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(queue.size() != 0) {

            ListIterator<Integer> list = adjList[s].listIterator();
        }
    }
}
