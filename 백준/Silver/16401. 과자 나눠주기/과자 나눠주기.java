import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int max = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            max = Math.max(max, tmp);
        }

        System.out.println(bs(max));
    }

    private static int bs(int max) {
        int s = 1;
        int e = max;
        int m;
        int ans = 0;

        while(e >= s){
            // 과자길이
            m = (s + e) / 2;

            // 모든 조카에게 나눠줄 수 있다면
            if(isAvail(m)){
                // 정답 갱신
                ans = m;
                // 과자길이를 더 늘림
                s = m + 1;
            }
            // 모든 조카에게 나눠줄 수 없다면, 과자길이를 줄임
            else e = m - 1;
        }

        return ans;
    }

    private static boolean isAvail(int val) {
        int cnt = 0; // 몇명의 조카에게 주었는지

        for(int i = 0 ; i < N ; i ++){
            // 하나의 과자를 val만큼 나누어서 줄수있을 때
            cnt += arr[i] / val;

            // 주어진 M개의 조카에게 모두 나눠줄 수 있다면, true
            if(cnt >= M) return true;
        }

        // M명의 조카에게 모두 나눠줄 수 없다면, false
        return false;
    }
}