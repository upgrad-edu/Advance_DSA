class Min_connection {
    public int makeConnected(int n, int[][] connections) {
        int count=0;
        boolean[] visited=new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
        int m = connections.length;   
        if(m<n-1){          
            return -1;
        }

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] i:connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i,adj,visited);
                
            }
        }
        return count-1;
    }
    public void dfs(int v,ArrayList<ArrayList<Integer>> adj,boolean[] visited)
    {
        visited[v]=true;
        //ans.add(v);
        for(int i=0;i<adj.get(v).size();i++)
        {
            if(!visited[adj.get(v).get(i)])
            {
                visited[adj.get(v).get(i)]=true;
                dfs(adj.get(v).get(i),adj,visited);
            }
        }
    }
}