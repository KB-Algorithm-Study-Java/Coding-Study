import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //1138번 한 줄로 서기
    static int N;
    static List<int[]> height;
    static List<Integer> rst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        height = new ArrayList<>();
        rst = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) height.add(new int[]{i+1, Integer.parseInt(st.nextToken())});
        height.sort((a, b) -> a[1] - b[1]);

        for(int i = 0; i < height.size(); i++) {
            boolean flag = true;
            int cnt = 0;
            int[] cur = height.get(i);
            for(int j = 0; j < rst.size(); j++) {
                if(rst.get(j) > cur[0]) {
                    if(cnt == cur[1]) {
                        rst.add(j, cur[0]);
                        flag = false;
                        break;
                    }
                    cnt++;
                }
            }
            if(flag) rst.add(cur[0]);
        }
        for(int i : rst) System.out.print(i + " ");
    }
}