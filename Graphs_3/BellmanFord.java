class BellmanFordImplemenation {

	public int[] findMinimunPath(int src, int[][] g) {
		int[] dist = new int[g.length];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;

		for (int k = 0; k < g.length - 1; k++) {
			for (int i = 0; i < g.length; i++) {
				for (int j = 0; j < g.length; j++) {
					if (g[i][j] != 0) {
						if (dist[i] != Integer.MAX_VALUE
								&& dist[j] > dist[i] + g[i][j]) {
							dist[j] = dist[i] + g[i][j];
						}
					}
				}
			}
		}
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++) {
				if (g[i][j] != 0) {
					if (dist[i] != Integer.MAX_VALUE
							&& dist[j] > dist[i] + g[i][j]) {
						dist[0] = Integer.MIN_VALUE;
						return dist;
					}
				}
			}
		}
		return dist;
	}
}

public class BellmanFord {

	public static void main(String[] args) {
		BellmanFordImplemenation o = new BellmanFordImplemenation();
		
		int[][] graph_1 =  {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
	        {4, 0, 8, 0, 0, 0, 0, 11, 0},
	        {0, 8, 0, 7, 0, 4, 0, 0, 2},
	        {0, 0, 7, 0, 9, 14, 0, 0, 0},
	        {0, 0, 0, 9, 0, 10, 0, 0, 0},
	        {0, 0, 4, 14, 10, 0, 2, 0, 0},
	        {0, 0, 0, 0, 0, 2, 0, 1, 6},
	        {8, 11, 0, 0, 0, 0, 1, 0, 7},
	        {0, 0, 2, 0, 0, 0, 6, 7, 0}
       	};
	

		int[] r = o.findMinimunPath(0, graph_1);
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}

	}
}