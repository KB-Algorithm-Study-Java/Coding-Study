import java.io.*;
import java.nio.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> treeGroup = new TreeMap<>();
        float total = 0;
        String treeName = "";

        while ((treeName = br.readLine()) != null) {
            treeGroup.put(treeName, treeGroup.getOrDefault(treeName, 0) + 1);
            total++;
        }

        for (String s : treeGroup.keySet()) {
            System.out.printf("%s %.4f\n", s, treeGroup.get(s) / total * 100);
        }
    }
}