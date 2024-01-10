import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        System.out.println(bfs(S, E));
    }

    private static int bfs(int s, int e) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{s, 1});
        while(!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0] == e) return curr[1];

            for(int d = 0 ; d < 2 ; d ++){
                long next = curr[0];
                if(d == 0) next *= 2;
                else next = Long.parseLong(next+""+1);

                if(next > e) continue;
                q.offer(new int[]{(int)next, curr[1]+1});
            }
        }
        return -1;
    }
}