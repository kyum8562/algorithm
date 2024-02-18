import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N];

        nQueen(0);
        System.out.println(ans);
    }

    static void nQueen(int depth) {
        if(depth == N) {
            ans++;
            return;
        }

        for(int i = 0 ; i < N ; i ++) {
            map[depth] = i;
            if(isChecked(depth))
                nQueen(depth+1);
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