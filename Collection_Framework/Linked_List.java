import java.util.*;
 
public class Linked_List {
 
    public static void main(String args[])
    {
        LinkedList<String> linkedlist = new LinkedList<String>();
 
        linkedlist.add("A");
        linkedlist.add("B");
        linkedlist.addLast("C");
        linkedlist.addFirst("D");
        linkedlist.add(2, "E");
 
        System.out.println(linkedlist);
 
        linkedlist.remove("B");
        linkedlist.remove(3);
        linkedlist.removeFirst();
        linkedlist.removeLast();
 
        System.out.println(linkedlist);
    }
}