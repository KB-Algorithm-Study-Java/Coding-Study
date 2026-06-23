package week8.징검;

import java.util.Arrays;

class Solution {

    public static int solution(int[] stones, int k) {

        int left = 0;
        int right = Arrays.stream(stones).max().getAsInt();
        while(left<=right){
            int mid = (left+right)/2;
            boolean checked = check(mid,stones,k);
            if(checked) left = mid+1;
            else{right = mid-1;}
        }
        return right;
    }
    public static boolean check(int mid,int[] stones, int k){
        // stones의 각 값에 연속되는 0? 값을 카운팅한다.
        // k보다 작다면 true를 반환하도록하ㅑ는 함수
        int count= 0;
        for(int stone : stones){
            if(stone-mid<0)count++;
            else{count = 0;} //연속된값만 카운팅
            if(count >= k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution(stones,3));
    }
}