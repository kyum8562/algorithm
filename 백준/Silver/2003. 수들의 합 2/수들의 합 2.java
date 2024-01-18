import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        map = new int[N+1];
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        System.out.println(twoPoint());
    }

    private static int twoPoint() {
        int s = 0, e = 0;

        int cnt = 0;
        long sum = map[s];
        while(N > e){
            // 타겟보다 클 경우,
            if(sum > T){
                sum -= map[s++];
            }
            // 타겟보다 작을 경우,
            else if(sum < T){
                sum += map[++e];
            }
            // 타겟과 같을 경우
            else{
                sum -= map[s++];
                sum += map[++e];
                cnt ++;
            }
        }
        return cnt;
    }
}