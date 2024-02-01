import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int trees[] = new int[N];
	
		// 나무길이 입력받기 + right 값은 나무 최대 길이 찾아 저장
		int left = 0, right = Integer.MIN_VALUE;
		st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			trees[i] = num;
			right = Math.max(right, num);
		}
	
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			
			// 잘라진 나무 길이의 합
			for(int i = 0; i < N; i++) {
				// 이 조건을 넣지 않으면 음수값이 더해지기 때문에 제대로 된 계산이 되지 않음
				if(trees[i] > mid) sum += trees[i] - mid; 
			}
			
			if(M <= sum) left = mid + 1;
			else right = mid - 1;
		}
		
		System.out.println(right);		
		in.close();

	}
}