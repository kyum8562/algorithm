import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 위상정렬 문제
 * 2252 줄세우기 - 기본
 * 2623 음악프로그램 - 기본
 * 1766 문제집 - 기본 + 우선순위큐
 * 1005 ACM Craft -
 * 3665 최종 순위 - 기본 + 간선 생성하기
 */
public class Main {
    static int N, M;
    static int[] tSortDegree, arr, ans;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            tSortDegree = new int[N + 1];
            list = new ArrayList[N + 1];
            arr = new int[N + 1];
            ans = new int[N + 1];
            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

            // 입력 받은 작년 순위를 arr에 저장한다
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // 본인 노드 이하의 순위는 다 간선을 연결해준다
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                tSortDegree[b]++;
            }

            int target = Integer.parseInt(br.readLine());

            topologySort(target);
        }
    }

    private static void topologySort(int tgt) {
        Queue<Integer> q = new ArrayDeque<>();

        // 진출 차수가 0인 경우를 q에 모두 담아줌
        for (int i = 1; i <= N; i++){
            ans[i] = arr[i];
            if (tSortDegree[i] == 0) q.offer(i);
        }


        // 큐에 아무것도 없을때 까지 반복
        while (!q.isEmpty()) {
            int curr = q.poll();

            // 해당 노드에서 진출하는 노드들을 탐색하고, 해당 노드의 진입차수를 1 감소시킴
            for (int next : list[curr]) {
                ans[next] = Math.max(ans[curr] + arr[next], ans[next]);
                if (--tSortDegree[next] == 0) q.offer(next);
            }
        }

            System.out.println(ans[tgt]);
    }
}