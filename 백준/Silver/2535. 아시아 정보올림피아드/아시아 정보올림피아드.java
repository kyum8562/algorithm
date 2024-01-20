import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, d));
        }

        Collections.sort(list);

        int[] nationMedalCnt = new int[N+1];
        int allMedalCnt = 0;
        for(Node cur: list){
            if(allMedalCnt == 3) break;
            // 메달 더 이상 받지 못하는 나라
            if(nationMedalCnt[cur.nation] < 2){
                System.out.println(cur.nation + " " + cur.num);
                nationMedalCnt[cur.nation] ++;
                allMedalCnt ++;
            }
        }
    }
    static class Node implements Comparable<Node>{
        int nation, num, point;
        public Node(int nation, int num, int point){
            this.nation = nation;
            this.num = num;
            this.point = point;
        }

        @Override
        public int compareTo(Node o){
            return o.point - this.point; // 내림차순
        }
    }
}