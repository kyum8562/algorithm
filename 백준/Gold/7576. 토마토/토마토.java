import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<Coords> q;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
//        isVisited = new boolean[N][M];
        q = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i ++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j ++) {
        		int tmp = Integer.parseInt(st.nextToken());
        		map[i][j] = tmp;
        		if(tmp == 1)
        			q.offer(new Coords(i, j));
        	}
        }
        
        bfs();
        mapCheck();
        if(ans == -1) System.out.println(-1);
        else System.out.println(ans-1);
	}
	
    static void mapCheck() {
    	for(int i = 0 ; i < N ; i ++) {
        	for(int j = 0 ; j < M ; j ++) {
        		if(map[i][j] == 0) {
        			ans = -1;
        			return;
        		}
        		if(map[i][j] > ans) {
        			ans = map[i][j];
        		}
        	}
    	}
	}

	static void bfs() {
    	
    	while(!q.isEmpty()) {
    		Coords curr = q.poll();
//    		isVisited[curr.r][curr.c] = true;
    		
    		for(int d = 0 ; d < 4 ; d ++) {
    			int nr = curr.r + dr[d];
    			int nc = curr.c + dc[d];
    			
    			if(isVaild(nr, nc)) {
    				if(map[nr][nc] == 0) {
    					q.offer(new Coords(nr, nc));
    					map[nr][nc]  = map[curr.r][curr.c] + 1 ;
    				}
    			}
    		}
    	}
	}

	static class Coords{
        int r;
        int c;

        public Coords(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean isVaild(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }

}