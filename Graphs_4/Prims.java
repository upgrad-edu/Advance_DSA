
class Prims{
    int adj[][];
    int verts;
    int keys[];
    boolean visited[];
    int parent[];
    int INF = 9999;
    Prims(int a[][],int n){
        verts = n;
        adj = new int[n][n];
        parent = new int[n];
        keys = new int[n];
        visited = new boolean[n];
        for(int i = 0;i < n;++i){
            visited[i] = false;
            keys[i] = INF;
            for(int j = 0;j < n;++j)
                adj[i][j] = a[i][j];
        }
    }
    int min_key(){
        int min = -1,minim = INF;
        for(int i = 0;i < verts;++i)
            if(visited[i] == false && keys[i] <= minim) {min = i;minim=keys[i];}
        return min;
    }
    void mst(int vertex){
        keys[vertex] = 0;
        for(int i = 0;i < verts-1;++i){
            int u = min_key();
            visited[u] = true;
            for(int j = 0;j < verts;++j){
                if(visited[j] == false && adj[u][j] != 0 && adj[u][j] < keys[j]){
                    keys[j] = adj[u][j];
                    parent[j] = u;
                }
            }
        }
    }
    void print(){
        int total = 0;
        for(int i = 0;i < verts;++i){
            System.out.println(i+" - "+parent[i]);
            total += adj[i][parent[i]];
        }
        System.out.println("The total cost is : "+total);
    }
    public static void main(String args[]){
        int n = 5;
        int[][] a = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
        { 0, 42, 66, 31, 0 } };
        Prims p = new Prims(a,n);
        p.mst(0);
        System.out.println("The edges of the MST are ");
        p.print();
    }
}