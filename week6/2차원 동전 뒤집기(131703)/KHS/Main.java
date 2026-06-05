class Solution {
    int[][] beginning;
    int[][] target;
    int[][] board1;
    int r, c;
    int count = 0;

    public int solution(int[][] beginning, int[][] target) {
        this.beginning = beginning;
        this.target = target;
        r = target.length;
        c = target[0].length;

        // 원본 배열 복사 메서드
        board1 = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                board1[i][j] = beginning[i][j];
            }
        }



        // 0 검정 1 흰색
        int r1 = reverse(beginning);
        System.out.println(r1);

        // 여기서 뒤집는 로직이 있어야 할듯
        count = 1;
        colCoinReverse(board1, 0);
        int r2 = reverse(board1);

        int minResult;
        if (r1 == -1) minResult = r2;
        else if (r2 == -1) minResult = r1;
        else minResult = Math.min(r1, r2);
        return minResult;
    }

    int reverse(int[][] board) {
        // 행 검사
        for(int i = 0; i < r; i++) {
            if(board[i][0] != target[i][0]) {
                rowCoinReverse(board, i);
                count++;
            }
        }

        // 열 검사
        for(int i = 1; i < c; i++) {
            if(board[0][i] != target[0][i]) {
                colCoinReverse(board, i);
                count++;
            }
        }

        // 전체 검사
        for(int i = 0; i < c; i++) {
            if(notVaild(board, i)) return -1;
        }

        return count;
    }

    // 타겟 열과 현재 동전판의 상태가 같은지 확인하는 메서드
    boolean notVaild(int[][] board, int col) {
        for(int i = 0; i < r; i++){
            if(board[i][col] != target[i][col]) return true;
        }
        return false;
    }

    // 특정 행과 열의 동전을 뒤집는 메서드
    void rowCoinReverse(int[][] board, int row) {
        for(int i = 0; i < c; i++) {
            if(board[row][i] == 0) {
                board[row][i] = 1;
            } else {
                board[row][i] = 0;
            }
        }
    }

    void colCoinReverse(int[][] board, int col) {
        for(int i = 0; i < r; i++) {
            if(board[i][col] == 0) {
                board[i][col] = 1;
            } else {
                board[i][col] = 0;
            }
        }
    }
}