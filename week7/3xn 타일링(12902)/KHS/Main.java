class Solution {
    public long solution(int n) {
        long[] floor = new long[n+1];
        floor[2] = 3;

        for(int i = 4; i <= n; i+=2) {
            // 초기 값 설정 (이전꺼 * 2인 경우 + 새로운 조합 2개)
            floor[i] = floor[i-2]*floor[2] + 2;


            // 통짜 부품 경우 붙이기
            for(int j = 2; j <= i-4; j+=2) {
                floor[i] += floor[j]*2;
            }

            floor[i] = floor[i]%1000000007;
        }

        return floor[n];
    }
}