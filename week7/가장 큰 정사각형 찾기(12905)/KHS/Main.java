import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;

        int[][] map = new int[row+1][col+1];

        // 배열 복사
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                map[i+1][j+1] = board[i][j];
            }
        }

        // 인덱스 에러 방지를 위해 1부터 시작
        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                // 현재 칸이 1일 때만 검사
                if(map[i][j] != 0) {
                    // 3가지 방향 중 가장 작은 값에 1을 더함
                    map[i][j] = Math.min(Math.min(map[i-1][j], map[i][j-1]), map[i-1][j-1]) + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        return answer * answer;
    }
}