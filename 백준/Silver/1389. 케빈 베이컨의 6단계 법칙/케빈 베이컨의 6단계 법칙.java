import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans = Integer.MAX_VALUE, maxCnt = Integer.MAX_VALUE;
	static List<ArrayList<Integer>> list;
	static boolean[] isVisited;
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		list = new ArrayList<>();
		
		for(int i = 0 ; i <= N ; i ++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1 ; i <= N ; i ++) {
			isVisited = new boolean[N+1];
			int cnt = bfs(i);
			if(maxCnt > cnt) {
				maxCnt = cnt;
				ans = i;
			}
			else if(maxCnt == cnt && ans > i) {
				ans = i;
			}
		}
		
		System.out.println(ans);
	}

	private static int bfs(int start) {
		q.offer(start);
		isVisited[start] = true;
		int cnt = 0;
		int depth = 1;
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int j = 0 ; j < qSize ; j ++) {
				int curr = q.poll();
				for(int i = 0 ; i < list.get(curr).size() ; i ++) {
					int tmp = list.get(curr).get(i);
					if(!isVisited[tmp]) {
						q.offer(tmp);
						isVisited[tmp] = true;
						cnt += depth;
					}
				}
			}
			depth++;
		}
		return cnt;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}