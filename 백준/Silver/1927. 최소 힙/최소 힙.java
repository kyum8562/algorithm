import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if(input == 0){
                if(pq.size() == 0) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else{
                pq.offer(input);
            }
        }
    }
}