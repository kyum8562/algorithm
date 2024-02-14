import java.io.*;
import java.util.*;

public class Main {
    static long X, ans, min;
    static List<Long> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());

        min = (X % 2 == 0) ? X/2 : X/2 + 1;

        ans = 0; // 꽉 채운 에센스 개수
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            long cur = Long.parseLong(st.nextToken());

            if(cur >= X) ans ++;
            else list.add(cur);
        }

        Collections.sort(list);

        twoPoint();
    }

    private static void twoPoint() {
        int s = 0;
        int e = list.size() - 1;
        int cnt = 0; // 가득차지 않은 에센스 개수

        while(e >= s){
            long sum = list.get(s) + list.get(e);

            // 가득찬 에센스를 만들 때
            if(e > s && sum >= min){
                ans ++;
                s ++;
                e --;
            }
            // 못만들 때
            else{
                cnt ++;
                s ++;
            }
        }

        // 가득차지 않은 에센스로 만들 수 있는 가득찬 에센스 구하기
        ans += cnt / 3;
        System.out.println(ans);
    }
}