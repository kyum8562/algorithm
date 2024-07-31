import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 단어의 수를 입력 받음

        Set<String> set = new HashSet<>(); // 중복을 제거하기 위해 Set을 사용

        for (int i = 0; i < n; i++) {
            String s = br.readLine(); // 단어를 입력 받음

            set.add(s); // 입력 받은 단어를 Set에 추가

            StringBuilder sb = new StringBuilder(s);
            String reverse = sb.reverse().toString(); // 입력 받은 단어를 뒤집어서 새로운 문자열 만듬

            if (set.contains(reverse)) { // 뒤집은 문자열이 Set에 있는지 확인하여 비밀번호인지 검사
                System.out.println(reverse.length() + " " + reverse.charAt(reverse.length() / 2));
                // 비밀번호의 길이와 가운데 글자를 출력
                break; // 비밀번호를 찾았으므로 반복문을 종료
            }
        }
    }
}