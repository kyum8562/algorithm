import java.io.*;
import java.util.*;

/**
 * 백준 14502 연구소 - 구현
 * map에서 벽 3개를 조합으로 세우고, 안전영역 BFS 돌리면서 카운팅한 값들 중 최댓값 도출
 *
 * 1. 입력 받기
 * 2. 벽 3개 세우기
 * 3. BFS 돌리고, 최댓값 갱신
 * 4. 2와 3 과정 반복
 * 5. 결과값 도출
 */
public class Main {
    static int N, M, ans;
    static int[] combChoice;
    static int[][] map, copyMap;
    static boolean[][] v;
    static List<Node> zeroList, virusList;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;

        map = new int[N][M];
        combChoice = new int[3];
        zeroList = new ArrayList<>();
        virusList = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) zeroList.add(new Node(i, j));
                else if(map[i][j] == 2) virusList.add(new Node(i, j));
            }
        }

        // 조합 돌리기
        comb(0, 0);

        // 최종값 도출
        System.out.println(ans);
    }

    private static void comb(int depth, int cnt) {
        // 조합이 뽑혔다면
        if(depth == 3){
            // v 배열 초기화
            v = new boolean[N][M];

            // 맵 복사
            copyMap = new int[N][M];
            mapCopy();

            // 해당 map 값에 벽을 세움
            for(int i = 0 ; i < 3 ; i ++){
                Node curr = zeroList.get(combChoice[i]);
                copyMap[curr.r][curr.c] = 1;
            }

            // 바이러스(2) 이동
            for(int i = 0 ; i < virusList.size() ; i ++){
                Node curr = virusList.get(i);
                bfs(curr.r, curr.c);
            }

            // 최댓값 도출
            maxModify();

            return;
        }

        for(int i = cnt ; i < zeroList.size() ; i ++){
            combChoice[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    private static void maxModify() {
        int zeroCnt = 0;
        for(int i = 0 ; i < N ; i ++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) zeroCnt++;
            }
        }

        ans = Math.max(ans, zeroCnt);
    }

    private static void mapCopy() {
        for(int i = 0 ; i < N ; i ++){
            copyMap[i] = map[i].clone();
        }
    }

    private static void bfs(int s, int e) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(s, e));
        v[s][e] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(int d = 0 ; d < 4 ; d ++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(isValid(nr, nc)){
                    if(!v[nr][nc] && copyMap[nr][nc] == 0){
                        v[nr][nc] = true;
                        copyMap[nr][nc] = 1;
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }

    private static boolean isValid(int nr, int nc) {
        return (nr>=0 && nr<N && nc>=0 && nc<M);
    }
}