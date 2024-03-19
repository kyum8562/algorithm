import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        char[] l1 = br.readLine().toCharArray();
        char[] l2 = br.readLine().toCharArray();

        // [위:0 아래:1 돌다리][두루마리][돌다리 길이]
        int[][][] dp = new int[2][t.length][l1.length];

        // 첫 시작 값 설정
        if(t[0] == l1[0]) dp[0][0][0] = 1;
        if(t[0] == l2[0]) dp[1][0][0] = 1;

        // 돌다리만큼 반복
        for(int i = 1 ; i < l1.length ; i ++){
            char currL1 = l1[i];
            char currL2 = l2[i];

            dp[0][0][i] = dp[0][0][i-1];
            dp[1][0][i] = dp[1][0][i-1];

            if(currL1 == t[0]) dp[0][0][i]++;
            if(currL2 == t[0]) dp[1][0][i]++;

            // 두루마리 길이만큼 반복
            for(int j = 1 ; j < t.length ; j ++){
                dp[0][j][i] += dp[0][j][i-1];
                dp[1][j][i] += dp[1][j][i-1];

                if(currL1 == t[j]) dp[0][j][i] += dp[1][j-1][i-1];
                if(currL2 == t[j]) dp[1][j][i] += dp[0][j-1][i-1];
            }
        }

        System.out.println(dp[0][t.length-1][l1.length-1] + dp[1][t.length-1][l1.length-1]);
    }
}