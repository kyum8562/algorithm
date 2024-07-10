import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            max = Math.max(max, tmp);
        }

        System.out.print(bs(0, max, M));
    }

    private static int bs(int s, int e, int tgt) {
        int m, ans = 0;

        while(e >= s){
            m = (s + e) / 2;

            // m 일때의 결과 값
            long res = getResult(m);

            // 타겟값보다 크거나 같을 경우
            if(res >= tgt){
                s = m + 1;
                ans = m;
            }
            else e = m - 1;
        }

        return ans;
    }

    private static long getResult(int m) {
        long sum = 0L;
        long cnt = 0;
        for(int i = 0 ; i < N ; i ++){
            if(arr[i] > m){
                sum += arr[i];
                cnt ++;
            }
        }

        return sum - (cnt * m);
    }
}