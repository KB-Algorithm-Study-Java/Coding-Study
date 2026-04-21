import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> ABC = new TreeMap<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            String parsingChar= String.valueOf(input.charAt(i));

            ABC.put(parsingChar, ABC.getOrDefault(parsingChar, 0) + 1);
        }

        int oddABC = 0;
        String center = "";
        for (String s : ABC.keySet()) {
            if(ABC.get(s) %2 != 0) {
                oddABC++;
                if(oddABC >= 2) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                center = s;
            }
            for (int i = 0; i < ABC.get(s)/2; i++) {
                sb.append(s);
            }
        }

        String left = sb.toString();
        System.out.println(left+center+sb.reverse());
    }
}