import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int Awin = 0;
		int Bwin = 0;
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			//값이 더 큰 쪽에 승리 점수를 추가
			if(A > B) {
				Awin++;
			}else if(B > A) {
				Bwin++;
			}
		}
		System.out.println(Awin + " " + Bwin);
	}

}