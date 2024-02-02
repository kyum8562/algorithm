import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        int max = Integer.MIN_VALUE;

        for(int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]); // max 값 저장
        }

        System.out.println(binarySearch(max));
    }

    private static long binarySearch(int max) {
        long s = 1;
        long e = max;
        long m = 0; // 나눌 막걸리량(ml) 선정
        long ans = 0;

        while(e >= s){
            m = (s + e) / 2;

            long res = 0;

            for(int i = 1 ; i <= N ; i ++)
                res += arr[i] / m;

            if(res >= M){
                s = m + 1;
                ans = m;
            }
            else e = m - 1;
        }
        return ans;
    }
}