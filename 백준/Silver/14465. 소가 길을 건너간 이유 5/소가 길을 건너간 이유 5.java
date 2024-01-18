import java.io.*;
import java.util.*;

public class Main {
    static int N, T, B;
    static int[] map;
    static boolean[] isBreak;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        isBreak = new boolean[N+2];
        for(int i = 0 ; i < B ; i ++)
            isBreak[Integer.parseInt(br.readLine())] = true;

        System.out.println(twoPoint());
    }

    private static int twoPoint() {
        int s = 1, e = 1;

        int min = Integer.MAX_VALUE; // 신호동 고친 최솟값 저장
        int cnt = isBreak[s] ? 1 : 0 ; // 부서진 신호등 고친 수
        long sum = 1;

        while(N+1 > e){
            // 타겟보다 클 경우,
            if(sum > T){
                sum -= 1;
                if(isBreak[s++]) cnt --; // s에 위치한 칸이 고쳤던 신호등이라면 => 다시 부서진 상태로 두기(-)
                min = Math.min(min, cnt);
            }
            // 타겟보다 작을 경우,
            else if(sum < T){
                sum += 1;
                if(isBreak[++e]) cnt ++; // 다음으로 이동할 칸(e+1)이 부서진 신호등이라면 => 고치기(+)
            }
            // 타겟과 같을 경우 => ans 갱신
            else{
                min = Math.min(min, cnt);
                if(isBreak[++e]) cnt ++; // 다음으로 이동할 칸(e+1)이 부서진 신호등이라면 => 고치기(+)
                if(isBreak[s++]) cnt --; // s에 위치한 칸이 고쳤던 신호등이라면 => 다시 부서진 상태로 두기(-)
            }
        }
        return min;
    }
}