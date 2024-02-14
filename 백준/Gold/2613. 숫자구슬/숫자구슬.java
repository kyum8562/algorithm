import java.util.*;
import java.io.*;

public class Main {
	static int[] beads;
	static int N, M;
	static int lower = 0, upper = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 구슬 수
		M = Integer.parseInt(st.nextToken()); // 묶음 수

		beads = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			beads[i] = Integer.parseInt(st.nextToken());
			lower = Math.max(lower, beads[i]); 	// 구슬 합의 최소 범위
			upper += beads[i]; 					// 구슬 합의 최대 범위
		}

		binarySearch();				// 이분 탐색으로 값 찾기
		System.out.println(lower); 	// 구슬 합의 최댓값 출력

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += beads[i];
			if (sum > lower) { 	// 만약 구슬 합이 최댓값보다 크면
				M--;			// 묶음이 하나 만들어진 것이므로 M--;
				sum = beads[i];
				sb.append(cnt).append(" "); // 현재 구슬 수를 sb에 추가
				cnt = 1; 					// 다시 구슬 수를 1로 카운트
			} else {
				cnt++;
			}
			
			if(M == N - i) break; // 묶음 수가 1인 경우를 세어 주기 위해
		}

		// 현재 M == (남은 묶음 수) 이므로
        // 구슬이 다 묶일 때까지 M--;
		while(M-- > 0) {
        	// 위에 for문에서 최댓값에 도달하지 못한 합의 구슬 수를 먼저 추가
			sb.append(cnt).append(" ");
            // 그 다음은 다 1씩 묶음이므로 
			cnt = 1;
		}
		
		System.out.println(sb);
	}
	
	static void binarySearch() {
		int mid = 0;
		while (upper >= lower) {
        	// 1. 범위 내의 mid값을 특정(구슬 합의 최댓값)
			mid = (upper + lower) / 2;
            
            // 3. mid 값에 대한 구슬 묶음 수
			int cnt = cntBeadsBundle(mid);

			// 4. 묶음 수(cnt)와 묶여야할 수(M)를 비교
			if (cnt > M) {
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}
		}
	}

	static int cntBeadsBundle(int mid) {
		int sum = 0;
		int cnt = 1;

		// 2. 범위 내의 중간 값(mid)과 구슬 합을 비교하여 cnt를 센다
		for (int i = 0; i < N; i++) {
			sum += beads[i];
			if (sum > mid) {
				cnt++;
				sum = beads[i];
			}
		}

		return cnt;
	}
}