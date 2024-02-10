import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){
            int N = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < N ; i ++){
                int tmp = Integer.parseInt(st.nextToken());
                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }
            sb.append((max-min)*2).append("\n");
        }
        System.out.println(sb);
    }
}