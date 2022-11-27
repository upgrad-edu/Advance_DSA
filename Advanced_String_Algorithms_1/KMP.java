package com.company;

public class KMP{

    public final static int d = 26;
    public static void main(String[] args) {


        String to_search_for = "abc";
        String to_search_in = "jabcod";

       findSubstring(to_search_for,to_search_in);

    }

   static void findSubstring(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();


        int lps[] = new int[M];
        int j = 0;


        computeLPS(pat, M, lps);

        int i = 0;
        while ((N - i) >= (M - j)) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("pattern at " + (i - j));
                j = lps[j - 1];
            }


            else if (i < N && pat.charAt(j) != txt.charAt(i)) {

                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

   static void computeLPS(String pat, int M, int lps[])
    {

        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
                if (len != 0) {
                    len = lps[len - 1];


                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

