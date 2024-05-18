import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cnt = 0;
		String str = "";
		while (true) {
			str = sc.nextLine().toLowerCase(); // 다 소문자로 변환해서 대소문자 구분없게 해주기
			if (str.equals("#")) {
				break; // # 들어오면 break
			}

			// 문장 쪼개서 배열에 넣어주기
			String arr[] = str.split("");
			for (int i = 0; i < arr.length; i++) {

				if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o")
						|| arr[i].equals("u")) {
					cnt++;
				}
			}
			System.out.println(cnt);
			cnt = 0;// 문장바뀌면 0으로 초기화해주기
		}
	}

}