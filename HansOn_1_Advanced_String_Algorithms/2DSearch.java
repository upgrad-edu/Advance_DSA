package com.company;
import java.util.Arrays;

public class 2DSearch{

    public static void main(String[] args) {

        String search = "APPLE";
        String input[] = { "BBABBB", "EBPBBB", "LBPBBB", "PBLBBB", "PBEBBB", "AELPPA" };

        String str[] = new String[input.length];
        int i;
        for(i = 0; i < input.length; ++i)
        {
            str[i] = input[i];
        }

        System.out.println("counting: " +
                searchString(search, 0, 0, str,
                        str.length,
                        str[0].length()));

    }

    static int Searchin2D(String search, int row,
                              int col, String arr[],
                              int row_max, int col_max,
                              int xx) {
        int found = 0;

        if (row >= 0 && row <= row_max && col >= 0 &&
                col <= col_max && xx < search.length() &&
                search.charAt(xx) == arr[row].charAt(col)) {
            char match = search.charAt(xx);
            xx += 1;

            arr[row] = arr[row].substring(0, col) + "0" +
                    arr[row].substring(col + 1);

            if (xx == search.length()) {
                found = 1;
            } else {


                found += Searchin2D(search, row,
                        col + 1, arr,
                        row_max, col_max, xx);
                found += Searchin2D(search, row, col - 1,
                        arr, row_max, col_max, xx);
                found += Searchin2D(search, row + 1, col,
                        arr, row_max, col_max, xx);
                found += Searchin2D(search, row - 1, col,
                        arr, row_max, col_max, xx);
            }

            arr[row] = arr[row].substring(0, col) +
                    match + arr[row].substring(col + 1);
        }
        return found;
    }


    static int searchString(String needle, int row, int col,
                            String str[], int row_count,
                            int col_count) {
        int found = 0;
        int r, c;

        for (r = 0; r < row_count; ++r) {
            for (c = 0; c < col_count; ++c) {
                found += Searchin2D(needle, r, c, str,
                        row_count - 1,
                        col_count - 1, 0);
            }
        }
        return found;
    }

}