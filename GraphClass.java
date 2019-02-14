import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GraphClass {
    private int V;
    private LinkedList<Integer>[] adjList;
    public GraphClass(int v){
        V = v;
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }
    int getVertexNumber() {
        return V;
    }
    LinkedList<Integer> getList(int n) {
        return adjList[n];
    }
    public void addEdge(int a, int b) {
        adjList[a].add(b);
    }
    void printGraph() {
        int n;
        for(int i=0;i<V;i++) {
            System.out.print(i);
            ListIterator<Integer> l = adjList[i].listIterator();
            while (l.hasNext()) {
                n = l.next();
                System.out.print("->"+n);
            }
            System.out.println();
            //System.out.println();
        }
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
        boolean[] visited = new boolean[V];
        dfsUtil(s,visited);
        System.out.println();
    }
    /*
    public static void main(String[] args) {
        int V = 5;
        GraphClass graph = new GraphClass(V);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(2,1);
        graph.printGraph();
        graph.bfs(0);
        graph.dfs(0);
        GraphClass graph2 = new GraphClass(6);
        graph2.addEdge(0,1);
        graph2.addEdge(0,2);
        graph2.addEdge(0,3);
        graph2.addEdge(1,3);
        graph2.addEdge(2,4);
        graph2.addEdge(3,5);

    }*/

}
