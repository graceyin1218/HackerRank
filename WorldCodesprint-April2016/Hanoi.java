import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] a;
    static int N;
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        a = new int[N];
        for(int a_i=0; a_i < N; a_i++){
            a[a_i] = in.nextInt();
        }
        
        solve();
    }
    
    public static void solve() {
        int ans = 0;
        for (int i = N-1; i >= 0; i--) {
            ans += get_to_pin_1(i);
        }
        System.out.println(ans);
    }
    
    public static int get_to_pin_1(int n) {
        
    }
}
