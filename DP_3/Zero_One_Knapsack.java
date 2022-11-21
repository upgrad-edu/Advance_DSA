class Zero_One_Knapsack {
 
    static int max(int a, int b)
    {
        if (a>b) 
            return a;
        else

            return b;
    }
 
    static int knapSack(int W, int weight[],
                            int value[], int n)
        {
            int i, w;
            int K[][] = new int[n + 1][W + 1];
     
            for (i = 0; i <= n; i++)
            {
                for (w = 0; w <= W; w++)
                {
                    if (i == 0 || w == 0)
                        K[i][w] = 0;
                    else if (weight[i - 1] <= w)
                        K[i][w]
                            = max(value[i - 1]
                             + K[i - 1][w - weight[i - 1]],
                             K[i - 1][w]);
                    else
                        K[i][w] = K[i - 1][w];
                }
            }
     
            return K[n][W];
    }
 
    public static void main(String args[])
    {
        int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = value.length;
        System.out.println(knapSack(W, weight, value, n));
    }
}