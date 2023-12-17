import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] v = new boolean[2000000+10];
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        int ans = 1;
        while(v[ans]) ans++;
        System.out.println(ans);
    }

    private static void dfs(int depth, int sum) {
        if(depth == N){
            v[sum] = true;
        }
        else{
            dfs(depth+1, sum+map[depth]);
            dfs(depth+1, sum);
        }
    }
}