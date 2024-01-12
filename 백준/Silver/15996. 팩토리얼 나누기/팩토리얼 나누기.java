import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());

        System.out.println(getAns(N, A));
    }

    private static int getAns(long N, int A) {
        int sum = 0;
        while(N > 1){
            sum += N/A;
            N /= A;
        }
        return sum;
    }
}