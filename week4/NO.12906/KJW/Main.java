import java.util.*;
import java.lang.*;
public class Solution {
    public Queue<Integer> solution(int []arr) {
        Queue<Integer> q = new ArrayDeque<>();

        int prev = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == prev) continue;
            prev = arr[i];
            q.offer(prev);
        }
        return q;
    }
}