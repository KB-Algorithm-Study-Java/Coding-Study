import java.util.ArrayList;
import java.util.List;

class Main12946 {
    static List<int[]> answer;
    public static List solution(int n) {
        answer = new ArrayList<>();
        hanoi(n,1,2,3);
        return answer;
    }

    static void hanoi(int n,int start, int empty, int finish) {
        if(n==1){
            answer.add(new int[] {start,finish});
            //System.out.println(start+"->"+finish);
            return;
        }
            hanoi(n-1,start,finish,empty);
            answer.add(new int[] {start,finish});
            //System.out.println(start+"->"+finish);
            hanoi(n-1,empty,start,finish);
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
    }
}