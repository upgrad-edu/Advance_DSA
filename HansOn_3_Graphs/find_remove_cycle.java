import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
class GraphDetectCycleAndRemove {
	
	static class DirectedGraphNode { 
		int label; 
		List<DirectedGraphNode> neighbors ;		
		
		DirectedGraphNode(int  x) { 
			label = x; 
			neighbors =  new CopyOnWriteArrayList<>();	
		} 
		
	    public String toString() {	    	
	    	return String.valueOf(label);
	    }
	} 
	
	Map<Integer, DirectedGraphNode> adj = new HashMap<>();
	
	public void addEdge(int a, int b) {
		adj.putIfAbsent(a, new DirectedGraphNode(a));
		adj.putIfAbsent(b, new DirectedGraphNode(b));
		DirectedGraphNode node1 = adj.get(a);
		DirectedGraphNode node2 = adj.get(b);
		node1.neighbors.add(node2);		
	}
	public boolean detectCycle() {
	    Map<Integer, Boolean> visited = new HashMap<>();
	    Map<Integer, Boolean> backTrack = new HashMap<>();
 	 	for (int key: adj.keySet()) {
	    	visited.put(key, false);
	    	backTrack.put(key, false);
 	 	}
	    for (Integer key: adj.keySet()) {	
	        if (!visited.get(key)) {
	            if (cycleUtil(key, visited, backTrack)) {                
	                return true;
	            }   
	        }
	    }
	    return false;
	}
	
	private boolean cycleUtil(int v,  Map<Integer, Boolean> visited, Map<Integer, Boolean> backTrack){
    	if (backTrack.get(v)) 
    		return true;   
	    if (visited.get(v))
	    	return false;	    
	    visited.put(v, true);
	    backTrack.put(v, true);;
	    for (DirectedGraphNode ne : adj.get(v).neighbors) {
           if (cycleUtil(ne.label, visited, backTrack))
                return true; 
	    }
	    backTrack.put(v, false);
	    return false;
	}
	
	public boolean removeCycle() {
		for (int key: adj.keySet()) {
			for (DirectedGraphNode ne: adj.get(key).neighbors) {
				removeEdge(key, ne.label);
				boolean b = detectCycle();
				if (!b) {
					System.out.println("remove edge: "+ key+","+ne);
					return true;				
				}
				else 
					addEdge(key, ne.label); 
			}
		}
		return false;
	}
	
	public void removeEdge(int a, int b) {
		DirectedGraphNode node1 = adj.get(a);
		DirectedGraphNode node2 = adj.get(b);
		if (node1 == null || node2 == null)
			return;
		node1.neighbors.remove(node2);
	}
}

public class find_remove_cycle{
	public static void main(String a[])	{	
		
		GraphDetectCycleAndRemove g = new GraphDetectCycleAndRemove();
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);	
		g.addEdge(2, 3);	
		
		boolean hasCycle = g.detectCycle();
		System.out.println("has cycle: " + hasCycle);		
		if (hasCycle)
			g.removeCycle();
		hasCycle = g.detectCycle();
		System.out.println("has cycle: " + hasCycle);
	}
}