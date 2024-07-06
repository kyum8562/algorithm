import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] dp = new int[s1Len+1][s2Len+1];

        int max = 0;
        for (int i = 1; i <= s1Len; i ++) {
            for(int j = 1 ; j <= s2Len ; j ++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}