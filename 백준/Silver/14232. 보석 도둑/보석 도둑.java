import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

// 소인수 분해
// 리스트에 담아서 출력하려고 했는데 시간초과 고려해 sb에 넣고 출력
public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long K0 = Long.parseLong(br.readLine());
    StringBuilder sb = new StringBuilder();
    
    long cnt = 0,K=K0;
    
    // int로 돌고 long으로 형변환 X -> long으로 for 루프
    for(long i = 2 ; i*i <= K0 && K>1 ; i ++) {
        while(K%i == 0) {
            cnt++;
            sb.append(i);
            sb.append(" ");
            K/=i;
        }
    }
    if(K>1) {
        cnt++;
        sb.append(K);
    }
    // 출력
//        sb.insert(0,  cnt + "\n");
        System.out.println(cnt);
        System.out.println(sb);
    }

}