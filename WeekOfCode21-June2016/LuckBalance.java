import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        
        int ans = 0;
        
        //ArrayList<Integer> important = new ArrayList<Integer>();
        
        int[] important = new int[N];
        int index = 0;
        
        for (int i = 0; i < N; i++) {
            int L = in.nextInt();
            int T = in.nextInt();
            
            // not important
            if (T == 0) {
                ans += L;
            }
            else {
                important[index] = L;
                index++;
            }
        }
        
        Arrays.sort(important);
        
        int length = important.length;
        
        for (int i = 0; i < K; i++) {
            ans += important[length-1-i];
        }
        for (int i = 0; i < N-K; i++) {
            ans -= important[i];
        }
        System.out.println(ans);
        
    }
}