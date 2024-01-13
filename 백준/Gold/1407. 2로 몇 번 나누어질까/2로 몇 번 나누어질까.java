import java.io.*;
import java.util.*;

/**
 * n!을 k^i로 나눌 수 있는 가장 큰 i를 찾는 문제
 * 각, 테케마다 소인수 분해를 통한 n!을 구하고
 * 나눌 수 있는 최대의 i를 계산하여 결과 출력
 */
public class Main {
    static long ans = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(getAns(B) - getAns(A-1));
    }

    static long getAns(long x) {
        long sum = 0;
        long y;
        long i = 1;

        while(x>0) {
            if(x%2==0)
                y = x/2;
            else
                y = x/2+1;

            sum += y*i;
            x -= y;
            i*=2;
        }

        return sum;
    }
}