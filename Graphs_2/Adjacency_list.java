import java.util.LinkedList;

public class Adjacency_list {
    int vertex;
    private LinkedList <Integer> list[];

    public Adjacency_list(int vertex) {
        this.vertex = vertex;
        list = new LinkedList<Integer>[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void add_Edge(int source, int destination){

        list[source].addFirst(destination);
        list[destination].addFirst(source);
    }

    public void print(){
        for (int i = 0; i <vertex ; i++) {
            if(list[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Adjacency_list graph = new Adjacency_list(5);
        graph.add_Edge(0,1);
        graph.add_Edge(0, 4);
        graph.add_Edge(1, 2);
        graph.add_Edge(1, 3);
        graph.add_Edge(1, 4);
        graph.add_Edge(2, 3);
        graph.add_Edge(3, 4);
        graph.print();
    }
}