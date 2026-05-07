import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> s = new Stack<>();

        for(int i = 0; i < prices.length; i++) {
            while(!s.isEmpty() && s.peek()[1] > prices[i]) {
                int[] cur = s.pop();
                answer[cur[0]] = i - cur[0];
            }
            s.push(new int[]{i, prices[i]});
        }
        while(!s.isEmpty()) {
            int cur[] = s.pop();
            answer[cur[0]] = prices.length-1 - cur[0];
        }
        return answer;
    }
}