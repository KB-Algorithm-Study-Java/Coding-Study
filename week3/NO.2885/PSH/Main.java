package PSH;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        // 2의 제곱찾기
        int A = 1;
        while (A < k) {
            A *= 2;
        }
        int size = A;
        int count = 0;

        while (k > 0) {

            if (k == A) break;

            int half = A / 2;
            count++;
            if (k <= half) {
                A = half;
            } else {
                k -= half;
                A = half;
            }
        }

        System.out.println(size + " " + count);
    }
}