import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.ListIterator;

public class Topological_Sort {
    public Topological_Sort(GraphClass graph) {
        int vertex = inDegree(graph);
        if(vertex == -1)
            System.out.println("No Vertex with inDegree -1");
        else
            TopologicalSortUtil(graph,vertex);
    }
    void TopologicalSortUtil(GraphClass graph,int vertex) {
        boolean[] visited = new boolean[graph.getVertexNumber()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while (queue.size() != 0) {
            System.out.println(queue.poll());
            ListIterator<Integer> i = (graph.getList(vertex)).listIterator();
            while (i.hasNext()) {
                vertex = i.next();
                if(!visited[vertex]) {
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }
    }
    int inDegreeZero(boolean[] visited) {
        for(int i=0;i< Array.getLength(visited);i++) {
            if(visited[i] == false) {
                return i;
            }
        }
        return -1;
    }
    int inDegree(GraphClass graph) {
        boolean[] visited = new boolean[graph.getVertexNumber()];
        graph.dfsUtil(5,visited);
        /*LinkedList<Integer> queue = new LinkedList<>();
        int start = 0;
        queue.add(start);
        while (queue.size() != 0) {
            queue.poll();
            ListIterator<Integer> i = (graph.getList(start)).listIterator();
            while (i.hasNext()) {
                start = i.next();
                if(!visited[start]) {
                    visited[start] = true;
                    queue.add(start);
                }
            }
        }*/
        int vertex = inDegreeZero(visited);
        System.out.println("vertex = " + vertex);
        return vertex;
    }
    public static void main(String[] args) {
        GraphClass graph = new GraphClass(6);
        graph.addEdge(5,0);
        graph.addEdge(4,0);
        graph.addEdge(5,2);
        graph.addEdge(2,3);
        graph.addEdge(4,1);
        graph.addEdge(3,1);
        Topological_Sort topo = new Topological_Sort(graph);
    }
}
