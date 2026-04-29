import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }
        List<Integer> list = new LinkedList<>();

        for(int i=n;i>=1;i--) {
            list.add(arr[i], i);}
        for(int num : list){
            System.out.print(num+" ");
        }
    }
}