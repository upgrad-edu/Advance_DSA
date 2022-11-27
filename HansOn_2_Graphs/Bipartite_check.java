import java.util.*;
 
class Bipartite_check{
 
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
     
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int v, boolean visited[], int color[])
    {
        for(int u : adj.get(v))
        {
            if (visited[u] == false)
            {        
                visited[u] = true;
                color[u] = 1 - color[v];
     
                if (!isBipartite(adj, u, visited, color))
                    return false;
            }
            else if (color[u] == color[v])
                return false;
        }
        return true;
    }

    public static void main(String args[])
    {
        int Total_nodes = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(Total_nodes + 1);
         
        for(int i = 0; i <= Total_nodes; i++)
        {
            adj.add(new ArrayList<Integer>());
        }
         
        boolean visited[] = new boolean[Total_nodes + 1];
         
        int color[] = new int[Total_nodes + 1];
         
        Arrays.fill(color, -1);
     
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 1);
     
        visited[1] = true;
     
        color[1] = 0;
     
        if (isBipartite(adj, 1, visited, color))
        {
            System.out.println("Graph is Bipartite");
        }
        else
        {
            System.out.println("Graph is not Bipartite");
        }
    }
}