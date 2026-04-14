package KHS;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] mushroom = new int[10];
        int sum = 0;

        for (int i = 0; i < mushroom.length; i++) {
            mushroom[i] = sc.nextInt();
        }

        for (int i = 0; i < mushroom.length; i++) {
            sum += mushroom[i];
            if(sum > 100) {
                if(sum - 100 > 100 - (sum - mushroom[i])) {
                    sum = sum - mushroom[i];
                }
                break;
            }
        }

        System.out.println(sum);
    }
}


// 풀이 1.
//        Scanner sc = new Scanner(System.in);
//
//        int[] mushroom = new int[10];
//        for (int i = 0; i < mushroom.length; i++) {
//            mushroom[i] = sc.nextInt();
//        }
//
//        int cA = 0;
//        int cB = 0;
//
//            for (int i = 0; i < mushroom.length; i++) {
//                cA += mushroom[i];
//                cB += mushroom[i];
//                if (cA > 100) {
//                    cB -= mushroom[i];
//                    break;
//                }
//            }
//       int diffA = Math.abs(100-cA);
//       int diffB = Math.abs(100-cB);
//
//       int result = (diffA == diffB) ? cA : (diffA < diffB) ? cA : cB;
//
//        System.out.println(result);
