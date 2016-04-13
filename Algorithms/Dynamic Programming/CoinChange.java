import java.io.*;
import java.util.*;

public class Solution {

    //number of ways to create this amount of change.
    static int[] numWays;
    
    //the coins we can use
    static int[] coins;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        
        coins = new int[M];
        for (int i = 0; i < M; i++) {
        	coins[i] = in.nextInt();
        }

        numWays = new int[N];

        solve(N);
    }

    //solve recursively, keeping track of how many ways there are to create certain amounts...
    // n = the amount you need to create
    public static int solve(int n) {
    	if (n == 0) return 1;

    	// 1. 
    	// Check if we know how many ways there are to create a certain amount

    	// 2.
    	// If we don't know yet, branch out, 
    	// finding out how many ways there are to create a certain amount.
    	// Then record it in the array.

    }
}