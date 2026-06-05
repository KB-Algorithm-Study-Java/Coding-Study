import java.util.*;

class Solution {
    int[] board;
    int answer;
    int n;

    public int solution(int n) {
        this.n = n;
        board = new int[n];
        answer = 0;

        dfs(n, 0);
        return answer;
    }

    void dfs(int queen, int r) {
        if(queen == 0) {
            answer ++;
            return;
        }

        for(int c = 0; c < n; c++) {
            board[r] = c;
            if(valid(r)) {
                dfs(queen-1, r+1);
            }
        }

    }

    boolean valid(int r) {
        // 같은 열의 있는 경우 검사
        for(int i = 0; i < r; i++) {
            if(board[r] == board[i]) return false;
            // 기울기가 1인 경우
            if(Math.abs(r-i) == Math.abs(board[r] - board[i])) return false;
        }
        return true;
    }
}