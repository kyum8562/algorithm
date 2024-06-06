import java.util.Scanner;
import java.util.Map;
import java.util.AbstractMap;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        // 테스트 케이스의 개수 T를 입력받음
        int T = sc.nextInt();
 
        for (int t = 0; t < T; t++) {
            // 학교의 개수 N을 입력받음
            int N = sc.nextInt();
 
            // 최대 술 소비량과 학교 이름을 찾음
            Map.Entry<String, Integer> maxAlcoholEntry = findMaxAlcoholConsumption(sc, N);
 
            // 술 소비가 가장 많은 학교 이름 출력
            System.out.println(maxAlcoholEntry.getKey());
        }
    }
    
    // 학교 이름과 술 소비량을 입력받고, 최대 술 소비량과 학교 이름을 반환하는 함수
    public static Map.Entry<String, Integer> findMaxAlcoholConsumption(Scanner sc, int N) {
        // 최대 술 소비량을 저장할 변수 초기화
        int maxAlcoholConsumption = -1;
        String maxAlcoholSchool = "";
 
        for (int i = 0; i < N; i++) {
            // 학교 이름과 술 소비량을 입력받음
            String schoolName = sc.next();
            int alcoholConsumption = sc.nextInt();
 
            // 최대 술 소비량인 경우 최대값과 해당 학교 이름을 업데이트
            if (alcoholConsumption > maxAlcoholConsumption) {
                maxAlcoholConsumption = alcoholConsumption;
                maxAlcoholSchool = schoolName;
            }
        }
 
        // 최대 술 소비량과 학교 이름을 Map.Entry 형태로 반환
        return new AbstractMap.SimpleEntry<>(maxAlcoholSchool, maxAlcoholConsumption);
    }
 
}