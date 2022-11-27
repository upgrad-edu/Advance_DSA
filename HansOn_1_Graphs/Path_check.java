
import java.io.*;
 
class Path_check {
 
    public static void is_Path(int matrix[][], int n)
    {
        boolean visited[][] = new boolean[n][n];
 
        boolean flag = false;
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j])
 
                    if (is_Path(matrix, i, j, visited)) {
                        flag = true;
                        break;
                    }
            }
        }
        if (flag)
            System.out.println("YES, Path Possible Exist");
        else
            System.out.println("No Possible Path ");
    }
 
    public static boolean isSafe(int i, int j, int matrix[][])
    {
 
        if (i >= 0 && i < matrix.length && j >= 0
            && j < matrix[0].length)
            return true;
        return false;
    }
 
    public static boolean is_Path(int matrix[][], int i, int j, boolean visited[][])
    {
 
        if (isSafe(i, j, matrix) && matrix[i][j] != 0 && !visited[i][j]) {
            visited[i][j] = true;
 
            if (matrix[i][j] == 2)
                return true;
 
            boolean up = is_Path(matrix, i - 1, j, visited);
 
            if (up)
                return true;
            boolean left = is_Path(matrix, i, j - 1, visited);
 
            if (left)
                return true;
 
            boolean down = is_Path(matrix, i + 1, j, visited);
 
            if (down)
                return true;
 
            boolean right = is_Path(matrix, i, j + 1, visited);
 
            if (right)
                return true;
        }
        return false;
    }
    public static void main(String[] args)
    { 
        int matrix[][] = { { 0, 3, 0, 1 },
                           { 3, 0, 3, 3 },
                           { 2, 3, 3, 3 },
                           { 0, 3, 3, 3 } };
        is_Path(matrix, 4);
    }
}
