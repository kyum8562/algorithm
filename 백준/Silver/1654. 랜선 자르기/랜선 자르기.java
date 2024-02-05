import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[N];
        long max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i ++){
            map[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, map[i]);
        }

        long s = 1;
        long e = max+1;
        long m = 0;
        while(e > s){
            m = (s + e) / 2; // 몇번째 수 인지

            long cnt = 0;
            for(int i = 0 ; i < N ; i ++)
                cnt += map[i] / m;

            // 타겟이 더 높음
            if(cnt >= K) s = m + 1;
            else e = m;
        }
        System.out.println(s-1);
    }
}