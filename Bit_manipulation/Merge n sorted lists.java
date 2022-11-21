import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

	/*
	 * Complete the 'mergeLists' function below.
	 * 
	 * The function is expected to return an INTEGER ARRAY.
	 * The function accepts INTEGER 2D ARRAY A as parameter.
	 * 
	 */

static class Pair implements Comparable<Pair>{
        int listIdx;
        int dataIdx;
        int data;
        Pair(int listIdx, int dataIdx, int data){
            this.listIdx = listIdx;
            this.dataIdx = dataIdx;
            this.data = data;
        }
        public int compareTo(Pair other){
            return this.data - other.data;
        }
    }
	public static List<Integer> mergeLists(List<List<Integer>> A) {
		// Write your code here
		 List<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        for(int i = 0; i<A.size(); i++){
            pq.add(new Pair(i, 0, A.get(i).get(0)));
        }
        while(pq.size() > 0){
            Pair p = pq.poll();
            ans.add(p.data);
            p.dataIdx++;
            if(p.dataIdx < A.get(p.listIdx).size()){
                p.data = A.get(p.listIdx).get(p.dataIdx);
                pq.add(p);
            }
        }
        return ans;
		
	}
}

public class Source {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int ARows = Integer.parseInt(bufferedReader.readLine().trim());	
		int AColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> A = new ArrayList<>();

		IntStream.range(0, ARows).forEach(i -> {
			try {
				A.add(
					Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
					);
			} catch (IOException ex) {
					throw new RuntimeException(ex);
			}
		});

		List<Integer> result = Result.mergeLists(A);

		System.out.print(result.stream().map(Object::toString).collect(joining("\n")));

		bufferedReader.close();	}
}