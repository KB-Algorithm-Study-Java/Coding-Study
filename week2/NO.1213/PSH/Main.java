package PSH;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //buffer 로 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] arr = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();

        //[AA,BB,CC]를 만드는 과정
        for(int i = 0; i < arr.length; i++) {
            String ch = String.valueOf(arr[i]);
            if(!result.contains(ch)) {
                result.add(ch);
            } else {
                int a = result.indexOf(ch);
                result.set(a, result.get(a) + ch);
            }
        }

        //[AA,BB,CC,D] ABC + D +  CBA <--- 이런식으로 조립하는 과정

        StringBuilder front = new StringBuilder();
        String middle = "";
        int odd = 0;  // 홀수 개수를 카운트 해야됌. -> 1개 이상이면 out

        for(String s : result) {
            int half = s.length() / 2;
            front.append(s.substring(0, half));
            if(s.length() % 2 == 1) {
                odd++;
                middle = String.valueOf(s.charAt(0));
            }
        }

        if(odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        System.out.println(front.toString() + middle + front.reverse().toString());
    }
}