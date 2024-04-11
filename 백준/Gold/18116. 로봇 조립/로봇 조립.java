import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parents, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        parents = new int[1000001];
        cnt = new int[1000001];

        // parents 배열 초기화
        makeSet();

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int a = Integer.parseInt(st.nextToken());

            // union
            if(type.equals("I")){
                int b = Integer.parseInt(st.nextToken());

                union(Math.min(a, b), Math.max(a, b));
            }
            // print
            else sb.append(cnt[find(a)]).append("\n");
        }

        System.out.print(sb);
    }

    private static void makeSet() {
        for(int i = 0 ; i <= 1000000 ; i ++){
            parents[i] = i;
            cnt[i] = 1;
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y){
            cnt[x] += cnt[y];
            parents[parents[y]] = x;
        }
    }

    private static int find(int x) {
        if(x == parents[x]) return x;
        else return parents[x] = find(parents[x]);
    }
}