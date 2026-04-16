import java.io.*;
import java.util.*;
import java.lang.*;
public class Main {
    //4358 생태학
    static String t_name;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> Tree = new TreeMap<>();
        int total = 0;
        while(true) {
            t_name = br.readLine();
            if(t_name == null) break;
            total++;
            Tree.put(t_name, Tree.getOrDefault(t_name, 0) + 1);
        }
        for(Map.Entry<String, Integer> m : Tree.entrySet()) {
            String key = m.getKey();
            int value = m.getValue();
            double result = (value * 100.0) / total;
            System.out.printf("%s %.4f\n", key, result);
        }
    }
}
