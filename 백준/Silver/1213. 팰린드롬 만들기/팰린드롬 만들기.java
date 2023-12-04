import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* 1. 팰린드롬 판별(개수를 세고, 홀수의 개수가 1개를 초과하면 X)
* 2. 팰린드롬 생성
    1) 짝수에 해당하는 값
    2) 홀수일 경우 가운데에 오는 값
    3) sb.reverse()로 뒤집은 값
*/
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] alpha = new int[26];
		for(int i=0; i<line.length(); i++) {
			int idx = line.charAt(i)-'A';
			alpha[idx]++;
		}
		
		int isOne =0;
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i]%2!=0) isOne++;
		}
		
		String answer ="";
		StringBuilder sb = new StringBuilder();
		if(isOne>1) answer += "I'm Sorry Hansoo";
		else {
			for(int i=0; i<alpha.length; i++) {
				for(int r=0; r<alpha[i]/2; r++) {
					sb.append((char)(i+65));
				}
			}
			answer += sb.toString();
			String end = sb.reverse().toString();
			
			sb = new StringBuilder();
			for(int i=0; i<alpha.length; i++) {
				if(alpha[i]%2==1) {
					sb.append((char)(i+65));
				}
			}
			answer +=sb.toString()+end;
		}
		System.out.println(answer);
	}
		
}