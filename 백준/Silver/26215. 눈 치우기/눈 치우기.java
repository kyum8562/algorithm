import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            pq.offer(Integer.parseInt(st.nextToken()));

        int time = 0;

        while(pq.size() > 1){
            time++;

            int a = pq.poll() - 1;
            int b = pq.poll() - 1;

            if(a > 0) pq.offer(a);
            if(b > 0) pq.offer(b);

        }

        if(pq.size() == 1)
            time += pq.poll();

        System.out.println(time > 1440 ? -1 : time);

    }

    static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}