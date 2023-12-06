import java.io.*;
import java.util.*;
public class Main {
	static int N, M, ans = Integer.MAX_VALUE;
	static int[][] map;
	static List<Node> houseList; // 집의 좌표가 담겨있는 list
	static List<Node> chickenList; // 치킨집의 좌표가 담겨있는 list
	static int[] choice; // M개를 뽑은 치킨집 인덱스가 담긴 배열 
	static class Node{ // 좌표(r, c)
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		houseList = new ArrayList<>();
		chickenList = new ArrayList<>();
		choice = new int[M];
		map = new int[N][N];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				int v = Integer.parseInt(st.nextToken());
				map[i][j] = v;
				if(v == 1) { // 집
					houseList.add(new Node(i, j));
				}
				else if(v == 2) { // 치킨집
					chickenList.add(new Node(i, j));
				}
			}
		}
		
		comb(0, 0); // M개의 치킨집 뽑기
		System.out.println(ans); // 출력
	}
	private static void comb(int depth, int start) {
		if(depth == M) {
			ans = Math.min(ans, counting()); // ans = 모든 집에 대한 최소의 치킨거리 갱신
			return;
		}
		
		for(int i = start ; i < chickenList.size(); i ++) {
			choice[depth] = i;
			comb(depth+1, i+1);
		}
	}
	private static int counting() {
		int sum = 0; // 모든 집의 최소거리의 합이 담기는 변수
		for(int j = 0 ; j < houseList.size(); j ++) { // 집만큼 순회
			int minVal = Integer.MAX_VALUE;
			for(int i = 0 ; i < M ; i ++) { // 뽑은 치킨집 순회
				int curChickenR = chickenList.get(choice[i]).r;
				int curChickenC = chickenList.get(choice[i]).c;
				// 맨해튼 거리 구하기
				int res = Math.abs(curChickenR - houseList.get(j).r) + Math.abs(curChickenC - houseList.get(j).c);
				minVal = Math.min(minVal, res); // 최소 거리의 치킨집 탐색
			}
			sum += minVal; // 집-치킨집 간의 최소거리 sum
		}
		return sum;
	}
}