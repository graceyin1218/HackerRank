import java.io.*;
import java.util.*;

public class Solution {
    
    public static int[][] matrix;
    public static boolean[][] visited;
    public static int m;
    public static int n;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        
        matrix = new int[m][n];
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        
        
        
        //solve
        
        int maxSize = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                
                if (matrix[i][j] == 0) {
                    visited[i][j] = true;
                    continue;
                }
                
                int x = sizeFromSeed(i, j);
                if (x > maxSize) maxSize = x;
            }
        }
        
        System.out.println(maxSize);
        
    }
    
    public static int count;
    public static int sizeFromSeed(int i, int j) {
        count = 0;
        
        search(i,j);
        
        return count;
        
    }
    
    public static void search(int i, int j) {
        
        if (i >= m) return;
        if (j >= n) return;
        if (i < 0 || j < 0) return;
        
        if (matrix[i][j] == 0) return;
        
        if (visited[i][j]) return;
        
        count++;
        visited[i][j] = true;
        
        search(i+1, j);
        search(i+1, j-1);
        search(i+1, j+1);
        search(i, j+1);
        search(i, j-1);
        search(i-1, j);
        search(i-1, j+1);
        search(i-1, j-1);
        
        return;
    }
    
}
