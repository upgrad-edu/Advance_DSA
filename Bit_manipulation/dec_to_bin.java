import java.io.*;
import java.util.*;  
 
class dec_to_bin {
    
    static void dec_to_binary(int n){
        
        int[] binaryNum = new int[32];
 
        
        int i = 0;
        while (n > 0) {
            
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }
 
        
        for (int j = i - 1; j >= 0; j--)
            System.out.print(binaryNum[j]);
        System.out.println();
    }
 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter number: ");
        int n = sc.nextInt(); 
        dec_to_binary(n);
    }
}