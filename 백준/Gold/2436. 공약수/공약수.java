import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두 수를 입력받아 이의 GCD, LCM으로 하는 두 개의 자연수를 구하는 프로그램 구해라
// 두 개의 자연수 쌍이 여러개 있다면, 두 자연수의 합이 최소가 되는 한 쌍만 출력한다.

// AB = GCD*LCM
public class Main {
	static long gcd;
	static long lcm;
	static long lowSum = Integer.MAX_VALUE;
	static long ans_i = 0;
	static long ans_j = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int gcd = Integer.parseInt(st.nextToken());
		int lcd = Integer.parseInt(st.nextToken());
		
		long mul = (long)gcd*lcd;
		
		int a=0, b=0;
		
		for(int i = gcd; i<=Math.sqrt(mul);i+=gcd) {
			if(mul % i == 0 && euclidean(i,mul / i) == gcd) {
				a = i;
				b = (int)(mul / i);
			}
		}
		
		System.out.println(a + " " + b);
	}
	
	public static long euclidean(long a, long b) {
		long r = a % b;
		if( r == 0) {
			return b;
		}
		return euclidean(b,r);
	}

}