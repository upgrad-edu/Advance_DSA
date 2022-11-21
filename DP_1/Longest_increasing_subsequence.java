import java.io.*;
import java.util.*;  
 
class Longest_increasing_subsequence {
	static int max; 
 
    
    static int _longest_increasing_subsequence(int arr[], int n)
    {
        if (n == 1)
            return 1;

        int res, max_ending = 1;
 
        for (int i = 1; i < n; i++) {
            res = _longest_increasing_subsequence(arr, i);
            if (arr[i - 1] < arr[n - 1]
                && res + 1 > max_ending)
                max_ending = res + 1;
        }
 

        if (max < max_ending)
            max = max_ending;
 
        return max_ending;
    }
 
    static int lis(int arr[], int n)
    {
        
        max = 1;
        _longest_increasing_subsequence(arr, n);
 
        return max;
    }
 
    public static void main(String args[])
    {
        int arr[] = { 3, 4, 1, 13, 2, 18, 24 };
        int n = arr.length;
        System.out.println( lis(arr, n));
    }
}