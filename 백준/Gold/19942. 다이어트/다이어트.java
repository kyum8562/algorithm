import java.io.*;
import java.util.*;

public class Main {
    static int N, minVal;
    static StringBuilder sb;
    static int[] minimumVal, arr, arr2;
    static Node[] nutrient;
    static List<String> list;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        minimumVal = new int[4];
        nutrient = new Node[N];
        v = new boolean[N];
        list = new ArrayList<>();
        minVal = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            minimumVal[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nutrient[i] = new Node(a, b, c, d, e);
        }

        subSet(0);

        if(minVal == Integer.MAX_VALUE)
            System.out.println(-1);
        else{
            Collections.sort(list);
            System.out.println(minVal);
            System.out.println(list.get(0));
        }
    }

    private static void subSet(int depth) {
        if(depth == N){
            int protein = 0;
            int province = 0;
            int carbohydrate = 0;
            int vitamin = 0;
            int cost = 0;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if(!v[i]) continue;
                Node cur = nutrient[i];

                protein += cur.protein;
                province += cur.province;
                carbohydrate += cur.carbohydrate;
                vitamin += cur.vitamin;
                cost += cur.cost;
                cnt ++;
            }

            if(check(protein, province, carbohydrate, vitamin)){
                // 비용이 이전보다 더 작다면
                if(minVal >= cost){
                    // 최소비용 갱신
                    if(minVal > cost) list.clear();
                    sb = new StringBuilder();
                    for (int i = 0; i < N; i++)
                        if(v[i]) sb.append(i+1).append(" ");
                    list.add(sb.toString());
                    minVal = cost;
                }
            }

            return;
        }

        v[depth] = true;
        subSet(depth+1);

        v[depth] = false;
        subSet(depth+1);
    }

    private static boolean check(int protein, int province, int carbohydrate, int vitamin) {
        if(minimumVal[0] > protein) return false;
        if(minimumVal[1] > province) return false;
        if(minimumVal[2] > carbohydrate) return false;
        if(minimumVal[3] > vitamin) return false;

        return true;
    }

    static class Node{
        int protein, province, carbohydrate, vitamin, cost;
        public Node(int protein, int province, int carbohydrate, int vitamin, int cost){
            this.protein = protein;
            this.province = province;
            this.carbohydrate = carbohydrate;
            this.vitamin = vitamin;
            this.cost = cost;
        }
    }
}
/**
3
0 0 0 1
0 0 0 0 0
0 0 0 0 0
0 0 0 1 0
[ans]
0
1 2 3

3
0 0 0 1
0 0 0 1 1
0 0 0 0 0
0 0 0 0 0
[ans]
1
1
 */