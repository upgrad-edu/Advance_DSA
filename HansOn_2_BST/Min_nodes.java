class Min_nodes{
 
    static int min_nodes(int H, int a, int b){
        
        if (H == 0)
            return 1;
        if (H == 1)
            return b;
     
        return min_nodes(H - 1, b, a + b + 1);
    }
     
    public static void main(String[] args){
        int Height = 5;
        
        System.out.println( min_nodes(Height, 1, 2) + " minimum number of nodes an AVL tree can have with height (" + Height );
    }
}