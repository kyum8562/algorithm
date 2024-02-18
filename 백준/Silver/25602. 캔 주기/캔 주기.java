import java.io.*;
import java.util.*;

public class Main {
    static int N, K, max;
    static int[] canCnt, choice;
    static int[][] cat1, cat2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 캔의 종류
        K = Integer.parseInt(st.nextToken()); // K일
        max = Integer.MIN_VALUE; // 만족도 합의 최댓값

        canCnt = new int[N]; // 각 캔의 수 저장
        choice = new int[K*2]; // 매일 어떤 캔을 선택했는지 저장

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            canCnt[i] = Integer.parseInt(st.nextToken());

        cat1 = new int[K][N];
        for (int i = 0 ; i < K ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cat2 = new int[K][N];
        for (int i = 0 ; i < K ; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cat2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);

        System.out.println(max);
    }

    private static void perm(int depth) {
        if(depth == K*2){
            int sum = 0;
            for(int i = 0 ; i < K*2 ; i ++){
                int cur = choice[i];
                if(i >= 0 && i < K)
                    sum += cat1[i][cur];
                else
                    sum += cat2[i-K][cur];
            }

            max = Math.max(max, sum);
            return;
        }

        for(int i = 0 ; i < N ; i ++){
            if(canCnt[i] == 0) continue;
            canCnt[i] --;
            choice[depth] = i;
            perm(depth+1);
            canCnt[i] ++;
        }
    }
}