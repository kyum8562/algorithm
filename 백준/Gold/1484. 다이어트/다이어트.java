import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int s=1, e=2;
        while(e > s) {
            long tmp = e*e - s*s;
            if(tmp > N && e == s + 1) break;
            if(tmp == N) {
                sb.append(e).append("\n");
                e++;
            }
            else if(tmp > N) s++;
            else e++;
        }
        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}