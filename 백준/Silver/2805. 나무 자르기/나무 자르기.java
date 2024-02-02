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

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]); // max 값 저장
        }

        System.out.println(binarySearch(max));
    }

    private static int binarySearch(int max) {
        int s = 0;
        int e = max;
        int m = 0; // 자를 나무의 높이 선정

        while(e >= s){
            m = (s + e) / 2;

            long res = 0;
            long cnt = 0;
            for(int i = 1 ; i <= N ; i ++){
                if(arr[i] > m){
                    res += arr[i];
                    cnt ++;
                }
            }
            res -= cnt * m;

            if(res >= M) s = m + 1;
            else e = m - 1;
        }
        return e;
    }
}