import java.io.*;
import java.util.*;

public class Main {
    static int N, M, maxPlayCnt, minGitaCnt;
    static String[] map;
    static boolean[] v, check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            map[i] = st.nextToken();
        }

        v = new boolean[N];
        maxPlayCnt = 0;
        minGitaCnt = Integer.MAX_VALUE;

        subSet(0);

        System.out.println(maxPlayCnt == 0 ? -1 : minGitaCnt);
    }

    private static void subSet(int depth) {
        if(depth == N){
            check = new boolean[M];
            int curPlayCnt = 0;
            int curGitaCnt = 0;
            for(int i = 0 ; i < N ; i ++){
                // 선택하지 않았다면 패스
                if(!v[i]) continue;

                // 선택한 개수 세기
                curGitaCnt ++;

                // 현재 선택한 기타의 연주 여부가 담긴 String
                String s = map[i];

                // String 순회
                for (int j = 0 ; j < M ; j ++) {
                    // 특정 곡의 연주가 가능하고, 아직 연주하지 않았다면, 카운트 세기
                    char cur = s.charAt(j);
                    if(cur == 'Y' && !check[j]){
                        // 연주한 것으로 처리
                        check[j] = true;
                        // 카운트 세기
                        curPlayCnt ++;
                    }
                }
            }

            // 연주한 곡의 수가 이전까지의 최대로 연주한 곡의 수 보다 많다면
            if(curPlayCnt > maxPlayCnt){
                // 최대로 연주한 곡의 수 갱신
                maxPlayCnt = curPlayCnt;
                minGitaCnt = curGitaCnt;
            }
            // 같다면
            else if(curPlayCnt == maxPlayCnt){
                // 기타 수가 이전까지의 최소 기타 개수보다 작다면
                if(minGitaCnt > curGitaCnt)
                    // 최소 기타 개수 갱신
                    minGitaCnt = curGitaCnt;
            }
            return;
        }

        v[depth] = true;
        subSet(depth+1);

        v[depth] = false;
        subSet(depth+1);
    }
}