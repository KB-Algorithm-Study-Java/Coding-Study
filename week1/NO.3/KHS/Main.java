package KHS;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);

        // 보드판의 크기 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        // NxM 크기의 보드판 2차원 문자 배열 생성
        char[][] board = new char[N][M];

        // 색깔 받기 전 앞에서 nextInt()를 써서 버퍼에 남은 엔터를 처리해주기
        sc.nextLine();

        // 보드판 색깔 입력받기
        for (int i = 0; i < board.length; i++) {
            // 문자열 받기
            String color = sc.next();
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = color.charAt(j);
            }
        }

        // 다시 칠해야 하는 정사각형의 개수
        // 최솟값 갱신이 필요
        int countB = 0;
        int countW = 0;

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j < M-8; j++) {
                // B(검정)이 시작일 경우
                for (int k = 0; k < 8; k++) {
                    for (int m = 0; m < 8; m++) {
                        // 검정이 아닐 경우
                        if((k+m)%2==0) {
                            if(board[i + k][j + m] != 'B') {
                                countB ++;
                            }
                        }

                        if((k+m)%2==1) {
                            if(board[i + k][j + m] != 'W') {
                                countB ++;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j < M-8; j++) {
                // B(검정)이 시작일 경우
                for (int k = 0; k < 8; k++) {
                    for (int m = 0; m < 8; m++) {
                        // 검정이 아닐 경우
                        if((k+m)%2==0) {
                            if(board[i + k][j + m] != 'W') {
                                countW ++;
                            }
                        }

                        if((k+m)%2==1) {
                            if(board[i + k][j + m] != 'B') {
                                countW ++;
                            }
                        }
                    }
                }
            }
        }

        int result = (countB > countW) ? countW : countB;

        System.out.println(result);
    }
}
