import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        int tgt = Integer.parseInt(br.readLine());

        Arrays.sort(map);

        System.out.println(getAns(tgt));
    }

    private static int getAns(int tgt) {
        int cnt = 0;
        int s = 0;
        int e = N-1;
        while(e > s){
            int res = map[s] + map[e];
            // 타겟값보다 클 때, e는 어떤 누구와 매칭해도 큼
            if(res > tgt) e --;
            // 타겟값보다 작을 때, s는 어떤 누구와 매칭해도 작음
            else if(res < tgt) s ++;
            // 타겟값과 같을 경우, cnt ++;
            else{
                s ++;
                e --;

                cnt ++;
            }
        }
        return cnt;
    }
}