import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static public void main(String[] args) throws IOException {
        BjSolution sol = new BjSolution();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sol.solution(br.readLine());
    }
}

class BjSolution {
    public void solution(String inputVal) {
        int ans = 0;

        if (inputVal.length() == 1) {
            System.out.println(Integer.parseInt(inputVal));
            return;
        }

        if (inputVal.startsWith("0")) {
            if (inputVal.charAt(1) == 'x') {
                ans = Integer.parseInt(inputVal.substring(2), 16);
            } else {
                ans = Integer.parseInt(inputVal, 8);
            }
        } else {
            ans = Integer.parseInt(inputVal, 10);
        }

        System.out.println(ans);
    }
}