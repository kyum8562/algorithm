import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map, choice;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            map = new int[N];
            choice = new int[6];

            for(int i = 0 ; i < N ; i ++)
                map[i] = Integer.parseInt(st.nextToken());

            comb(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void comb(int depth, int start) {
        if(depth == 6){
            for(int i = 0 ; i < 6 ; i ++)
                sb.append(choice[i]).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            choice[depth] = map[i];
            comb(depth+1, i+1);
        }
    }
}