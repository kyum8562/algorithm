import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] rc = new int[100][100]; 
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int j = A ; j < A+10 && j<100; j++) {
				for(int k = B ; k < B+10 && k<100; k++) {
                    if(rc[j][k] == 1) continue;
					rc[j][k] = 1;
                    ans ++;
				}
			}
		}
		System.out.println(ans);
	}

}