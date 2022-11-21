import java.io.*;
import java.util.*;  
 
class bit_reversed {
	public static int  reverse_bits(int num) {
	        int b=0;
	        while (num > 0)
	                {
	                    // bitwise left shift
	                    // 'rev' by 1
	                    b <<= 1;
	         
	                    // if current bit is '1'
	                    if ((int)(num & 1) == 1)
	                        b ^= 1;
	         
	                    // bitwise right shift
	                    //'n' by 1
	                    num >>= 1;
	                }

	        return b;
	    }

	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter number: ");
        int n = sc.nextInt(); 
        System.out.println(reverse_bits(n));
    }
}