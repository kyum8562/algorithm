import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[][] dice;
    static int[] pair = {5, 3, 4, 1, 2, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 6 ; j ++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < 6 ; i ++){
            // 옆면 중 가장 큰 값
            int max = -1;
            for(int j = 0 ; j < 6 ; j ++){
                if(i == j || i == pair[j]) continue;

                max = Math.max(max, dice[0][j]);
            }

            // 윗면이 i일 때의 최댓값 찾기
            recur(dice[0][i], max, 1);
        }

        System.out.println(ans);
    }

    private static void recur(int val, int sum, int cnt) {
        if(cnt == N){
            ans = Math.max(ans, sum);
            return;
        }

        int idx = -1;
        for(int i = 0 ; i < 6 ; i ++){
            if(val == dice[cnt][i]){
                idx = i;
                break;
            }
        }

        int next = pair[idx];
        int max = 0;
        for(int i = 0 ; i < 6 ; i ++){
            if(i == next || i == idx) continue;

            max = Math.max(max, dice[cnt][i]);
        }

        recur(dice[cnt][next], sum+max, cnt+1);
    }
}