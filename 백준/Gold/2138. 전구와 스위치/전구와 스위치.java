import java.io.*;
import java.util.*;

class Main {
    static final int INF = 1 << 30;
    static int N, ans;
    static char[] tgt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ans = INF;

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = Arrays.copyOf(s1, N);
        tgt = br.readLine().toCharArray();

        dfs(1, 0, s1);
        dfs(1, 1, changeVal(0, s2));

        System.out.println(ans == INF ? -1 : ans);
    }

    private static void dfs(int idx, int cnt, char[] arr) {
        if(idx == N){
            if(arr[idx-1] == tgt[idx-1])
                ans = Math.min(ans, cnt);
            return;
        }

        if(arr[idx-1] == tgt[idx-1])
            dfs(idx+1, cnt, arr);
        else
            dfs(idx+1, cnt+1, changeVal(idx, arr));
    }

    private static char[] changeVal(int idx, char[] arr) {
        for(int i = idx-1 ; i <= idx + 1 ; i ++){
            if(i >= 0 && N > i)
                arr[i] = (arr[i] == '0') ? '1' : '0';
        }

        return arr;
    }
}