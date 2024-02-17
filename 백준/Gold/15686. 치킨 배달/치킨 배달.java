import java.io.*;
import java.util.*;

public class Main {
    static int N, M, min, chickenHouseLen, houseLen;
    static int[] choice, countArr;
    static int[][] map;
    static List<int[]> chickenHouse, house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        choice = new int[M];
        min = Integer.MAX_VALUE;

        chickenHouse = new ArrayList<>();
        house = new ArrayList<>();

        for(int i = 0 ; i < N ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j ++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;

                if(tmp == 1)
                    house.add(new int[] {i, j});
                else if(tmp == 2)
                    chickenHouse.add(new int[] {i, j});
            }
        }

        chickenHouseLen = chickenHouse.size();
        houseLen = house.size();

        // 치킨 집 찾기
        perm(0, 0);

        System.out.println(min);
    }

    private static void perm(int depth, int start) {
        if (depth == M) {
            countArr = new int[houseLen];
            Arrays.fill(countArr, Integer.MAX_VALUE);

            play();
            min = Math. min(min, counting());
            return;
        }
        for (int i = start; i < chickenHouseLen; i++) {
            choice[depth] = i;
            perm(depth+1, i+1);
        }
    }

    private static int counting() {
        int sum = 0;
        for(int v: countArr)
            sum += v;
        return sum;
    }

    private static void play() {
        for(int i = 0 ; i < M ; i ++){
            int cur = choice[i];
            int r = chickenHouse.get(cur)[0];
            int c = chickenHouse.get(cur)[1];

            for(int j = 0 ; j < houseLen ; j ++){
                int dist = Math.abs(house.get(j)[0] - r) + Math.abs(house.get(j)[1] - c);
                countArr[j] = Math.min(countArr[j], dist);
            }
        }
    }
}