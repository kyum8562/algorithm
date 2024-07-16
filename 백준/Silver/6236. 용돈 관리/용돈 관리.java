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
            // 인출금액
            m = (s + e) / 2;

            // 인출금액 바탕으로 몇번 뽑아야 하는지
            int cnt = getCnt(m);

            // 뽑는 개수가 M보다 클 경우 => 금액을 높여야 함(그래야 현재보다 덜뽑을테니)
            if(cnt > M) s = m + 1;
            // M이 뽑는 개수보다 크거나 같을 경우 => 정답군에 포함 & 금액을 낮추면서 최적값(최소금액) 찾기
            else{
                e = m - 1;
                ans = m;
            }
        }

        return ans;
    }

    private static int getCnt(int val) {
        int sum = val; // 인출한 금액
        int cnt = 1; // 몇번 뽑았는지

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