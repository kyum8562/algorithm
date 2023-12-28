import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int suggestionCount = Integer.parseInt(br.readLine());
		int[] suggestions = new int[suggestionCount];
		
		// 입력 받기
		for (int i = 0; i < suggestionCount; i++) {
			suggestions[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(suggestions); // 입력 받고 정렬한다.
		int cutAmount = (int) Math.round(suggestionCount * 0.15); // 절사평균을 내기 위해 제외할 난이도 제안의 개수
		
		// 제외될 개수 만큼의 난이도 제안을 제외한 합을 구한다.
		int sum = 0;
		for (int i = 0; i < suggestionCount; i++) {
			if (i < cutAmount || i > suggestionCount - 1 - cutAmount) {
				continue;
			}
			sum += suggestions[i];
		}
		
		// 평균을 구한다. sum, suggestionCount, cutAmount 모두 int 타입으로, 결과 값으로 정수가 나오게 되므로 명시적 형변환을 해줌에 주의.
		int result = (int) Math.round((double) sum / (suggestionCount - cutAmount * 2));
		System.out.println(result);
	}

}