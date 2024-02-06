import java.io.*;
import java.util.*;

public class Main {
    static int M, N, L;
    static int[] shootingLocation;
    static Node[] animals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 사대의 수
        N = Integer.parseInt(st.nextToken()); // 동물의 수
        L = Integer.parseInt(st.nextToken()); // 사정거리

        shootingLocation = new int[M];
        animals = new Node[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            shootingLocation[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

//            if (b > L) continue;
            animals[i] = new Node(a, b);
        }

        int ans = 0;
        for (int i = 0; i < N; i++){
            if(animals[i].y > L) continue;
            ans += binarySearch(i);
        }

        System.out.println(ans);
    }
    private static int binarySearch(int i) {
        int s = 0;
        int e = M-1; // 사대의 범위
        int m = 0;

        // 동물 기준에서 사대가 있을만한 범위 체크
        int max = animals[i].x + (L - animals[i].y);
        int min = animals[i].x - (L - animals[i].y);

        while(e >= s){
            m = (s + e) / 2;
            int res = shootingLocation[m];

            // 해당 범위내에 사대가 있다면 -> 잡힘
            if(res >= min && res <= max) return 1;
            // max 범위보다 크다면 -> e줄여 범위 줄이기
            else if(res > max) e = m - 1;
            // min 범위보다 작다면 -> s늘려 범위 줄이기
            else s = m + 1;
        }

        // 잡히지 않음
        return 0;
    }
    static class Node{
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}