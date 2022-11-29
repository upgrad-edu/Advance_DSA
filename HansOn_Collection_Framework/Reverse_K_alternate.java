import java.io.*;
import java.util.*;
  
class Reverse_K_alternate {

    Node kAltReverse(Node node, int k)
    {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;
 
        while (current != null && count < k) 
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
 
        if (node != null)
        {
            node.next = current;
        }
 
        count = 0;
        while (count < k - 1 &&
               current != null)
        {
            current = current.next;
            count++;
        }
 
        if (current != null)
        {
            current.next =
                    kAltReverse(current.next, k);
        }
 

        return prev;
    }

    public static void main(String[] args)
    {
  
        
        LinkedList<Integer> ll = new LinkedList<Integer>();
  

        for (int i = 1; i <= 5; i++)
            ll.add(i);
  
        System.out.println(ll);
  
        ll.remove(3);
  
        System.out.println(ll);
  
        for (int i = 0; i < ll.size(); i++)
            System.out.print(ll.get(i) + " ");
    }
}