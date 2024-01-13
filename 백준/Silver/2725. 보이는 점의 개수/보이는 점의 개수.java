import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int[] sosu;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1 ; t <= T ; t ++) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[N+1];
			sosu = new int[N+1];
			
			arr[1] = 3;
			sosu[1] = 3;
			
			for(int i = 2 ; i <= N ; i++) {
				int cnt = arr[1];
				int tmp = 2*i + 1;
				int j;
				
				for(j = 2 ; j*j < i ; j++) {
					if(i % j == 0)
						cnt += sosu[j] + sosu[i/j];
				}
				if(j * j == i) 
					cnt += sosu[j];
				
				sosu[i] = tmp - cnt;
				
				arr[i] = arr[i-1] + sosu[i];
			}
			System.out.println(arr[N]);
			
		}
	}

}