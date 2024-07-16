import java.io.*;
import java.util.*;

public class Main {
    static int R, C, H, W;
    static int[][] arr, prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[R+1][C+1];
        prefixSum = new int[R+1][C+1];

        int max = 0;
        int min = 1 << 30;

        for(int i = 1 ; i <= R ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= C ; j ++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = tmp;

                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }
        }

        System.out.println(bs(min, max));
    }

    private static int bs(int s, int e) {
        int m, ans = 0;

        while(e >= s){
            // mid 값
            m = (s + e) / 2;

            // 누적합 생성
            setPrefixSum(m);

            // 2차원 누적합 (H,W)~(R,C) 범위에서 0개수 찾기
            int[] cnt = getZero();

            if(cnt[0] > 0){
                e = m - 1;
                ans = m;
            }
            else{
                if(cnt[1] > 0)
                    e = m - 1;
                else
                    s = m + 1;
            }
        }

        return ans;
    }

    private static int[] getZero() {
        int tmp, cnt = 0, cnt2= 0;
        for (int i = H; i <= R; i ++) {
            for (int j = W; j <= C; j ++) {
                // 2차원 배열에서의 누적합
                tmp = prefixSum[i][j] - prefixSum[i - H][j] - prefixSum[i][j - W] + prefixSum[i - H][j - W];

                if (tmp == 0) cnt ++;
                else if(tmp > 0) cnt2 ++;
            }
        }

        return new int[]{cnt, cnt2};
    }

    private static void setPrefixSum(int m) {
        for (int i = 1; i <= R; i ++) {
            for (int j = 1; j <= C; j ++) {

                if (m > arr[i][j])
                    prefixSum[i][j] = 1;
                else if (arr[i][j] > m)
                    prefixSum[i][j] = -1;
                else
                    prefixSum[i][j] = 0;
            }

            for (int j = 1; j <= C; j ++)
                prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
        }
    }
}