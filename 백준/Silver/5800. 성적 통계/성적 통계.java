import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t ++){

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] map = new int[N];
            for(int i = 0 ; i < N ; i ++){
                map[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(map);
            int lg = Integer.MIN_VALUE;
            for(int i = N-1 ; i > 0 ; i --){
                int val = map[i] - map[i-1];
                lg = Math.max(lg, val);
            }

            sb.append("Class ").append(t).append("\n");
            sb.append("Max ").append(map[N-1]).append(", Min ").append(map[0]).append(", Largest gap ").append(lg).append("\n");
        }
        System.out.println(sb);
    }
}