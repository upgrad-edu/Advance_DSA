import java.util.Arrays;
 
class Coin_Change {
    static long countWays(int coins[], int len, int sum)
    {
        
        long[] table = new long[sum + 1];
 
        Arrays.fill(table, 0);
 
        table[0] = 1;
 
        for (int i = 0; i < len; i++)
            for (int j = coins[i]; j <= sum; j++)
                table[j] += table[j - coins[i]];
 
        return table[sum];
    }
 
    public static void main(String args[])
    {
        int coins[] = { 1, 2, 3};
        int len = coins.length;
        int sum = 4;
        System.out.println(countWays(coins, len, sum));
    }
}