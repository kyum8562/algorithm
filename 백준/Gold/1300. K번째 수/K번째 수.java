import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine()); // 최대 10억

        int s = 1;
        int e = K;
        int m = 0;
        while(e > s){
            m = (s + e) / 2; // 몇번째 수 인지

            long cnt = 0;
            for(int i = 1 ; i <= N ; i ++){
                cnt += Math.min(N, m/i);
            }

            // 타겟이 더 높음
            if(cnt >= K) e = m;
            else s = m + 1;
        }
        System.out.println(s);
    }
}