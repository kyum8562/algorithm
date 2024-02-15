import java.io.*;
import java.util.*;

// 중복 조합(주어진 배열), 사전 순
public class Main {
    static int N, M;
    static int[] map, choice;
//    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N];
        choice = new int[M];
//        v = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(map);

        comb(0, 0);

        System.out.println(sb);
    }

    private static void comb(int depth, int start) {
        if(depth == M){
            for(int i = 0 ; i < M ; i ++)
                sb.append(choice[i]).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = start ; i < N ; i ++){
//            if(v[i]) continue;
//            v[i] = true;
            choice[depth] = map[i];
            comb(depth+1, i);
//            v[i] = false;
        }
    }
}