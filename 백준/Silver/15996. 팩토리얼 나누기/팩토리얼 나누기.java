import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long A = Long.parseLong(st.nextToken());

        System.out.println(getAns(N, A));
    }

    private static int getAns(long N, long A) {
        int sum = 0;
        long AA = A;
        while(N >= AA){
            sum += N/AA;
            AA *= A;
        }
        return sum;
    }
}