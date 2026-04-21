import java.io.*;
import java.nio.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int total = 0;

        TreeMap<String, Integer> group = new TreeMap<>();
        for (int i = 0; i < N+M; i++) {
            String name = br.readLine();
            group.put(name, group.getOrDefault(name,0)+1);
            if(group.get(name) == 2) total++;
        }

        System.out.println(total);
        for (String s : group.keySet()) {
            if(group.get(s) == 2) {
                System.out.println(s);
            }
        }
    }
}

