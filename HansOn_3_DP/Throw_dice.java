import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Throw_a_dice {



	public static long diceThrow(int m, int n, int k) {
		long mem[][] = new long[n + 1][k + 1];
        mem[0][0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=i; j<=k; j++) {
                 mem[i][j] = mem[i][j-1] + mem[i-1][j-1];
                if(j-m-1 >= 0)
                    mem[i][j] -= mem[i-1][j-m-1];
            }
        }
        return mem[n][k];
		
	}
}

public class Throw_dice {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(bufferedReader.readLine().trim());
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		int k = Integer.parseInt(bufferedReader.readLine().trim());

		long result = Throw_a_dice.diceThrow(m, n, k);

		System.out.print(String.valueOf(result));

		bufferedReader.close();	}
}