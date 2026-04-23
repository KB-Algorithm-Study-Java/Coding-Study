import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1764 듣보잡
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> N_listen = new HashSet<>();
        ArrayList<String> rst = new ArrayList<>();
        for(int i = 0; i < N; i++) N_listen.add(br.readLine());
        for(int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if(N_listen.contains(tmp)) rst.add(tmp);
        }
        Collections.sort(rst);
        sb.append(rst.size()).append('\n');
        for(String s : rst) sb.append(s).append('\n');
        System.out.println(sb);
    }
}