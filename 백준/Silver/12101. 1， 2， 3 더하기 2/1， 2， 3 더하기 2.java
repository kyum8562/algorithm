import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] map, choice;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N];
        choice = new int[N];

        perm(0);
        Collections.sort(list);

        if(K-1 <= list.size()-1)
            System.out.println(list.get(K-1).substring(0, list.get(K-1).length()-1));
        else
            System.out.println("-1");
    }

    private static void perm(int depth) {
        if(depth == N){
            String s = "";
            int sum = 0;

            for(int i = 0 ; i < N ; i ++){
                sum += choice[i];
                if(choice[i] != 0) s += choice[i] + "+";
            }

            if(sum == N && !list.contains(s))
                list.add(s);

            return;
        }

        for(int i = 0 ; i < 4 ; i ++){
            choice[depth] = i;
            perm(depth+1);
        }
    }
}