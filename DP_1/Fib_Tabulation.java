import java.io.*;
import java.util.*;  
 
class Fib_Tabulation {
	int fibonacci(int n) {
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println(new Fib_Tabulation().fibonacci(10));
    }
}