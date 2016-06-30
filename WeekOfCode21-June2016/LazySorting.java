import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    // using the concept of "mean time to failure"
    //
    // given a probability p of "failing"on a given step,
    // expected number of steps to first failure is 1/p
    //
    public static int N;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int[] P = new int[N];
        
        for (int i = 0; i < N; i++) {
            P[i] = in.nextInt();
        }
        
        
        long denominator = numPermutations(P);
        
        // distinctValues and m are created from numPermutations
        long numerator = numSortedPermutations(P);
        
        ///////////RESUME HERE!!
        double ans = (double) denominator/numerator;
        
        System.out.printf("%.6f", ans);
    }
    
    public static class Number {
        int value;
        int occurrences;
        
        public Number(int n) {
            value = n;
            occurrences = 1;
        }
    }
    
    // save for calculating sorted permutations
    public static int distinctValues;
    public static int m; //product of the number of times each distinct value is repeated
    
    public static long numPermutations(int[] P) { // treats identical numbers as distinct.
        
        ArrayList<Number> repeats = new ArrayList<Number>();
        ArrayList<Integer> values = new ArrayList<Integer>();
        
        for (int i = 0; i < P.length; i++) {
            int n = P[i];
            if (values.contains(n)) {
                Iterator<Number> iterator = repeats.iterator();
                while (iterator.hasNext()) {
                    Number x = iterator.next();
                    if (x.value == n) {
                        x.occurrences++;
                        break;
                    }
                }
            }
            else {
                values.add(n);
                repeats.add(new Number(n));
            }
        }
        
        distinctValues = values.size();
        
        Iterator<Number> iterator = repeats.iterator();
        
        m = 1;
        
        while (iterator.hasNext()) {
            m *= factorial(iterator.next().occurrences);
        }
            
        //return P.length/m;
        return factorial(N);
    }
    
    //have distinctValues and m at your disposal...
    // and N
    public static long numSortedPermutations(int[] P) {
        return m;
    }
    
    public static long factorial(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
    
}