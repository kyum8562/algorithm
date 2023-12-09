import java.io.*;
import java.util.*;
public class Main {
	static int N, K;
	static long ans;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		init();
		
		play();
		
		System.out.println(ans);
	}
	static void play() {
		while(true) {
			v = new boolean[N][N];
			
			// 1. 크기가 가장 큰 블록 그룹 찾기
			Node maxNode = new Node(0, 0, 0, Integer.MIN_VALUE, Integer.MIN_VALUE);
			
			for(int i = 0 ; i < N ; i ++) {
				for(int j = 0 ; j < N ; j ++) {
					if(v[i][j] || map[i][j] < 1 || map[i][j] > K) continue;
					
					initVRainbow();
					Node cur = bfs(i, j);
					
					if(cur == null) continue;
					
					if(maxNode.compareNode(cur)) maxNode = cur;
				}
			}
			//
			if(maxNode.color == 0) return;
			
			// 2. 크기가 가장 큰 블록 그룹 제거(-2) && 점수 획득
			removeBlockGroup(maxNode);
			ans += maxNode.sum*maxNode.sum;
			
			// 3. 중력 작용
			gravity();
			
			// 4. 90도 반시계 회전
			reverseRotation90();
			
			// 5. 중력 작용
			gravity();
		}
	}
	static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = 0;
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	private static void initVRainbow() {
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++)
				if(map[i][j] == 0) v[i][j] = false;
		}
	}
	private static void reverseRotation90() {
		int[][] tmp = new int[N][N];
			
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < N ; j ++)
				tmp[N-1-j][i] = map[i][j];
		}
		
		map = tmp;
	}
	private static void gravity() {
		for(int i = 0 ; i < N ; i ++){
			for(int j = N-2 ; j >= 0 ; j --){
				
				if(map[j][i] == -1 || map[j][i] == -2) continue; 
				int tmp = j;
				while(tmp < N-1){
					if(map[tmp+1][i] != -2) break;
					tmp ++;
				}
				if(tmp == j) continue;
				// 이동
				map[tmp][i] = map[j][i];
				map[j][i] = -2;
			}
		}
	}
	private static void removeBlockGroup(Node cur) {
		boolean[][] localV = new boolean[N][N];
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(cur.r, cur.c));
		int tgt = cur.color;
		
		// 블록 범위, 무지개 블록 수, 기준 블록(행, 열)을 찾아야 함
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			localV[curr.r][curr.c] = true;
			map[curr.r][curr.c] = -2;
			
			for(int d = 0 ; d < 4 ; d ++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(!isValid(nr, nc) || localV[nr][nc]) continue; // 범위 초과 => pass
				if(map[nr][nc] == tgt || map[nr][nc] == 0) { // 같은색 or 무지개(0)일 때만
					localV[nr][nc] = true;
					q.offer(new Node(nr, nc));
				}
			}
		}
	}
	private static Node bfs(int sr, int sc) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(sr, sc));
		v[sr][sc] = true;
		
		int tgt = map[sr][sc];
		int cnt = 1; // 블록 그룹 내의 개수(최종 2개 이상이어야 함)
		int rainbowCnt = 0; // 무지개 블록 수
		
		// 블록 범위, 무지개 블록 수, 기준 블록(행, 열)을 찾아야 함
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(map[curr.r][curr.c] == 0) rainbowCnt++; // 무지개 블록 수 증가
			
			for(int d = 0 ; d < 4 ; d ++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(!isValid(nr, nc) || v[nr][nc]) continue; // 범위 초과 => pass
				if(map[nr][nc] == tgt || map[nr][nc] == 0) { // 같은색 or 무지개(0)일 때만
					cnt++;
					v[nr][nc] = true;
					q.offer(new Node(nr, nc));
				}
			}
		}
		if(cnt < 2) return null;
		return new Node(sr, sc, tgt, cnt, rainbowCnt);
	}
	private static boolean isValid(int nr, int nc) {
		return (nr>=0 && nr<N && nc>=0 && nc<N);
	}
	static class Node{
		int r, c, color, sum, rainbowSum;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public Node(int r, int c, int color, int sum, int rainbowSum) {
			this.r = r;
			this.c = c;
			this.color = color;
			this.sum = sum;
			this.rainbowSum = rainbowSum;
		}
		public boolean compareNode(Node o) {
			if(this.sum != o.sum) return this.sum < o.sum;
			if(this.rainbowSum != o.rainbowSum) return this.rainbowSum < o.rainbowSum;
			if(this.r != o.r) return this.r < o.r;
			return this.c < o.c;
		}
	}

}