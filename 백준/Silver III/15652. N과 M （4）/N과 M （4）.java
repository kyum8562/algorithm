import java.io.*;
import java.util.*;

// 중복 조합, 사전 순
public class Main {
    static int N, M;
    static int[] map;
//    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M];
//        v = new boolean[N];

        comb(0, 0);

        System.out.println(sb);
    }

    private static void comb(int depth, int start) {
        if(depth == M){
            for(int i = 0 ; i < M ; i ++)
                sb.append(map[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = start ; i < N ; i ++){
//            if(v[i]) continue;
//            v[i] = true;
            map[depth] = i+1;
            comb(depth+1, i);
//            v[i] = false;
        }
    }
}