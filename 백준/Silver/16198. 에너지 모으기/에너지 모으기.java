import java.io.*;
import java.util.*;

public class Main {
    static int N, ans=0;
    static boolean[] v;
    static int[] map;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        v = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int depth, int sum) {
        if(depth == N-2){
            ans = Math.max(ans, sum);
            return;
        }

        for(int i = 1 ; i < N-1 ; i ++){
            if(v[i]) continue;
            v[i] = true;

            int tmp = 1;
            for(int j = i-1 ; j >= 0 ; j --){
                if(v[j]) continue;
                tmp = map[j];
                break;
            }
            for(int j = i+1 ; j < N ; j ++){
                if(v[j]) continue;
                tmp *= map[j];
                break;
            }

            dfs(depth+1, sum+tmp);
            v[i] = false;
        }
    }
}