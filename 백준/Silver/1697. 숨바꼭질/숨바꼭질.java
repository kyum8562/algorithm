import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<Integer> q = new ArrayDeque<>();
	static boolean[] isVisited;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		isVisited = new boolean[100001];
		
		int ans = bfs(0, N);
		
		System.out.println(ans);
	}

	private static int bfs(int depth, int start) {
		q.offer(start);
		isVisited[start] = true;
		
		
		a : while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i = 0 ; i < qSize ; i ++) {
				
				int curr = q.poll();
				if(curr == K) {
					break a;
				}
				
				int tmp = 0;
				
				for(int d = 0 ; d < 3 ; d ++) {
					switch (d) {
					case 0:
						tmp = curr+1;
						break;
					case 1:
						tmp = curr-1;
						break;
					default:
						tmp = curr*2;
						break;
					}
					if(!isVaild(tmp)) continue;
					
					if(!isVisited[tmp]) {
						q.offer(tmp);
						isVisited[tmp] = true;
					}
				}
			}
			depth++;
		}
		return(depth);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	static boolean isVaild(int curr) {
		if(curr >= 0 && curr < 100001) {
			return true;
		}
		else {
			return false;
		}
	}
}