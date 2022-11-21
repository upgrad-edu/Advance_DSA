class Rod_Cutting
{
    static int cut_Rod(int price[],int size)
    {
        int val[] = new int[size+1];
        val[0] = 0;
 
        for (int i = 1; i<=size; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val, price[j] + val[i-j-1]);
            val[i] = max_val;
        }
 
        return val[size];
    }
 
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 4, 7, 8, 11, 17, 19, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + cut_Rod(arr, size));
    }
}