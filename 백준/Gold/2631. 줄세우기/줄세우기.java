import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i = 0 ; i < N ; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < i ; j ++){
                if(arr[j] >= arr[i]) continue;

                dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.println(N - ans - 1);
    }
}