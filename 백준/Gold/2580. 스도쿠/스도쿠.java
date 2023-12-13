import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map = new int[9][9];
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0 ; i < 9 ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 9 ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) list.add(new int[]{i, j});
            }
        }
        N = list.size();
        perm(0);

    }

    private static void perm(int depth) {
        if(depth == N){
            printMap();
            System.exit(0);
        }
        for(int i = 1 ; i <= 9 ; i ++){
            int[] curr = list.get(depth);
            if(isTrue(curr, i)){
                map[curr[0]][curr[1]] = i;
                perm(depth+1);
                map[curr[0]][curr[1]] = 0;
            }
        }
    }

    private static boolean isTrue(int[] curr, int tgt) {
        // 열이 모두 같은지 체크
        for(int i = 0 ; i < 9 ; i ++){
            if(curr[1] == i) continue;
            if(map[curr[0]][i] == tgt) return false;
        }
        // 행이 모두 같은지 체크
        for(int i = 0 ; i < 9 ; i ++){
            if(curr[0] == i) continue;
            if(map[i][curr[1]] == tgt) return false;
        }

        // 작은 사각형이 모두 같은지 체크
        int a = (curr[0]/3)*3;
        int b = (curr[1]/3)*3;
        for(int i = a ; i < a+3 ; i ++){
            for(int j = b ; j < b+3 ; j ++){
                if(i == curr[0] && j == curr[1]) continue;
                if(map[i][j] != 0 && map[i][j] == tgt) return false;
            }
        }
        return true;
    }

    private static void printMap() {
        for(int i = 0 ; i < 9 ; i ++){
            for(int j = 0; j < 9 ; j ++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}