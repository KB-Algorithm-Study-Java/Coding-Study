package PSH;
import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws IOException{
        //buffer 로 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] c = str.toCharArray();
        Arrays.sort(c);

        // A,A,A,B,B,C,C,D,E,E
        StringBuilder front = new StringBuilder();
        String middle= "";
        int odd = 0;
        int i =0;
        while(i< c.length){
            if((i+1)<c.length && c[i]==c[i+1]){
                front.append(c[i]);
                i+=2;
            }else{
                middle += c[i];
                odd ++;
                i++;
            }
        }
        if(odd >1){
            System.out.println("I'm Sorry Hansoo");
            return ;
        }

        System.out.println(front.toString()+middle+front.reverse().toString());




    }
}

