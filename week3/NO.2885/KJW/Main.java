import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2885번 초콜릿 식사
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        int choco = Integer.highestOneBit(K);
        if(choco != K) {
            int cnt = Integer.SIZE - Integer.numberOfLeadingZeros(K) - Integer.numberOfTrailingZeros(K);
            System.out.println(choco * 2 + " " + cnt);
            return;
        }
        System.out.println(choco + " "  + 0);
    }
}