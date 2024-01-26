import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// 입력부
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		// 배열에 누적합으로 넣어줌
		for(int i = 1 ; i <= N ; i ++) {
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}
		
		// 구현부
		int maxSum = Integer.MIN_VALUE; // 최댓값을 저장한 변수
		for(int i = 1 ; i <= N ; i ++) {
			int a = i-K <= 0 ? 0 : i-K;
			if(i-a != K) continue;
			int tmp = arr[i] - arr[a];
			if(maxSum < tmp)
				maxSum = tmp;
		}
		
		System.out.println(maxSum);
	}

}