import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++)
			map[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int idx = 0; // 강의실
		long ans = 0; // 몇 명의 감독관을 고용해야 하는지
		while(idx < N) {
			int cnt = 1; // 해당 강의실에서 있어야하는 감독관 수
			int cur = map[idx] - a; // 주 감독관 빼주기
			if(cur > 0) { // 부 감독관 수 더해주기
				cnt += cur%b == 0 ? cur/b : (cur/b)+1;
			}
			idx++; // 강의실 이동
			ans += cnt; // 최종 감독관 수 갱신
		}
		System.out.println(ans);
	}

}