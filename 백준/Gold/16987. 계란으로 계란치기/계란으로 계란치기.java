import java.io.*;
import java.util.*;

public class Main {
    static int N, ans = 0;
    static int[] D, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        D = new int[N];
        W = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            D[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        game(0, 0);
        System.out.println(ans);
    }

    private static void game(int depth, int cnt) {
        if(depth == N){
            ans = Math.max(ans, cnt);
            return;
        }

        if(D[depth] <= 0 || cnt == N-1){
            game(depth+1, cnt);
            return;
        }

        int reCallCnt = cnt;
        for(int i = 0 ; i < N ; i ++){
            if(i == depth || D[i] <= 0) continue;
            hitEgg(depth, i);
            if(D[depth] <= 0) cnt++;
            if(D[i] <= 0) cnt++;
            game(depth+1, cnt);
            recoveryEgg(depth, i);
            cnt = reCallCnt;
        }
    }

    private static void recoveryEgg(int a, int b) {
        D[b] += W[a];
        D[a] += W[b];
    }
    private static void hitEgg(int a, int b) {
        D[b] -= W[a];
        D[a] -= W[b];
    }
}