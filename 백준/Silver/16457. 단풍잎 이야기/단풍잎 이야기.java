import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, ans;
    static int[] choice;
    static int[][] quest;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        v = new boolean[2*N+1];
        choice = new int[N];
        quest = new int[M][K];
        ans = Integer.MIN_VALUE;

        // 퀘스트 목록
        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++)
                quest[i][j] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);

        System.out.println(ans);
    }

    private static void comb(int depth, int start) {
        if(depth == N){
            int sum = 0;
            for(int i = 0 ; i < M ; i ++){
                int cnt = 0;
                for (int j = 0; j < K; j++)
                    if(v[quest[i][j]]) cnt ++;

                if(cnt == K) sum ++;
            }

            ans = Math.max(ans, sum);
            return;
        }

        for(int i = start ; i <= 2*N ; i ++){
            v[i] = true;
            comb(depth+1, i+1);
            v[i] = false;
        }
    }
}