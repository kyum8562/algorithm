import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] map = new int[N];
        for (int i = 0; i < N; i++)
            map[i] = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = N-1; i >= 0; i--) {
            if(T >= map[i]){
                sum += T / map[i];
                T = T % map[i];
            }
        }

        System.out.println(sum);
    }
}