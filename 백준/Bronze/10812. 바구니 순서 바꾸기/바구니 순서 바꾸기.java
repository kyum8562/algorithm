import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] map;
    static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1];
        for(int i = 1 ; i <= N ; i ++)
            map[i] = i;

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sorting(s, e, m);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i ++)
            sb.append(map[i]).append(" ");

        System.out.println(sb);
    }

    private static void sorting(int s, int e, int m) {
        int[] tmp = new int[N+1];
        int idx = s;
        for(int i = m; i <= e ; i ++) tmp[idx++] = map[i];
        for(int i = s; i < m ; i ++) tmp[idx++] = map[i];
        for(int i = 1 ; i <= N ; i ++){
            if(tmp[i] != 0) map[i] = tmp[i];
        }
    }
}