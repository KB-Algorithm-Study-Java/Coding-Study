package PSH;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = new int[prices.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<prices.length;i++){
                while(!dq.isEmpty() && prices[i]< prices[dq.peekLast()]){
                    int poll = dq.pollLast();
                    result[poll] = i-poll;
                }

            dq.addLast(i);
        }
        while(!dq.isEmpty()){
            int poll = dq.pollLast();
            result[poll] = prices.length - 1 - poll;
        }
        Arrays.stream(result).forEach(System.out::print);
    }
}