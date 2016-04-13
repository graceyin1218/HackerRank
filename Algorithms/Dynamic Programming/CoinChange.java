import java.io.*;
import java.util.*;

public class Solution {

    //number of ways to create this amount of change.
    static long[] numWays;

    //the coins we can use
    static int[] coins;

    //a list of the distinct ways of creating a certain value, order doesn't matter.
    // combinations[10] would return an ArrayList of the combination of coins that add to 10 cents. 
//    static ArrayList<Set<Integer>>[] combinations;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        
        coins = new int[M];
        for (int i = 0; i < M; i++) {
            coins[i] = in.nextInt();
        }

        Arrays.sort(coins);

        numWays = new long[N+1];
        //combinations = new ArrayList<Set<Integer>>[N+1];

        System.out.println(solve(N, coins));
    }

    //solve recursively, keeping track of how many ways there are to create certain amounts...
    // n = the amount you need to create




    public static long solve(int n, int[] availableCoins) {

        if (n == 0) return 1;

        //if (numWays[n] != -1) return numWays[n];
        
        //probably won't get to this case.. O:)
        if (availableCoins.length == 0) return 0;

        if (availableCoins.length == 1) {
            if (n%availableCoins[0] == 0) {
                return 1;
            }
        }

        int largestCoin = availableCoins[availableCoins.length-1];
        long answer = 0;
        int i = 0;
        
        while (largestCoin*i <= n) {
            answer += solve(n-largestCoin*i, Arrays.copyOfRange(availableCoins, 0, availableCoins.length-1));
            i++;
        }
        
        //numWays[n] = answer;
        return answer;
    }
}


    // public static Answer solve(int n) {

    //     ArrayList<Set<Integer>> localCombinations = new ArrayList<Set<Integer>>();

    // 	if (n == 0) return new Answer(1, localCombinations);

    // 	// 1. 
    // 	// Check if we know how many ways there are to create a certain amount

    // 	if (numWays[n] != 0) {
    // 		return new Answer(numWays[n], combinations[n]);
    // 	}


    // 	// 2.
    // 	// If we don't know yet, branch out, 
    // 	// finding out how many ways there are to create a certain amount.
    // 	// Then record it in the array.

    //     // To avoid overcounting, you need to make sure you're using a different 
    //     // set of coins to create exactly n cents.

    // 	long count = 0;
    // 	for (int coin: coins) {
    //         if (n-coin >= 0) 
    //         {
    //             count += solve(n-coin);
    //         }
    // 	}

    // 	numWays[n] = count;
    // 	return count;

    // }



    // public class Answer {
    //     long count;

    //     ArrayList<Set<Integer>> ways;

    //     public Answer(long c, ArrayList<Set<Integer>> w) {
    //         this.count = c;
    //         this.ways = w;
    //     }
    //     public getCount() {
    //         return count;
    //     }

    // }

}