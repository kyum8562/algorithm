import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int INF = Integer.MIN_VALUE;
    static int[] zzi, mook, bo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        zzi = new int[N+1];
        mook = new int[N+1];
        bo = new int[N+1];
        for(int i = 1 ; i <= N; i ++){
            String a = br.readLine();

            zzi[i] = zzi[i-1] + (a.equals("P") ? 1 : 0);
            mook[i] = mook[i-1] + (a.equals("S") ? 1 : 0);
            bo[i] = bo[i-1] + (a.equals("H") ? 1 : 0);
        }

        int res = INF;
        for(int i = 1 ; i <= N ; i ++){

            int resZzi = calculation(i, 1); // 가위 기준(type: 1)
            int resMook = calculation(i, 2); // 가위 기준(type: 1)
            int resBo = calculation(i, 3); // 가위 기준(type: 1)

            res = Math.max(res, resZzi);
            res = Math.max(res, resMook);
            res = Math.max(res, resBo);
        }
        System.out.println(res);
    }

    private static int calculation(int i, int type) {
        int max = INF;
        int tmp1 = 0, tmp2 = 0;
        if(type == 1){ // 가위가 메인일 때
            tmp1 = zzi[i] + mook[N] - mook[i];
            tmp2 = zzi[i] + bo[N] - bo[i];
        }
        else if(type == 2){ // 주먹이 메인일 때
            tmp1 = mook[i] + zzi[N] - zzi[i];
            tmp2 = mook[i] + bo[N] - bo[i];
        }
        else{ // 보가 메인일 때
            tmp1 = bo[i] + zzi[N] - zzi[i];
            tmp2 = bo[i] + mook[N] - mook[i];
        }

        max = Math.max(max, tmp1);
        max = Math.max(max, tmp2);

        return max;
    }
}