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


class Result {

	public static int maxProfit(List<Integer> A) {
		    int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<A.size(); i++){
            if(A.get(i) < minPrice){ 
                minPrice = A.get(i);
            }else{ 
                int profit = A.get(i) - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
		
	}
}

public class Buy_and_sell {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int ACount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> A = IntStream.range(0, ACount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(toList());

		int result = Result.maxProfit(A);

		System.out.print(String.valueOf(result));

		bufferedReader.close();	}
}