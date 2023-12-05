import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int time;
        int money;
        public Node(int time, int money){
            this.time = time;
            this.money = money;
        }
    }
    static int N, ans = Integer.MIN_VALUE;
    static Node[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new Node[N+1];
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i] = new Node(a, b);
        }

        dfs(1, 0);
        System.out.println(ans);
    }

    private static void dfs(int day, int money) {
        if(day >= N+1){
            if(day == N+1) ans = Math.max(ans, money);
            return;
        }

        Node curr = map[day];
        dfs(day+curr.time, money+curr.money);
        dfs(day+1, money);

    }
}