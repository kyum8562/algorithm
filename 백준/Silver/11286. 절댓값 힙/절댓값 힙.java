import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) > Math.abs(o2)) return (Math.abs(o1) - Math.abs(o2));
            else if(Math.abs(o1) == Math.abs(o2)) return (o1 - o2);
            else{
                return (Math.abs(o1) - Math.abs(o2));
            }
        });
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pq.size() == 0) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
            else pq.offer(input);
        }
        System.out.println(sb);
    }
}