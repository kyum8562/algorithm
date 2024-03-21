import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, ans = 0;
	static boolean[] isVisited;
	static int[] arr;
	static Queue<Integer> q = new ArrayDeque<>();
	static List<ArrayList<Integer>> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		K = stoi(st.nextToken());
		
		arr = new int[N+1];
		isVisited = new boolean[N+1];
		list = new ArrayList<>();
		
		for(int i = 0 ; i <= N ; i ++) {
			list.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1 ; i <= N ; i ++) {
			arr[i] = stoi(st.nextToken());
		}
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for(int i = 1 ; i <= N ; i ++) {
			if(!isVisited[i])
				ans += bfs(i);
		}
		
		if(K >= ans)
			System.out.println(ans);
		else
			System.out.println("Oh no");
	}

	
	private static int bfs(int start) {
		q.offer(start);
		isVisited[start] = true;
		int cnt = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(cnt > arr[curr])
				cnt = arr[curr];
			int qSize = q.size();
			
			for(int i = 0 ; i < list.get(curr).size() ; i ++) {
				int tmp = list.get(curr).get(i);
				if(!isVisited[tmp]) {
					isVisited[tmp] = true;
					q.offer(tmp);
				}
			}
		}
		
		return cnt;
	}


	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}