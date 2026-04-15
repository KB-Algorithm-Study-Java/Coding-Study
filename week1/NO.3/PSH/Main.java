import java.util.*;

public class Main {
    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }


        //처리
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (w[j] > w[i] && h[j] > h[i]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}