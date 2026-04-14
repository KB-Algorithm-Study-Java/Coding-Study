package KHS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] main(int[] answers) {
        // 각 수포자의 정답 패턴 배열 생성
        int[] supoja1 = {1,2,3,4,5};
        int[] supoja2 = {2,1,2,3,2,4,2,5};
        int[] supoja3 = {3,3,1,1,2,2,4,4,5,5};

        // 각 수포자가 정답을 맞춘 개수를 담을 배열 생성
        int[] count = new int[3];

        // 정답을 가장 많이 맞춘 수포자를 담을 ArrayList 생성
        List<Integer> bestSupoja = new ArrayList<Integer>();

        // 가장 많은 정답을 맞춘 수포자를 추출
        for (int i = 0; i < answers.length; i++) {
            // 각 수포자마다 조건문을 걸어둠
            if(supoja1[i%5] == answers[i]) {
                count[0]++;
            }
            if(supoja2[i%8] == answers[i]) {
                count[1]++;
            }
            if(supoja3[i%10] == answers[i]) {
                count[2]++;
            }
        }

        // 가장 정답을 많이 맞춘 수포자 찾기
        int hightCount = 0;
        for(int i = 0; i < count.length; i++) {
            if(hightCount < count[i]) {
                hightCount = count[i];
            }
        }

        // count 배열을 돌며 highCount랑 값이 일치한 요소의 인덱스를 ArrayList에 추가
        for(int i=0; i< count.length; i++) {
            if(count[i] == hightCount) {
                bestSupoja.add(i+1);
            }
        }

        // answer에 반환
        int[] answer = new int[bestSupoja.size()];
        for(int i=0; i<bestSupoja.size(); i++){
            answer[i] = bestSupoja.get(i);
        }

        return answer;
    }
}
