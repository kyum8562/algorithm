import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        List<Integer> macList = new ArrayList<>();
        List<Integer> starList = new ArrayList<>();
        int[] macDist = new int[N+1];
        int[] starDist = new int[N+1];

        Arrays.fill(macDist, 1 << 30);
        Arrays.fill(starDist, 1 << 30);

        for(int i = 1 ; i <= N ; i ++)
            list[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, d));
            list[b].add(new Node(a, d));
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int macSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < a ; i ++)
            macList.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int starSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < b ; i ++)
            starList.add(Integer.parseInt(st.nextToken()));

        dijkstra(macList, macDist);
        dijkstra(starList, starDist);

        int ans = 1 << 30;
        for(int i = 1 ; i <= N ; i ++){
            if(macDist[i] == 0 || starDist[i] == 0) continue;
            if(macDist[i] > macSize || starDist[i] > starSize) continue;

            ans = Math.min(ans, macDist[i] + starDist[i]);
        }

        if(ans == 1 << 30) System.out.println(-1);
        else System.out.println(ans);
    }
    static void dijkstra(List<Integer> localList, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int listSize = localList.size();
        for(int i = 0 ; i < listSize ; i ++){
            pq.offer(new Node(localList.get(i), 0));
            dist[localList.get(i)] = 0;
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.d > dist[cur.n]) continue;

            for(Node next: list[cur.n]){
                if(dist[next.n] > dist[cur.n] + next.d){
                    dist[next.n] = dist[cur.n] + next.d;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }

    }
    static class Node implements Comparable<Node>{
        int n, d;
        public Node(int n, int d){
            this.n = n;
            this.d = d;
        }
        @Override
        public int compareTo(Node o){
            return this.d - o.d;
        }
    }
}
