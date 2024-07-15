import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, len;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        N = Integer.parseInt(st.nextToken()); // 현재 휴게소 개수
        M = Integer.parseInt(st.nextToken()); // 더 지으려는 휴게소 개수
        L = Integer.parseInt(st.nextToken()); // 고속도로의 길이

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            list.add(Integer.parseInt(st.nextToken()));

        list.add(0);
        list.add(L);

        len = list.size();

        Collections.sort(list);

        System.out.println(bs());
    }

    private static int bs() {
        int s = 1;
        int e = L;
        int m;
        int cnt;

        while(e >= s){
            m = (s + e) / 2;

            cnt = availCnt(m);

            if(cnt > M) s = m + 1;
            else e = m - 1;
        }

        return s;
    }

    private static int availCnt(int m) {
        int res = 0;

        for(int i = 1 ; i < len ; i ++)
           res += (list.get(i) - list.get(i-1) - 1) / m;

        return res;
    }
}