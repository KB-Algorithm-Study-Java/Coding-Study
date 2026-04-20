package PSH;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String,Integer> dna = new TreeMap<>();

        String input;
        int count = 0;
        while(true){
            input = br.readLine();
            if(input == null || input.isEmpty()) break;
            dna.put(input,dna.getOrDefault(input,0)+1);
            count ++;
        }
        final int total = count;
        //StringBuilder sb = new StringBuilder();
        dna.forEach((k, v) -> {
            // double count = v/(t*100);
            //sb.append(("%s %.4f\n", k, (double) v / total * 100);
            System.out.printf("%s %.4f\n",k, (double) v/total*100);
        });
        //System.out.println(sb);
    }
}
