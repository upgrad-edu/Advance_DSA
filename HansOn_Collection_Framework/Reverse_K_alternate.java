import java.util.*;

public class Reverse_K_alternate {

    public static void main(String[] args)
    {


        LinkedList<Integer> ll = new LinkedList<Integer>();


        for (int i = 1; i <= 14; i++)
            ll.add(i);

        System.out.println(ll);

        int k_value= 5;

        System.out.println(ll);

        int i = 0;

        for( i=0; i<k_value*(ll.size()/k_value);i++){

            int start = i;
            int end = i+k_value-1;


            reverseLinkedList(ll,start,end);

            i = end+k_value;
        }

        if(ll.size()%k_value!=0){
            remaining_rev(ll,i,ll.size()-1);
        }

        for (int j = 0; j < ll.size(); j++)
            System.out.print(ll.get(j) + " ");
    }

    private static void remaining_rev(LinkedList<Integer> ll, int j, int i1) {

        for ( int i=j; i <= (j+i1)/2; i++) {
            Integer temp = ll.get(i);
            ll.set(i, ll.get(i1 - i +j));
            ll.set(i1 - i+j, temp);
        }
    }

    public static void reverseLinkedList(LinkedList<Integer> llist, int start, int end )
    {
        for (int i = start; i < (start+end)/2; i++) {
            Integer temp = llist.get(i);
            llist.set(i, llist.get(end - i +start));
            llist.set(end - i+start, temp);
        }

        // Return the reversed arraylist

    }

}
