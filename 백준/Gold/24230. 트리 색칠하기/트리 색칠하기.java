import java.io.*;
import java.util.*;

public class Main {
    static int ans;
    static List<Integer>[] list;
    static int[] arr, goal;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ans = 0;

        arr = new int[N + 1];
        goal = new int[N + 1];
        list = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
            goal[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1, 0);

        System.out.print(ans);
    }

    private static void dfs(int cur, int prev) {
        // 목표 값이 들어있지 않다면
        if(arr[cur] != goal[cur]) {

            // 이전 값이 목표 값과 동일하다면(이미 정상적으로 색칠이 된 경우)
            if (arr[prev] == goal[cur]) {
                arr[cur] = arr[prev];
            }
            // 새로운 색으로 칠해줘야 할 경우
            else {
                arr[cur] = goal[cur];
                ans++;
            }
        }

        for(int next: list[cur]){
            if(next == prev) continue;
            dfs(next, cur);
        }
    }
    static class Node{
        int n, d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
    }
}