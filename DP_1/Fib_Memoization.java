import java.io.*;
import java.util.*;  
 
class Fib_Memoization {
	int[] cache;

    Fib_Memoization(int[] cache){
        this.cache = cache;
    }

    int fibonacci(int n) {
        if (cache[n] == 0) {
            if (n < 2) cache[n] = n;
            else cache[n] = fibonacci(n-1) + fibonacci( n-2);
        }

        return cache[n];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println(new Fib_Memoization(new int[n+1]).fibonacci(n));
    }
}