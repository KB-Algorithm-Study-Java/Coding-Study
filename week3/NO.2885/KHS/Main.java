import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int choco = 1;

        // 전체 초콜릿 크기 구하기
        while (choco < K) {
            chocho *= 2;
        }

        int totalChoco = choco;
        int divCount = 0;

        while (K > 0) {
            if (K >= choco) {
                K -= choco;
            } else {
                choco /= 2;
                divCount++;
            }
        }
        System.out.println(totalChoco + " " + divCount);
    }
}