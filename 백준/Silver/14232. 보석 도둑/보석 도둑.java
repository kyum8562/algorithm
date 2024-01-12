import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long spare = N;
        List<Long> list = new ArrayList<>();
        for(long i = 2 ; i * i <= N ; i ++){
            while(spare % i == 0){
                list.add(i);
                spare /= i;
            }
        }
        if(spare > 1) list.add(spare);

        System.out.println(list.size());
        for(Long i: list)
            System.out.print(i + " ");
    }
}