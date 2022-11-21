import java.io.*;
import java.util.*;  
 
class sum_two_dec_num_without_add {
	static int sum_without_add(int x, int y)
    {
        while (y != 0)
        {
            int carry = x & y;
 		    x = x ^ y;
 
            y = carry << 1;
        }
        return x;
    }
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter 1st number: ");
        int n = sc.nextInt();
        System.out.print("Enter 2nd number: ");
        int m = sc.nextInt();
        System.out.println(sum_without_add(n, m));
    }


}