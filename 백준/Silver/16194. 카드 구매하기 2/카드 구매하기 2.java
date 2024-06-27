import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1]; // i개를 구매하는데 드는 최소비용이 저장되는 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i]; // i개를 구매하는데 드는 비용 초기화
        }

        int tmp = recur(0);
        System.out.println(tmp);
    }

    private static int recur(int depth) {
        if(depth > N) return 1 << 30;
        if(depth == N) return 0;

        if(dp[depth] != arr[depth]) return dp[depth];

        int ret = 1 << 30;
        for(int i = 1 ; i <= N ; i ++){
            ret = Math.min(ret, recur(depth+i) + arr[i]);
        }

        return dp[depth] = ret;
    }
}
