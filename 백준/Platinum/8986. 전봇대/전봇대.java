import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long min, sum = 0;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        min = Long.MAX_VALUE;

        map = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
            sum += map[i];
        }

        TernarySearch();

        System.out.println(min);
    }

    private static void TernarySearch() {
        long l = 0;
        long r = map[N-1];
        long m1 = 0;
        long m2 = 0;
        while(r - l >= 3){
            m1 = (l*2 + r)/3;
            m2 = (r*2 + l)/3;

            long res1 = cal2(m1);
            long res2 = cal2(m2);

            if(res1 > res2) l = m1;
            else r = m2;
        }

        // 잔여 구간 탐색하기
        for(long i = l ; i <= r ; i ++)
            min = Math.min(min, cal2(i));
    }

    private static long cal2(long num) {
        long res = 0;
        for (int i = 1; i < N; i++)
            res += Math.abs(num*i - map[i]);
        return res;
    }
}