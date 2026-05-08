import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] task = new int[10];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++){
            q.add(i);
            task[priorities[i]]++;
        }
        boolean flag = false;
        for(int i = 9; i > 0; i--) {
            if(task[i] == 0) continue;
            while(task[i] > 0) {
                int t = q.poll();
                if(priorities[t] != i) {
                    q.add(t);
                    continue;
                }
                task[i]--;
                answer++;
                if(t == location) {
                    return answer;
                }
            }
        }
        return -1;
    }
}