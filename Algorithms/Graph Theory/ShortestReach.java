import java.io.*;
import java.util.*;

public class Solution {

   	static Scanner in;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        in = new Scanner(System.in);
        
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
        	solve();
        }
        
    }

    public static void solve() {
    	int N = in.nextInt();
    	int M = in.nextInt();

    	int[][] edges = new int[N][N];
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			edges[i][j] = -1;
    		}
    	}

    	for (int i = 0; i < M; i++) {
    		int x = in.nextInt()-1;
    		int y = in.nextInt()-1;

    		edges[x][y] = 6;
    		edges[y][x] = 6;

       	}

       	System.out.println(edges);
        
    	int start = in.nextInt();
    	int[] ans = breadthFirstSearch(edges, start-1, N);

    	for (int i = 0; i < ans.length; i++) {
            if (i == start) continue;
    		System.out.print(ans[i] + " ");
    	}
    	System.out.println();

    }

    public static int[] breadthFirstSearch(int[][] edges, int start, int N) {
    	int[] ans = new int[N];
    	for (int i = 0; i < N; i++) {
    		ans[i] = -1;
    	}

    	ArrayList<Integer> visited = new ArrayList<Integer>();
    	visited.add(start);

    	// round i : look at immediate neighbors, 
    	// if direct path, add to ans and to queue.
    	// if not... wait until you find it.
    	for (int i = 0; i < N; i++) {
    		//int numToSearch = toSearch.size();

    		// look at their neighbors. 
    		// if they are not in visited, add 6*i to their ans value
    		for (int j = 0; j < N; j++) {

    			if (j == i) continue;
    			if (visited.contains(j)) continue;

    			if (edges[i][j] == 6) {
    				ans[j] = 6*(i+1);
    				visited.add(j);
    			}
    		}
    	}

    	return ans;
    }
    // public static void connect(int[] edges, N) {
    // 	// given an array of edges, calculate distances to other locations...
    // 	//    also taking into account that we only added one edge

    // 	boolean notUpdated = true;
    // 	do {

    // 		// go through the graph and connect points.
    // 		for (int i = 0; i < N; i++) {
    // 			for (int j = 0; j < N; j++) {
    // 				if (i == j) continue;
    // 				// try to find the shortest path between i and j

    // 			}
    // 		}


    // 	} while (!notUpdated)
    // }

}
