package KHS;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 집단의 속한 사람의 숫자를 입력 받는다.
        int N = sc.nextInt();

        // 사람들의 몸무게와 키를 담을 2차원 배열을 생성한다.
        int[][] group = new int[N][2];

        // 사람들의 몸무게와 키를 입력 받는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                group[i][j] = sc.nextInt();
            }
        }

        // 덩치를 비교해 등수를 구한다.
        int[] rank = new int[N];

        // 덩치가 큰 기준은 키와 몸무게가 모두 높아야 함 비교를 못하면 같은 등수
        // 결국 나보다 큰 사람을 count에 넣고 + 1 -> 내 등수
        int count = 0;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                 if((group[k][0] < group[i][0]) && (group[k][1] < group[i][1])) {
                    count++;
                }
            }
            rank[k] = count+1;
            count = 0;
        }

        for (int i = 0; i < rank.length; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}
