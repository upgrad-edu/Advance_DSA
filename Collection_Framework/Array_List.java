import java.io.*;
import java.util.*;
 
class Array_List {
    public static void main(String[] args)
    {
 
        ArrayList<Integer> array_list = new ArrayList<>();
 
        for (int i = 1; i <= 5; i++)
            array_list.add(i);
 
        System.out.println(array_list);
 
        array_list.remove(3);
 
        System.out.println(array_list);
 
        for (int i = 0; i < array_list.size(); i++)
            System.out.print(array_list.get(i) + " ");
    }
}