package com.company;

public class RabinKarp{

    public final static int d = 26;
    public static void main(String[] args) {


        String to_search_for = "abc";
        String to_search_in = "jjhjhvjhvhhbabcod";

        System.out.println(findSubstring(to_search_for,to_search_in,to_search_in.length()));

    }

    static int findSubstring(String to_search_for, String to_search_in, int length) {

        int m = to_search_for.length();
        int n = to_search_in.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;

        for (i = 0; i < m - 1; i++)
            h = (h * d) % length;


        for (i = 0; i < m; i++) {
            p = (d * p + to_search_for.charAt(i)) % length;
            t = (d * t + to_search_in.charAt(i)) % length;
        }

        for (i = 0; i <= n - m; i++) {
            if (p == t) {
                for (j = 0; j < m; j++) {
                    if (to_search_in.charAt(i + j) != to_search_for.charAt(j))
                        break;
                }

                if (j == m)
                    return i;
            }

            if (i < n - m) {
                t = (d * (t - to_search_in.charAt(i) * h) + to_search_in.charAt(i + m)) % length;
                if (t < 0)
                    t = (t + length);
            }
        }

        return -1;
    }
}
