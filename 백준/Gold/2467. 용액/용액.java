import java.io.*;
import java.util.*;

public class Main {
    static int N, ans, lowN, highN, flag;
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE; // 절댓값의 최솟값을 저장하는 변수
        flag = 1; // 순회를 멈출지 결정하는 상태값(0: 그만 동작해도 되는 상태)

        for (int i = 0; i < N-1; i++){
            binarySearch(i, map[i]);
            if(flag == 0) break;
        }

        System.out.println(lowN + " " + highN);
    }

    private static void binarySearch(int idx, int A) {
        int s = idx+1;
        int e = N-1;
        int m = 0;

        while(e >= s){
            m = (s + e) / 2;
            int res = Math.abs(map[m] + A);

            // 절댓값이 더 작다면, 갱신
            if(ans >= res){
                ans = res;
                lowN = map[idx];
                highN = map[m];
            }

            // 두 값의 합이 0이라면, 더 이상 탐색할 필요없음
            if(map[m] + map[idx] == 0) break;
            // 두 값의 합이 0보다 크다면, e값을 줄여줌
            if(map[m] + map[idx] > 0) e = m - 1;
            // 두 값의 합이 0보다 작다면, s값을 늘려줌
            else s = m + 1;
        }
    }
}