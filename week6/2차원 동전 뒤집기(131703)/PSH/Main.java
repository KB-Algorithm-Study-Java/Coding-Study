class Solution131703 {
    static int m ;
    static int row;
    static int col;
    static int count = Integer.MAX_VALUE;
    public static int solution(int[][] beginning, int[][] target) {
        row = beginning.length;
        col = beginning[0].length;
        m = row + col;
        dfs(m, beginning,target,0); //

        return count == Integer.MAX_VALUE ? -1 : count; // ((수정))!!
    }
    static void dfs(int n,int[][] begin,int[][] target,int temp){
        //begin이 target과 같다면 count반납
        if(same(begin,target)){
            count = Math.min(count,temp);
            return;
        }
        //n==1일때 다르면 return;
        if(n==0){
                return;
        }
        turn(begin,n); //뒤집기
        dfs(n-1, begin, target, temp + 1);

        turn(begin,n); //원상복구
        dfs(n-1,begin,target,temp);

    }
    static boolean same(int[][] begin,int[][] target){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(begin[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    static void turn(int[][] begin, int k){
        //k행ork열을 뒤집을것이다.
        if(k<= row){
            for (int i = 0; i < col; i++) {
                if(begin[k-1][i] == 0) begin[k-1][i] =1;
                else{
                    begin[k-1][i] = 0;
                }
            }
        }else{
            for (int i = 0; i < row; i++) {
                if(begin[i][k-row-1] == 0) begin[i][k-row-1] =1;
                else{
                    begin[i][k-row-1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] begin = {{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0},{1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int[][] target = {{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        //int[][] begin = {{0,1,1},{0,0,1},{0,1,1}};
        //int[][] target = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(solution(begin,target));
    }
}