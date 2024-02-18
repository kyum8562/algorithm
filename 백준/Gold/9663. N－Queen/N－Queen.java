import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] map;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N];
        isVisited = new boolean[N];

        nQueen(0);
        System.out.println(ans);
    }

    static void nQueen(int depth) {
        if(depth == N) {
            ans++;
            return;
        }

        for(int i = 0 ; i < N ; i ++) {
            if(isVisited[i]) continue;
            map[depth] = i;
            if(isChecked(depth)) {
                isVisited[i] = true;
                nQueen(depth+1);
                isVisited[i] = false;
            }
        }
    }

    static boolean isChecked(int depth) {
        for(int i = 0 ; i < depth ; i ++) {
            if(map[depth] == map[i] || depth-i == Math.abs(map[depth] - map[i]))
                return false;
        }
        return true;
    }
}