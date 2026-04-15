import java.util.*;
public class Main {
    public static void main(String[] args) {

        //입력부분

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        sc.nextLine();
        for(int i=0;i<N;i++){
            arr[i] = sc.nextLine().toCharArray();
        }
        
        //처리부분

        int min = Math.min(N,M);
        int max = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                for(int g=1;g<=min;g++){
                    if(i+g<N && j+g<M){
                        char a = arr[i][j];
                        char b = arr[i][j+g];
                        char c = arr[i+g][j];
                        char d = arr[i+g][j+g];
                        if(a==b&&b==c&&c==d){
                            int pow = (g+1)*(g+1);
                            max = Math.max(max, pow);
                        }
                    }

                }
            }
        }
        System.out.println(max);
    }
}