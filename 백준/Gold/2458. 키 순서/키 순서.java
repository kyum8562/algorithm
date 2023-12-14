import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static List<Integer>[] list, list2;
    /**
     * 플로이드 워셜: 1~N 번 지점에서 시작항 최단 거리를 찾는 알고리즘
     */
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        list2 = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        int[] res = new int[N+1];
        long[][] dist = new long[N+1][N+1];
        long[][] dist2 = new long[N+1][N+1];
        for(int K = 1; K <= N; ++K) {
            for(int start = 1; start <= N; ++start) {
                dist[K][start] = K == start ? 0 : Integer.MAX_VALUE;
                dist2[K][start] = K == start ? 0 : Integer.MAX_VALUE;
            }
        }

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

//            list[a].add(b);
//            list2[b].add(a);
            dist[a][b] = 1;
            dist2[b][a] = 1;
        }
        for(int k = 1 ; k <= N ; k ++){
            for(int i = 1 ; i <= N ; i ++){
                for(int j = 1 ; j <= N ; j ++){
                    if(i == j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        for(int k = 1 ; k <= N ; k ++){
            for(int i = 1 ; i <= N ; i ++){
                for(int j = 1 ; j <= N ; j ++){
                    if(i == j) continue;
                    dist2[i][j] = Math.min(dist2[i][j], dist2[i][k]+dist2[k][j]);
                }
            }
        }
        int ans = 0;
        for(int i = 1 ; i <= N ; i ++) {
            for (int j = 1; j <= N; j++) {
                if(dist[i][j] != Integer.MAX_VALUE) res[i]++;
                if(dist2[i][j] != Integer.MAX_VALUE) res[i]++;
            }
            if(res[i] == N+1) ans++;
        }

        System.out.println(ans);

    }
}