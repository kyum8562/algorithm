import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] tSortDegree, times, ans;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tSortDegree = new int[N + 1]; // 진입 차수가 담긴 배열
        list = new ArrayList[N + 1]; // 리스트 배열
        times = new int[N + 1]; // 건물별 시간이 담긴 배열

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            while(true){
                int num = Integer.parseInt(st.nextToken());

                if(num == -1) break;

                list[num].add(i);
                tSortDegree[i]++;
            }
        }

        topologySort();
        
        for (int i = 1; i <= N; i++) 
            sb.append(times[i] + ans[i]).append("\n");
        
        System.out.println(sb);
    }

    private static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();
        ans = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (tSortDegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                ans[next] = Math.max(ans[cur] + times[cur], ans[next]);
                if (--tSortDegree[next] == 0) q.offer(next);
            }
        }
    }
}