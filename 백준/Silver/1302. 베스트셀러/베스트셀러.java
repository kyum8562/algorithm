import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();

        int max = 0;
        String res = "";
        for (int i = 0; i < N; i++) {
            String cur = br.readLine();
            if(map.getOrDefault(cur, 0) == 0)
                map.put(cur, 1);
            else
                map.put(cur, map.get(cur) + 1);

            max = Math.max(max, map.get(cur));
        }

        for(String val: map.keySet()){
            int curVal = map.get(val);
            if(curVal == max) list.add(val);
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}