import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        int cnt = 0; // 비내림차순이 아닌 경우의 개수
        int idx = 0; // 비내림차순이 아닌 경우의 인덱스

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            map[i] = Integer.parseInt(st.nextToken());
            if(i == 0) continue;
            if(map[i-1] > map[i]){
                cnt ++;
                idx = i-1;
            }
        }

        System.out.println(cal(cnt, idx));

    }

    private static int cal(int cnt, int idx) {
        if(cnt == 0) return N;
        else if(cnt > 1) return 0;
        else{
            if(N >= 3){
                if(idx == 0){
                    if(map[idx] <= map[idx+2]) return 2; // ex) 2 1 3
                    return 1; // ex) 2 1 1
                }
                else if(idx == N-2){
                    if(map[idx-1] <= map[idx+1]) return 2;
                    return 1;
                }
                else{
                    int res = 0;
                    if(map[idx-1] <= map[idx+1]) res ++;
                    if(map[idx] <= map[idx+2]) res ++;
                    return res;
                }
            }
            else return 1;
        }
    }
}