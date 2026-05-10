import java.util.*;

public class Main1 {
    public int[] solution(int []arr) {
        Stack<Integer> answer = new Stack<>();
        for(int num: arr){
            if(answer.isEmpty() || answer.peek() != num){
                answer.add(num);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
