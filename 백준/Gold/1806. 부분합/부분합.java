import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        int ans = INF, s = 0, e = 0;
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i ++)
            arr[i] = Long.parseLong(st.nextToken());

        while(true) {
            if(sum >= S) {
                int tmp = e-s;
                sum -= arr[s++];
                if(ans > tmp) ans = tmp;
            }
            else if(N == e) break;
            else sum += arr[e++];
        }
        System.out.println(ans == INF ? 0 : ans);
    }
}