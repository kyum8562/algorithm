import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long a;
    static long d;
    static long q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        a = Long.parseLong(st.nextToken());
        d = Long.parseLong(st.nextToken());
        q = Long.parseLong(br.readLine());

        for (long p = 0; p < q; p++) {
            st = new StringTokenizer(br.readLine());

            long check = Long.parseLong(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            if(check == 1){
                sb.append(sequenceSum(r) - sequenceSum(l-1)+"\n");
            }else{
                if(l == r){
                    sb.append((a + (l-1)*d)+"\n");
                }else{
                    sb.append(gcd(Math.max(a, d), Math.min(a, d))+"\n");
                }
            }

        }
        System.out.println(sb.toString());
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    private static long sequenceSum(long n) {
        return (n * (2*a + (n-1)*d))/2;
    }
}