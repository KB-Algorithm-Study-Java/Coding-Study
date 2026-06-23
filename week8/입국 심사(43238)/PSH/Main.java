package week8.입국;

import java.util.*;

class Solution {
    public static long solution(int n, int[] times) {
        long left = 1 ;
        long right = Arrays.stream(times).max().getAsInt() * n;

        while(left<=right){
            long mid = (right+left)/2;
            long count=0;
            for (int time : times) {
                count += mid/time;
            }
            if(count >=n){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] times = {7,10};
        System.out.println(solution(6,times));
    }
}
