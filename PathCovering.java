import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static Scanner in;
    static int[][] matrix;
    static int n;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        in = new Scanner(System.in);
        n = in.nextInt();
        
        matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            matrix[x-1][y-1] = 1;
            matrix[y-1][x-1] = 1;
        }
        
        int q = in.nextInt();
        
        for (int i = 0; i < q; i++) {
            solve();
        }
        
    }
    static ArrayList<Integer> subset;
    public static void solve() {
        int x = in.nextInt();
        subset = new ArrayList<Integer>();
        for (int i = 0; i < x; i++) {
            subset.add(in.nextInt()); 
        }
        
        // start from the first city in the subset, 
        // try to get to as many cities in the subset as possible.
        //    record that path, and try to find how many paths it takes
        //    to cover the remaining cities.
        
        
        //find the path that covers the most cities in the subset
        // record that, then repeat the process on the untouched cities.
        System.out.println(search());
        
    }
    
    
    
    static Stack<Integer> visited = new Stack<Integer>();
    static int tempCount;
    static int maxCount;
    static String maxPath;
    static String tempPath;
    
    
    public static int search() {
        
        int answer = 0;
        
        while (subset.size() > 0) {
            if (subset.size() == 1) return answer;
            if (subset.size() == 2) return answer+1; 
            
            tempCount = 0;
            maxCount = 0;
            tempPath = "";
            maxPath = "";
            
            findLongestPath();
            
            for (int i = 0; i < maxPath.length(); i++) {
                subset.remove(new Integer(Integer.parseInt("" + maxPath.charAt(i))));
            }
            answer++;
        }
        
        return answer;
    }
    
    //finds the path that covers the most cities from the subset
    public static void findLongestPath() {
        boolean isEnd = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                isEnd = false;
                
                visited.push(i);
                
                if (subset.contains(i)) {
                    tempCount++;
                    tempPath = tempPath.concat("" + i);
                    
                    findLongestPath();
                    
                    tempPath = tempPath.substring(0, tempPath.length()-1);
                    tempCount--;
                } 
                else {
                    findLongestPath();
                }
                
                visited.pop();
            }
            
        }
        if (isEnd) {
            if (tempCount > maxCount) {
                maxCount = tempCount;
                maxPath = tempPath;
            }
            return;
        }
    }
}