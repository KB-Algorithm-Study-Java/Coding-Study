import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i}); //우선순위,원래인겟스
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int max = queue.stream().mapToInt(p -> p[0]).max().orElse(0);
            if(cur[0] >= max) {
                count++;
                if(cur[1]==location) return count;
            } else queue.add(cur);
        }
        return count;
    }
}