import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static List<int[]>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        System.out.println(dijkstra(1));
        System.out.println(sb);
    }

    private static int dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] dist = new int[N + 1];
        int[] ans = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        pq.offer(new int[]{s, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] > dist[cur[0]]) continue;

            for (int[] next : list[cur[0]]) {
                if (dist[next[0]] > dist[cur[0]] + next[1]) {
                    dist[next[0]] = dist[cur[0]] + next[1];
//                    System.out.println(cur[0] + " " + next[0]);
                    ans[next[0]] = cur[0];
                    pq.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (ans[i] == 0) continue;
            cnt++;
            sb.append(i + " " + ans[i]).append("\n");
        }
        return cnt;
    }
}