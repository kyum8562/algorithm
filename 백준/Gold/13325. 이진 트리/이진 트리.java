import java.io.*;
import java.util.*;

public class Main {
    static int N, K, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, (K+1));
        ans = 0;

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 2 ; i < N ; i ++)
            arr[i] = Integer.parseInt(st.nextToken());

        recur(1, 0);
        System.out.println(ans);
    }

    private static int recur(int cur, int depth) {
        if(depth == K){
            ans += arr[cur];
            return arr[cur];
        }

        int left = recur(cur*2, depth+1);
        int right = recur(cur*2+1, depth+1);

        ans += arr[cur] + Math.abs(left - right);
        return arr[cur] + Math.max(left, right);
    }
}