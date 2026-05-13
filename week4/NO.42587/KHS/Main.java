import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int cnt = 0;


        for(int i : prices) {
            deque.offer(i);
        }
        int size = deque.size();
        for(int i = 0; i < size; i++) {
            cnt = 0;
            int n = deque.poll();
            for(Integer num : deque) {
                cnt++;
                if(n > num) {
                    break;
                }
            }
            list.add(cnt);
        }


        int[] answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}