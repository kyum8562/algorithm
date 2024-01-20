import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int ans = 1;				// 정답
		int alphaNum = 1;			// 알파벳 개수
		int left = 0, right = 0;	// 투 포인터
		int[] alpha = new int[26];  // 알파벳 개수 배열
		alpha[str.charAt(0)-'a']++; // 첫 번째 알파벳 넣어줌
		
		while(true) {
			right++;
			if(right == str.length()) break; // right 끝까지 가면 반복문 탈출
			
			int num = str.charAt(right)-'a'; // 오른쪽 포인터에 해당하는 값
			alpha[num]++;
			
			if(alpha[num] ==1) alphaNum++;
			
			while(alphaNum > N) {
				int tmp = str.charAt(left++)-'a';
				alpha[tmp]--;
				
				if(alpha[tmp] == 0) alphaNum--;
			}
			
			ans = (ans > right-left+1) ? ans : right-left+1;
		}
		
		System.out.println(ans);
	}

}