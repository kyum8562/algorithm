import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		int ans = 100001, p1 = 0, p2 = 0;
		long sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < N; i ++) {
//			if(curr >= S || ans == 1) {
//				System.out.println(1);
//				return ;
//			}
			arr[i] = Long.parseLong(st.nextToken());
		}
		while(true) {
			if(sum >= S) {
				int tmp = p2-p1;
				sum -= arr[p1++];
				if(ans > tmp) ans = tmp;
			}
			else if(p2 == N)
				break;
			else
				sum += arr[p2++];
		}
		System.out.println(ans==100001?0:ans);
	}
}