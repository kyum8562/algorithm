import java.io.*;
import java.util.*;

public class Main {
    static int[] createdCnt, in;
    static List<Integer>[] list;
    static Set<Integer>[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int K = Integer.parseInt(st.nextToken()); // 쿼리

        createdCnt = new int[N+1];
        in = new int[N+1];
        list = new ArrayList[N+1];
        set = new LinkedHashSet[N+1];

        for(int i = 1 ; i <= N ; i ++){
            list[i] = new ArrayList<>();
            set[i] = new LinkedHashSet<>();
        }

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            in[b] ++;
        }

        boolean flag = true;
        for(int i = 0 ; i < K ; i ++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int cur = Integer.parseInt(st.nextToken());

            // 건물을 건설
            if(type == 1 && in[cur] == 0){
                createdCnt[cur] ++;

                // cur이 선행되어야 하는 건물에 대해 => 해금(cur 생성 완료에 해당하는 조치)
                for(int next: list[cur]){
                    if(set[next].contains(cur)) continue;
                    set[next].add(cur);

                    // 진입차수 감소
                    if(in[next] > 0) in[next]--;
                }
            }
            // 건물을 파괴 => 해금을 다시 원래대로 복기
            else if(type == 2 && createdCnt[cur] > 0){
                createdCnt[cur] --;

                if(createdCnt[cur] != 0) continue;

                // 원래대로 돌리기
                for(int next: list[cur]) {
                    set[next].clear();
                    in[next] ++;
                }
            }
            // 건설 or 파괴가 불가능하다면
            else{
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "King-God-Emperor" : "Lier!");
    }

    private static boolean isCreate(int n) {
        for(int next: list[n])
            if(createdCnt[next] == 0) return false;

        return true;
    }
}