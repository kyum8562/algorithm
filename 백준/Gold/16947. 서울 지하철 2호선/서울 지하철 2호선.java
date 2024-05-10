import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] ans;
    static boolean[] v;
    static List<Integer>[] list;
    static Queue<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ans = new int[N+1];
        list = new ArrayList[N+1];

        Arrays.fill(ans, -1);

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // 사이클 체크
        for(int i = 1 ; i <= N ; i ++){
            v = new boolean[N+1];
            cycleCheck(i, 1, i);
        }

        bfs();

        for(int i = 1 ; i <= N ; i ++)
            sb.append(ans[i]).append(" ");

        System.out.print(sb);
    }

    private static void cycleCheck(int cur, int cnt, int start) {
        // 방문
        v[cur] = true;

        for(int next: list[cur]){
            // 다음노드를 방문하지 않았다면
            if(!v[next]) cycleCheck(next, cnt+1, start);
            // 다음노드를 방문했다면
            else if(next == start && cnt >= 3){
                // 사이클 표시
                ans[next] = 0;
                q.offer(next);
                return;
            }
        }
    }

    private static void bfs() {

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next: list[cur]){
                // 사이클이 아닌 노드라면
                if(ans[next] == -1){
                    ans[next] = ans[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}