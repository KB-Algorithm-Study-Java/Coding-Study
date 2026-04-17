import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1213번 팰린드롬 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Map<Character, Integer> alpha = new TreeMap<>();
        for(int i = 0; i < str.length(); i++)
            alpha.put(str.charAt(i), alpha.getOrDefault(str.charAt(i), 0) + 1);

        int odd = 0;
        char center = '\0';
        for(Map.Entry<Character,Integer> m : alpha.entrySet()) {
            if(m.getValue() % 2 != 0) {
                odd++;
                center = m.getKey();
                alpha.put(center, alpha.get(center)-1);
            }
        }

        if(odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        char[] rst = new char[str.length()];
        rst[rst.length / 2] = center;
        int left = 0, right = rst.length - 1;
        for(Map.Entry<Character, Integer> m : alpha.entrySet()) {
            char c = m.getKey();
            int cnt = m.getValue();
            while(cnt > 0) {
                rst[left] = c;
                rst[right] = c;
                left++;
                right--;
                cnt -= 2;
            }
        }
        System.out.println(rst);
    }
}
