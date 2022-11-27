import java.io.*;
class min_path_sum {
 
  static int find(int Arr[][], int i, int j)
  {
 
    if(i == Arr.length){
      return 0 ;
    }
 
    int m ;
 
    m = Arr[i][j] + Math.min(find(Arr, i+1,j), find(Arr,i+1, j+1)) ;
 
    return m ;
  }
  static int minSumPath(int Arr[][]) {
    return find(Arr, 0, 0) ;
  }
 
  public static void main(String[] args)
  {
    int tri [][] = { { 4 },
                         { 6, 18 },
                         { 2, 12, 14 }  };
    System.out.println(minSumPath(tri));
  }
}