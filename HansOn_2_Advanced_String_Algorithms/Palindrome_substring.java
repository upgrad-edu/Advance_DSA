
import java.util.ArrayList;
import java.util.List;
 
public class Palindrome_substring {
    public static List<String> allPalindromeSubstring(String s)
    {
        List<String> list = new ArrayList<String>();
 
        for (float pivot = 0; pivot < s.length(); pivot += .5) {
 
            float palindromeRadius = pivot - (int)pivot;
 
            while ((pivot + palindromeRadius) < s.length()
                   && (pivot - palindromeRadius) >= 0
                   && s.charAt((int)(pivot - palindromeRadius))== s.charAt((int)(pivot + palindromeRadius))) {
 
                list.add(s.substring((int)(pivot - palindromeRadius), (int)(pivot + palindromeRadius + 1)));
 
                palindromeRadius++;
            }
        }
 
        return list;
    }
 
    public static void main(String[] args)
    {
        List<String> list = allPalindromeSubstring("hellolle");
        System.out.println(list.size());
        System.out.println(list);
        list = allPalindromeSubstring("happyeyptpah");
        System.out.println(list.size());
        System.out.println(list);
    }
}