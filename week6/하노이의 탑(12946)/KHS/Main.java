import java.util.*;

class Solution {
    List<int[]> list;
    public List<int[]> solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 3, 2);
        return list;
    }

    void hanoi(int n, int start, int to, int mid) {
        if(n == 1) {
            list.add(new int[]{start, to});
            return;
        }

        hanoi(n-1, start, mid, to);
        list.add(new int[]{start, to});
        hanoi(n-1, mid, to, start);
    }
}