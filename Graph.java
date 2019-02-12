import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Graph {
    private int V;
    private LinkedList<Integer> adjList[];
    public Graph(int v){
        V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int a, int b) {
        adjList[a].add(b);
    }

    void bfs(int s) {
        System.out.print("BFS Traversal:");
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while(queue.size()!=0) {
            s = queue.poll();
            System.out.print(s+ " ");
            ListIterator<Integer> listIterator  = adjList[s].listIterator();
            while (listIterator.hasNext()) {
                int n = listIterator.next();
                //System.out.println(n);
                if(!visited[n]) {
                    queue.add(n);
                    visited[n] = true;
                }
            }
        }
        System.out.println();
    }
    void dfsUtil(int n, boolean visited[]) {
        visited[n] = true;
        ListIterator<Integer> i = adjList[n].listIterator();
        System.out.print(n+" ");
        while (i.hasNext()) {
            n = i.next();
            if(!visited[n]) {
                dfsUtil(n,visited);
            }
        }
    }
    void dfs(int s) {
        System.out.print("DFS Traversal:");
        boolean visited[] = new boolean[V];
        dfsUtil(s,visited);
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(2,1);
        graph.bfs(0);
        graph.dfs(0);
    }

}
