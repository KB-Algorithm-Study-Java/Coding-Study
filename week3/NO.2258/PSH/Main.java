package PSH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int totalWeight = 0;
        Map<Integer,Integer> tree = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i <N ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st1.nextToken());
            int p = Integer.parseInt(st1.nextToken());
            totalWeight += w;
            tree.put(p,w);
        }
        System.out.println(totalWeight);

        int opt = -1;
        for(var entry : tree.entrySet() ){
            opt = entry.getKey();
            if(totalWeight - entry.getValue() < M) break;
        }
        System.out.println(opt);
    }
}
