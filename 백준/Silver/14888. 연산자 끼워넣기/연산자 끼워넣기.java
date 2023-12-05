import java.io.*;
import java.util.*;

public class Main {
    static int N, gihoCnt = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] map, giho, choice;
    static boolean[] v;
    static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        giho = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i ++){
            giho[i] = Integer.parseInt(st.nextToken());
            gihoCnt += giho[i];
        }
        choice = new int[gihoCnt];
        v = new boolean[gihoCnt];
        perm(0);
        System.out.println(max);
        System.out.println(min);
    }

    private static void perm(int depth) {
        if(depth == gihoCnt){
            int res = calculating();
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
        for(int i = 0 ; i < 4 ; i ++){
            if(giho[i] == 0) continue;
            giho[i] --;
            choice[depth] = i;
            perm(depth+1);
            giho[i] ++;
        }
    }

    private static int calculating() {
        int res = map[0];
        for(int i = 1 ; i < N ; i ++){
            int curGiho = choice[i-1];
            if(curGiho == 0) res += map[i];
            else if(curGiho == 1) res -= map[i];
            else if(curGiho == 2) res *= map[i];
            else res /= map[i];
        }
        return res;
    }
}