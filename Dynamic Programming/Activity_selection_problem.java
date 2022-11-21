import java.io.*;
import java.lang.*;
import java.util.*;
 
class Activity_selection_problem {
 
    static class Pair {
 
        int first;
        int second;
 
        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
 
    static void SelectActivities(int s[], int f[])
    {

        ArrayList<Pair> ans = new ArrayList<>();

        PriorityQueue<Pair> p = new PriorityQueue<>(
            (p1, p2) -> p1.first - p2.first);
 
        for (int i = 0; i < s.length; i++) {

            p.add(new Pair(f[i], s[i]));
        }
 
        Pair it = p.poll();
        int start = it.second;
        int end = it.first;
        ans.add(new Pair(start, end));
 
        while (!p.isEmpty()) {
            Pair itr = p.poll();
            if (itr.second >= end) {
                start = itr.second;
                end = itr.first;
                ans.add(new Pair(start, end));
            }
        }
        System.out.println("Following Activities should be selected.");
 
        for (Pair itr : ans) {
            System.out.println( "(" + itr.first + "," + itr.second + ")");
        }
    }
 
    public static void main(String[] args)
    {
 
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };
 
        SelectActivities(s, f);
    }
}