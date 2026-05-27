class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};

    //1,0 d 0,-1 -> l 0,1 ->r -1,0->u

    public static String solution(int n, int m, int x, int y,int r, int c, int k) {
        char[] w = {'d', 'l', 'r', 'u'};
        // dist 의 주어진 거리의 가장 가까운 거리 측정
        int dist = Math.abs(r-x) + Math.abs(c-y);
        // 애초에 도달 불가능경우
        if (dist > k ){
            return "impossible";
        }
        //남은 거리가 1,3,5면 못돌아감..?
        if( (k-dist)%2==1 ){return "impossible";}
        String answer = "";
        int cr = x;
        int cc = y;
        for (int i = 0; i < k; i++) { //1-> drlu중에 찾기
            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                // 범위 밖이면 나가
                if (nr < 1 || nr > n || nc < 1 || nc > m) {
                    continue;}
                //남은값이 k-i-1
                int remain = k-i-1; //남은 k
                int need = Math.abs(r-nr)+Math.abs(c-nc);
                // 이 방향으로 가도 도착 가능?
                if (need <= remain && (remain- need)%2==0) {
                    answer += w[d];
                    cr = nr;
                    cc = nc;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("result: dllrl");
        System.out.println(solution(3, 4,  2,  3,  3, 1 ,5));
        System.out.println("result: dr");
        System.out.println(solution(2,2,1,1,2,2,2));
        System.out.println("result: impossible");
        System.out.println(solution(3, 3,1,  2,3,3,4));
    }
}