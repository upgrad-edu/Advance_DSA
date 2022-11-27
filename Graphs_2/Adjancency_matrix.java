public class Adjancency_matrix {
	int vertex;
	int matrix[][];

	public Adjancency_matrix(int vertex) {
		this.vertex = vertex;
		matrix = new int[vertex][vertex];
	}

	public void addEdge(int source, int destination) {
		matrix[source][destination]=1;
		matrix[destination][source] = 1;
	}

	public void printG() {
		System.out.println("Graph: (Adjancency Matrix)");
		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j <vertex ; j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		for (int i = 0; i < vertex; i++) {
			System.out.print("Vertex " + i + " is connected to:");
			for (int j = 0; j <vertex ; j++) {
				if(matrix[i][j]==1){
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Adjancency_matrix graph = new Adjancency_matrix(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.printG();
	}
}