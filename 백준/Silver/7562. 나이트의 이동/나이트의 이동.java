import java.io.*;
import java.util.*;

public class Main {

	static int N, endX, endY;
	static boolean[][] isVisited;
	static int[][] map;
	final static int[] dx = {-2, -2, -1, 1, 2, 2, -1, 1};
	final static int[] dy = {-1, 1, 2, 2, -1, 1, -2, -2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = stoi(br.readLine());
		
		for(int t = 1 ; t <= T ; t ++) {
			N = stoi(br.readLine());
			map = new int[N][N];
			isVisited = new boolean[N][N];
			
//			for(int i = 0 ; i < N ; i ++) {
//				for(int j = 0 ; j < N ; j ++) {
//					map[i][j] = 0;
//				}
//			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = stoi(st.nextToken());
			int startY = stoi(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endX = stoi(st.nextToken());
			endY = stoi(st.nextToken());
			
			System.out.println(bfs(startX, startY));
		}
	}
	static int bfs(int x, int y) {
		Queue<Coords> q = new ArrayDeque<>();
		q.offer(new Coords(x, y));
		isVisited[x][y] = true;
		int depth = 0;
		while(!q.isEmpty()) {
			int qSize = q.size();
			depth++;
			for(int i = 0 ; i < qSize ; i ++) {
				Coords curr = q.poll();
				
				if(curr.x == endX && curr.y == endY) {
					return depth-1;
				}
				
				for(int d = 0; d < 8 ; d ++) {
					int nx = curr.x + dx[d];
					int ny = curr.y + dy[d];
					
					if(isVaild(nx, ny)) {
						if(!isVisited[nx][ny]) {
							q.offer(new Coords(nx, ny));
							isVisited[nx][ny] = true;
						}
					}
				}
			}
		}
		return 0;
	}
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static class Coords{
		int x;
		int y;

		public Coords(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static boolean isVaild(int nx, int ny) {
		return (nx>=0 && ny>=0 && nx<N && ny<N);
	}
}