import java.io.*;
import java.util.*;

class Main {
    static int daysInMonth, daysInWeek;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] arr = new int[367];

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.offer(new Node(a, b));
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(int i = cur.s ; i <= cur.e ; i ++){
                arr[i] ++;
            }
        }

        int mark = 0;
        int height = 1;
        int ans = 0;
        for(int i = 1 ; i <= 366 ; i ++){
            // 없는 칸일 경우
            if(arr[i] == 0){
                if(mark == 0) continue;

                ans += (i - mark) * height;

                height = 1; // 초기화
                mark = 0; // 마킹 해제
            }
            // 마킹 안되어있을 경우
            else if(mark == 0) mark = i;
            // 마킹 되어있을 경우
            else{
                height = Math.max(height, arr[i]);
            }
        }

        System.out.println(ans);
    }
    static class Node implements Comparable<Node>{
        int s, e;
        public Node(int s, int e){
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Node o){
            if(this.s == o.s)
                return o.e - this.e;
            else
                return this.s - o.s;
        }
    }
}