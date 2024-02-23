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
    static int N;
    static Node[] map;
    static int[] dp;
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

        dp = new int[N+2];
        for(int day = 1 ; day <= N ; day ++){
            Node curr = map[day];
            if(day+curr.time <= N+1)
                dp[day+curr.time] = Math.max(dp[day+curr.time], dp[day]+curr.money);
            dp[day+1] = Math.max(dp[day+1], dp[day]);
        }

        System.out.println(dp[N+1]);
    }
}