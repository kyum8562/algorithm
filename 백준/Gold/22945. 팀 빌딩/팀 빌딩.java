import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++)
            map[i] = Integer.parseInt(st.nextToken());

        System.out.println(twoPoint());
    }

    private static int twoPoint() {
        int ans = 0, s = 0, e = N-1;

        while(e > s - 1){
            ans = Math.max(ans, (e - s - 1) * Math.min(map[s], map[e]));

            if(map[e] > map[s]) s ++;
            else e --;
        }

        return ans;
    }
}