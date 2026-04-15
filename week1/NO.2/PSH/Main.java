import java.util.*;

public class Main {
    public static void main(String[] args) {
        //입력부분
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] input = new int[n][3];

        for (int i = 0; i < n; i++) {
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt(); 
            input[i][2] = sc.nextInt(); 
        }
        //처리부분
        int answer = 0;
        for (int i = 123; i <= 987; i++) {
            String a = i + "";
            // 중복제거해야됨
            if (a.charAt(0)==a.charAt(1) || a.charAt(1)==a.charAt(2) || a.charAt(0)==a.charAt(2)) {
                continue;
            }

            boolean ok = true;

            for (int j = 0; j < n; j++) {
                String b = input[j][0] + "";

                int s = 0, ball = 0;

                // strike
                for (int k = 0; k < 3; k++) {
                    if (a.charAt(k) == b.charAt(k)) s++;
                }

                // ball
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (x != y && a.charAt(x) == b.charAt(y)) ball++;
                    }
                }

                if (s != input[j][1] || ball != input[j][2]) {
                    ok = false;
                    break;
                }
            }

            if (ok==true) answer++;
        }

        System.out.println(answer);
    }
}