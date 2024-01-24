import java.io.*;
import java.util.*;

// 준표와 조약돌
// 투포인터
public class Main {
	static char[] stones;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());	// 검은 조약돌의 최대개수
		int w = Integer.valueOf(st.nextToken());	// 하얀 조약돌의 최소개수
		
		String line = br.readLine();
		stones = line.toCharArray();
		
		// 1. 시작과 끝을 0에서 시작
		int start = 0;
		int end = 0;
		int whiteStoneCount = 0;
		int blackStoneCount = 0;
		int slideSize = 0;
		int maxLen = 0;
		// 2. 조약돌 조건에 부합한지 체크
		// 지금까지 포인터 이동하면서 검은색, 흰색 돌 갯수를 파악해두기
		// 3. 오른쪽 포인터가 조약돌 끝에 닿으면 종료(어차피 왼쪽이 이동해봤자 최대 길이만 줄어드니 더이상 할 필요가 없음)
		// 4. 지금까지 계산했던 길이 리턴
		while(end < n) {
			if(blackStoneCount > b) {	// 검은돌 b개 이상 주은 경우
				if(stones[start] == 'W') {
					whiteStoneCount--;
				}
				if(stones[start] == 'B') {
					blackStoneCount--;
				}
				slideSize--;
				start++;
			}
			else {
				// 현재까지 주운 까만 돌의 개수가 조건에 일치하면
//				// 흰색 돌의 개수가 부족하면 앞으로 더 나아가면 되니까
//				// 흰색 돌의 개수 조건에 부합해도 앞으로 나아갈 수 있으니까
				if(stones[end] == 'W') {
					whiteStoneCount++;
				}
				if(stones[end] == 'B') {
					blackStoneCount++;
				}
				end++;
				slideSize++;
			}
			
			if(blackStoneCount <= b && whiteStoneCount >= w) {
				maxLen = Math.max(maxLen, slideSize);
			}
		}
		
		System.out.println(maxLen);

	}
}