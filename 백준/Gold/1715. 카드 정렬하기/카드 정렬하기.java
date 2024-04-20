import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i ++)
            pq.offer(Long.parseLong(br.readLine()));

        long res = 0;
        while(pq.size() > 1){
            long a = pq.poll();
            long b = pq.poll();

            res += a+b;
            pq.offer(a+b);
        }

        System.out.print(res);
    }
}