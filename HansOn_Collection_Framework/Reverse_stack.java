import java.io.*;
import java.util.*;
  
class Reverse_stack {
  
    public static String Reverse(String str)
    {
        char[] reverseStr = new char[str.length()];
        Stack<Character> stack = new Stack<Character>();
  
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        
        int i = 0;
        while (!stack.isEmpty()) { 
            reverseStr[i++] = stack.pop();
        }
        return new String(reverseStr);
    }
  
    public static void main(String[] args)
    {
        String str1 = "UpGrad";
        System.out.println(str1 + " <- Reverse -> " + Reverse(str1));
        
        String str2 = "Hello Learners";
        System.out.println(str2 + " <- Reverse -> " + Reverse(str2));
    }
}