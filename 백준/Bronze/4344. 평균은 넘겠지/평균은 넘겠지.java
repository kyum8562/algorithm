import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N;

        while(T -- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            double sum = 0.0;
            int[] map = new int[N];

            for(int i = 0 ; i < N ; i ++){
                map[i] = Integer.parseInt(st.nextToken());
                sum += map[i];

            }
            sum /= N;

            // 평균을 넘는 인원이 몇명인지 파악
            double cnt = 0;
            for(int i = 0 ; i < N ; i ++){
                if(map[i] > sum) cnt ++;
            }

            // 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력
            double res = (cnt / N) * 100;

            sb.append(String.format("%.3f", res)).append("%\n");
        }

        System.out.println(sb);
    }
}