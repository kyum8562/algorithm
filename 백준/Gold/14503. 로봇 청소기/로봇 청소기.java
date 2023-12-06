import java.io.*;
import java.util.*;
public class Main {
	static int N, M, ans;
	static int[][] map;
	static boolean[][] v;
	static class Node{ // 좌표(r, c)
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 0: 빈칸,  1: 벽
			}
		}
		
		v = new boolean[N][M];
		
		System.out.println(play(sr, sc, sd)); // 출력
	}
	private static int play(int r, int c, int curD) {
		int cleanCnt = 0;
		while(true) {
			// 1. 현재 칸이 청소되지 않았을 경우 => 청소
			if(!v[r][c]) {
				v[r][c] = true;
				cleanCnt++;
			}
			
			// 2. 주변 칸 탐색
			boolean flag = false; // 주변 4 칸이 모두 청소가 된 상황(false)
			for(int d = 0 ; d < 4 ; d ++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(v[nr][nc] || map[nr][nc] == 1) continue; // 청소된 칸이거나 벽이라면 => pass
				flag = true;
				break;
			}
			
			// 3. 이동
			if(flag) { // 청소하지 않은 칸이 있다면
				curD = (curD+3)%4; // 반시계 90도 이동
				int nr = r + dr[curD];
				int nc = c + dc[curD];
				if(v[nr][nc] || map[nr][nc] == 1) continue; // 청소된 칸이거나 벽이라면 => pass
				r = nr;
				c = nc;
			}
			else { // 모두 청소했다면
				int nr = r - dr[curD];
				int nc = c - dc[curD];
				if(map[nr][nc] == 1) { // 후진하려는 칸이, 범위 벗어나거나 벽이라면 => 종료
					return cleanCnt;
				}
				else {// 한 칸 후진
					r = nr;
					c = nc;
				}
			}
		}
	}
}