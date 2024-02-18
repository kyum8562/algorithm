import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[] moem = {'a', 'e', 'i', 'o', 'u'};
    static char[] map, choice;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N];
        choice = new char[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            map[i] = st.nextToken().charAt(0);

        Arrays.sort(map);
        
        // 치킨 집 찾기
        perm(0, 0);

        System.out.println(sb);
    }

    private static void perm(int depth, int start) {
        if(depth == M){
            String s = "";
            int moemCnt = 0;
            int jaemCnt = 0;
            for(int i = 0 ; i < M ; i ++){
                s += choice[i];
                if(isMoem(choice[i])) moemCnt ++;
                else jaemCnt ++;
            }

            if(moemCnt >= 1 && jaemCnt >= 2)
                sb.append(s).append("\n");
            return;
        }

        for(int i = start ; i < N ; i ++){
            choice[depth] = map[i];
            perm(depth+1, i+1);
        }
    }

    private static boolean isMoem(char c) {
        boolean flag = false;
        for(int i = 0 ; i < 5 ; i ++){
            if(moem[i] == c){
                flag = true;
                break;
            }
        }
        if(flag) return true;
        else return false;
    }
}