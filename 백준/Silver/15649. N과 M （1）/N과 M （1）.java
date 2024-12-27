import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> result = new ArrayList<>();
    static boolean[] visited;
    static int N, M;
    
     public static void main(String[] args) throws IOException{ 
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         
         visited = new boolean[N+1];
         List<Integer> curr = new ArrayList<>();
         
         backtrack(curr);
         
         for(List<Integer> c : result) {
             for(int num : c) {
                 System.out.print(num + " ");
             }
             System.out.println();
         }
         
         
     }
    
    private static void backtrack(List<Integer> curr) {
        if(curr.size() == M) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(visited[i]) {
                continue;
            }
            
            curr.add(i);
            visited[i] = true;
            
            backtrack(curr);
            
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}