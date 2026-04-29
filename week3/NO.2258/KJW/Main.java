import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    //2258 정육점
    static int N, M;
    static long rst = Long.MAX_VALUE;
    static List<long[]> meat, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        meat = new ArrayList<>();
        sum = new ArrayList<>();
        while(N-->0) {
            st = new StringTokenizer(br.readLine());
            meat.add(new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())});
        }

        meat.sort((a, b) -> {
            int cmp = Long.compare(a[1], b[1]);
            if(cmp == 0) return Long.compare(b[0], a[0]); // 비용 같으면 무게 내림차순
            return cmp;
        });

        sum.add(new long[]{meat.get(0)[0], meat.get(0)[1]});
        long prev = meat.get(0)[1];
        for(int i = 1; i < meat.size(); i++) {
            long[] top = sum.get(i-1), cur = meat.get(i);

            if(cur[1] != prev){
                sum.add(new long[]{top[0] + cur[0], cur[1]});
                prev =  cur[1];
            }
            else sum.add(new long[]{top[0] + cur[0], top[1]+ cur[1]});
        }

        for(long[] i : sum) if(i[0] >= M) rst = Math.min(rst, i[1]);
        System.out.println(rst == Long.MAX_VALUE ? -1 : rst);
    }
}