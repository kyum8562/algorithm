import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();
        int[][] blocks = new int[n][2];

        for (int i = 0; i < n; i++) {
            blocks[i][0] = sc.nextInt(); // 블록 크기의 지수
            blocks[i][1] = sc.nextInt(); // 블록 개수
        }

        System.out.println(fillBox(l, w, h, blocks));
    }

    public static int fillBox(int l, int w, int h, int[][] blocks) {
        Arrays.sort(blocks, (a, b) -> b[0] - a[0]); // 블록 크기 순으로 정렬
        long totalCount = 0;
        long volume = (long) l * w * h; // 상자의 전체 부피
        long usedVolume = 0;

        for (int i = 0; i < blocks.length; i++) {
            long size = (1 << blocks[i][0]); // 블록의 한 변 크기
            int count = blocks[i][1];

            if (volume <= usedVolume) {
                break; // 상자를 이미 채웠다면 종료
            }

            long maxCount = (l / size) * (w / size) * (h / size); // 현재 크기로 채울 수 있는 최대 개수
            maxCount -= usedVolume / (size * size * size); // 이미 채워진 공간 제외
            long useCount = Math.min(count, maxCount);

            usedVolume += useCount * (size * size * size);
            totalCount += useCount;
        }

        // 상자를 다 채웠는지 확인
        if (usedVolume == volume) {
            return (int) totalCount;
        } else {
            return -1;
        }
    }
}