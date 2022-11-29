import java.util.*;
public class stack {
    
    public static void main(String args[])
    {
        Stack<String> stack = new Stack<String>();
        stack.push("u");
        stack.push("p");
        stack.push("G");
        stack.push("r");
        stack.push("a");
        stack.push("d");
  
        Iterator<String> x = stack.iterator();
  
        while (x.hasNext()) {
            System.out.print(x.next() + " ");
        }
  
        System.out.println();
  
        stack.pop();
  
        x = stack.iterator();
  
        while (x.hasNext()) {
            System.out.print(x.next() + " ");
        }
    }
}