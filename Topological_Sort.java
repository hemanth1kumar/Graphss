import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
public class Topological_Sort {

    public void printStack(Stack stack) {
        while(!stack.empty()) {
            System.out.print(stack.pop()+ ", ");
        }
    }
    public Topological_Sort(GraphClass graph) {
        Stack stack = new Stack();
        int v = graph.getVertexNumber();
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++) {
            if(!visited[i])
                TopologicalSortUtil(graph, visited, stack, i);
        }
        printStack(stack);
    }
    void TopologicalSortUtil(GraphClass graph,boolean[] visited,Stack stack, int num) {
        visited[num] = true;
        Iterator<Integer> ir;
        ListIterator<Integer> i = (graph.getList(num)).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                TopologicalSortUtil(graph, visited, stack, n);
            }
            stack.push(n);
        }
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
