import java.io.*;
import java.util.*;

class Main {
    static int statNum, ans;
    static int[] arr;
    static boolean[] v;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ans = 0;

        arr = new int[N+1];

        for (int i = 1; i <= N; i ++)
            arr[i] = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= N ; i ++){
            v = new boolean[N+1];

            statNum = i;
            dfs(i);
        }

        sb.append(pq.size()).append("\n");

        while(!pq.isEmpty())
            sb.append(pq.poll()).append("\n");

        System.out.print(sb);
    }

    private static void dfs(int cur) {
        if(v[cur]) return;

        if(statNum == arr[cur]){
            pq.offer(statNum);
            ans ++;
        }


        v[cur] = true;

        dfs(arr[cur]);
    }
}