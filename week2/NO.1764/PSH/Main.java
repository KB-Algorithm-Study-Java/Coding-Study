package PSH;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeMap<String, Integer> map = new TreeMap<>();
        // 듣도못한사람
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, 1);
        }
        // 보도못한사람
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (map.containsKey(name)) {
                map.put(name, 2);
            }
        }
        // 듣도보도못한사람
        ArrayList<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                result.add(key);
            }
        }
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}