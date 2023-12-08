import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][]rectangle = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String row = br.readLine();
			
			for(int j=0; j<M; j++) {
				
				rectangle[i][j] = row.charAt(j) - 48; // 아스키코드 형태라 -48해줘서 정수를 맞춰준다.
			}
		}
		
		int search = Math.min(N, M);
		
		while(true) {
			
			for(int i=0; i<= N-search; i++) {
				for(int j=0; j<= M-search; j++) {
					int n = rectangle[i][j]; // 기준 꼭짓점
					
					if(n == rectangle[i][j+(search-1)] 
					&& n == rectangle[i+(search-1)][j] 
					&& n == rectangle[i+(search-1)][j+(search-1)]) {
						System.out.println(search*search);
						return; // break는 가장 가까운 반복문만 탈출하나 return은 메소드 자체를 탈출
					}
				}
				
			}
			search--;
		}
	}

}