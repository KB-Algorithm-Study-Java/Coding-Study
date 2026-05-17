package PSH;
import java.util.*;
class Solution {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static int[] solution(String[][] places) {
        int[] result = new int[5];
        List<List<int[]>> person = new ArrayList<>();
        int[][][] grid = new int[5][5][5];

        //places -> p 값 찾아내기
        for(int i=0;i<5;i++){
            person.add(new ArrayList<>());
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(places[i][j].charAt(k)=='P'){
                        person.get(i).add(new int[] {j,k});
                    }
                    if(places[i][j].charAt(k)=='X'){
                        grid[i][j][k] = 1;
                    }
                }
            }
        }
        //for문에 bfs
        for(int i=0;i<5;i++){
            int count = 0;
            for(int j=0;j<person.get(i).size()-1;j++){
                for(int k=0;k<person.get(i).size();k++){
                    if(j==k) continue;
                    //System.out.println("i:"+i+"p"+person.get(i).get(p)[1]);
                    int[] start = person.get(i).get(j);
                    int[] dest = person.get(i).get(k);
                    count += bfs(start,dest,grid,i); //j-->k
                }
            }
            if(count==0) result[i] =1;
        }

        return result;
    }
    static int bfs(int[] start, int[] dest, int[][][] grid, int i){
        boolean[][] visited = new boolean[5][5]; //i번째 r과c방문
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0],start[1],0}); //dist
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int dist = cur[2];

            if(cr==dest[0] && cc==dest[1]){
                if(dist<=2){
                    return 1;
                }
                return 0;
            }
            for(int j=0;j<4;j++){
                int nr = cr+dr[j];
                int nc = cc+dc[j];
                if(nr>=0&&nr<5&&nc>=0&&nc<5){
                    if(!visited[nr][nc] && grid[i][nr][nc]==0){
                        queue.offer(new int[] {nr,nc,dist+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return 0;

        //return할 값은 -> 경로없으면 0리턴, 거리가 2넘어가면 0리턴
        // 도착했을때 : 거리가 2보다 작으면 return 1
    }
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] result = solution(places);
        Arrays.stream(result).forEach(System.out::print);
    }
}