import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        Collections.sort(list);

        int ans = 0;
        for(Node cur: list){
            int x = cur.x;
            int y = cur.y;

            if(!binarySearch(x+A, y)) continue;
            if(!binarySearch(x, y+B)) continue;
            if(!binarySearch(x+A, y+B)) continue;

            ans++;
        }

        System.out.println(ans);
    }

    private static boolean binarySearch(int x, int y) {
        int s = 0;
        int e = N;
        int m = 0;

        while(e > s + 1){
            m = (s + e) / 2;

            Node cur = list.get(m);

            if(cur.x > x || (cur.x == x && cur.y > y)){
                e = m;
            }
            else s = m;

        }

        Node cur = list.get(s);
        if(cur.x == x && cur.y == y) return true;
        return false;
    }

    static class Node implements Comparable<Node>{
        int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o){
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }
}