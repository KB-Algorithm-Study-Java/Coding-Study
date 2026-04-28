import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 크기 N의 배열 선언 0으로 초기화
        int[] people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            int line = Integer.parseInt(st.nextToken());
            int count = 0; // 빈칸 세기 빈칸의 기준은 값이 0인것

            for (int j = 0; j < N; j++) {
                if(people[j] == 0) {
                    if(count == line) {
                        people[j] = i+1;
                        break;
                    }
                    count++;
                }
            }
        }

        for (int person : people) {
            System.out.print(person + " ");
        }
    }
}