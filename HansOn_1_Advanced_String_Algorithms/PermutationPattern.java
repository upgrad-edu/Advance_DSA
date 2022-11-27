package com.company;

import java.util.Arrays;

public class PermutationPattern{
    
    public static void main(String[] args) {

        String pattern = "abc";
        String text = "jhabcoihbca";
        search(pattern.toCharArray(),text.toCharArray());

    }

    static void search(char[] pattern, char[] txt)
    {


        int n = txt.length;
        int m = pattern.length;


        char[] sorted_pattern = pattern;
        Arrays.sort(sorted_pattern);


        StringBuilder temp;

        for (int i = 0; i <= n - m; i++) {
            temp = new StringBuilder();
            for (int k = i; k < m + i; k++)
                temp.append(txt[k]);
            char[] tempArray = temp.toString().toCharArray();
            Arrays.sort(tempArray);
            temp = new StringBuilder(new String(tempArray));


            if (String.valueOf(sorted_pattern).equals(temp.toString()))
                System.out.println("Index " + i);
        }
    }


    }

