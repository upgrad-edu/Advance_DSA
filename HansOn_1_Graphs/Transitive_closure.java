
import java.util.*;
import java.lang.*;
import java.io.*;
 
class Transitive_closure
{
    final static int Total_vertices = 4;
 
    void transitiveClosure(int g[][])
    {
        int reach[][] = new int[Total_vertices][Total_vertices];
        int  i, j, k;
 
        for (i = 0; i < Total_vertices; i++)
            for (j = 0; j < Total_vertices; j++)
                reach[i][j] = g[i][j];
        for (k = 0; k < Total_vertices; k++)
        {
            for (i = 0; i < Total_vertices; i++)
            {
                for (j = 0; j < Total_vertices; j++)
                {
                    reach[i][j] = (reach[i][j]!=0) || ((reach[i][k]!=0) && (reach[k][j]!=0))?1:0;
                }
            }
        }
 
        print(reach);
    }
 
    void print(int reach[][])
    {
        System.out.println("Following matrix is the transitive closure of the given graph");
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++) {
                if ( i == j)
                  System.out.print("1 ");
                else
                  System.out.print(reach[i][j]+" ");
            }
            System.out.println();
        }
    }
 
    public static void main (String[] args)
    {
         int graph_1[][] = new int[][]{ {1, 1, 0, 1},
                                      {0, 1, 1, 0},
                                      {0, 0, 1, 1},
                                      {0, 0, 0, 1}
                                    };
 
         Transitive_closure g = new Transitive_closure();
         g.transitiveClosure(graph_1);
    }
}