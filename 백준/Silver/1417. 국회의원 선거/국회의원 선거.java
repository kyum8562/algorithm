import java.io.*;
import java.util.*;
class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int my = Integer.parseInt(br.readLine());
        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i = 0 ; i < N-1 ; i ++)
            pq.offer(Integer.parseInt(br.readLine()));

        if(N != 1) {
            while (true) {
                int cur = pq.poll();
                if (my > cur) break;

                ans++;
                my++;

                pq.offer(cur - 1);
            }
        }

        System.out.println(ans);
    }
}