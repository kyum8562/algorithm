import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] prefixSum = new int[N+1];
        int[] map = new int[N+1];

        for(int i = 1 ; i <= N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(map);

        long sum = 0;
        for(int i = 1 ; i <= N ; i ++){
            prefixSum[i] = prefixSum[i-1] + map[i];
            sum += prefixSum[i];
        }

        System.out.println(sum);
    }
}