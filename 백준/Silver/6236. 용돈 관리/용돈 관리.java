import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int max = 0;
        int sum = 0;
        arr = new int[N];

        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(br.readLine());
            arr[i] = tmp;
            sum += tmp;
            max = Math.max(max, tmp);
        }

        System.out.println(bs(max, sum));
    }

    private static int bs(int max, int sum) {
        int s = max;
        int e = sum;
        int m;
        int ans = 0;

        while(e >= s){
            m = (s + e) / 2;

            int cnt = getCnt(m);

            if(cnt > M) s = m + 1;
            else{
                e = m - 1;
                ans = m;
            }
        }

        return ans;
    }

    private static int getCnt(int val) {
        int sum = val;
        int cnt = 1;

        for(int i = 0 ; i < N ; i ++){
            sum -= arr[i];

            if(sum < 0){
                sum = val - arr[i];
                cnt ++;
            }
        }

        return cnt;
    }
}