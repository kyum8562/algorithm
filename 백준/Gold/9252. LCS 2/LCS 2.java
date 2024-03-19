import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        int arr1Len = s1.length();
        int arr2Len = s2.length();

        char[] arr1 = new char[arr1Len+1];
        char[] arr2 = new char[arr2Len+1];

        for(int i = 1 ; i <= arr1Len ; i ++)
            arr1[i] = s1.charAt(i-1);

        for(int i = 1 ; i <= arr2Len ; i ++)
            arr2[i] = s2.charAt(i-1);

        int[][] dp = new int[arr1Len+1][arr2Len+1];

        for(int i = 1 ; i <= arr1Len ; i ++){
            for(int j = 1 ; j <= arr2Len ; j ++){
                if(arr1[i] == arr2[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        sb.append(dp[arr1Len][arr2Len]).append("\n");

        int arr1Idx = arr1Len;
        int arr2Idx = arr2Len;
        Stack<Character> stack = new Stack<>();

        while(arr1Idx != 0 && arr2Idx != 0){

            if(dp[arr1Idx][arr2Idx] == dp[arr1Idx-1][arr2Idx])
                arr1Idx--;
            else if(dp[arr1Idx][arr2Idx] == dp[arr1Idx][arr2Idx-1])
                arr2Idx--;
            else{
                stack.push(arr1[arr1Idx]);
                arr1Idx--;
                arr2Idx--;
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb);
    }
}