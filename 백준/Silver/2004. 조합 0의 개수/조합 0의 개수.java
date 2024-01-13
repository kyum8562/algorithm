import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long Five = division(N, 5) - (division(N-K, 5) + division(K, 5));
		long Two = division(N, 2) - (division(N-K, 2) + division(K, 2));
		
		System.out.println(Five >= Two ? Two : Five);
	}
	public static long division(long N, int n) {
		long cnt = 0;
		long i = 0;
		for(i = n ; i <= N ; i*=n) {
			cnt += N / i;
		}
		return cnt;
	}
}