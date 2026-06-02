class Solution {
    static int count = 0;
    static int[][] visited;
    public static int solution(int n) {
        visited = new int[n][n];
        dfs(n,0);
        return count;
    }
    static void dfs( int n, int x ){
        if(x == n){
            count++;
            return;
        }
        for(int y=0;y<n;y++){
            if(visited[x][y] == 0){
                // 방문처리하기
                for(int h=0;h<n;h++){
                    visited[x][h] +=1;
                    visited[h][y] +=1;
                    if((x+h+1 < n ) && (y+h+1<n) ){
                        visited[x+h+1][y+h+1] +=1;
                    } if((x+h+1 < n ) && (y-h-1 >= 0) ){
                        visited[x+h+1][y-h-1] +=1;
                    }
                }
                dfs(n,x+1);
                //방문처리 해제
                for(int h=0;h<n;h++){
                    visited[x][h] -= 1;
                    visited[h][y] -= 1;
                    if((x+h+1 < n ) && (y+h+1<n) ){
                        visited[x+h+1][y+h+1] -=1;

                    } if((x+h+1 < n ) && (y-h-1 >= 0) ){
                        visited[x+h+1][y-h-1] -=1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("최종결과: "+solution(4));
    }
}