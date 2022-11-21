import java.io.*;
import java.util.*;  
 
class bin_to_dec {
    static int binary_to_dec(int n){
        int num = n;
        int dec_value = 0;
 
        // Initializing base
        // value to 1, i.e 2^0
        int base = 1;
 
        int temp = num;
        while (temp > 0) {
            int last_digit = temp % 10;
            temp = temp / 10;
 
            dec_value += last_digit * base;
 
            base = base * 2;
        }
 
        return dec_value;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter number: ");
        int n = sc.nextInt(); 
        System.out.println(binary_to_dec(n));
    }
}