import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        solve(x1, v1, x2, v2);
    }
    
    public static void solve(int x1, int v1, int x2, int v2) {
        
        //if obvious:
        if (x1 > x2 && v1 > v2) {
            System.out.print("NO");
            return;
        }
        if (x2 > x1 && v2 > v1) {
            System.out.print("NO");
            return;
        }
        
        // Here we are guaranteed that the kangaroos will intersect at a positive time. 
        // need to check that it is an integer time.
        
        int jumps = (int)((double)(x2-x1)/(double)(v1-v2));
        int pos1 = x1+v1*jumps;
        int pos2 = x2+v2*jumps;
        
        if (pos1 == pos2) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
        return;
        
        
    }
}
