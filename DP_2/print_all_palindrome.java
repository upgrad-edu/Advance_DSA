import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
 
public class print_all_palindrome
{
    public static void main(String[] args)
    {
        String input = "abaabccb";
 
        //System.out.println();
 
        all_Partitions(input);
    }
 
    private static void all_Partitions(String input)
    {
        int n = input.length();
 
        ArrayList<ArrayList<String>> allPart = new ArrayList<>();
 
        Deque<String> currPart = new LinkedList<String>();
 
        allPalPartitonsUtil(allPart, currPart, 0, n, input);
        for (int i = 0; i < allPart.size(); i++)
        {
            for (int j = 0; j < allPart.get(i).size(); j++)
            {
                System.out.print(allPart.get(i).get(j) + " ");
            }
            System.out.println();
        }
 
    }
 
    private static void allPalPartitonsUtil(ArrayList<ArrayList<String>> allPart,
            Deque<String> currPart, int start, int n, String input)
    {
        if (start >= n)
        {
            allPart.add(new ArrayList<>(currPart));
            return;
        }
 
        for (int i = start; i < n; i++)
        {
             
            if (isPalindrome(input, start, i))
            {
                 
                currPart.addLast(input.substring(start, i + 1));
 
                allPalPartitonsUtil(allPart, currPart, i + 1, n, input);
 
                currPart.removeLast();
            }
        }
    }
    private static boolean isPalindrome(String input,
                                    int start, int i)
    {
        while (start < i)
        {
            if (input.charAt(start++) != input.charAt(i--))
                return false;
        }
        return true;
    }
}