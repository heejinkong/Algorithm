import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<Integer>[] list;
    static int[] iw;
    static int n, m;
    
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         
         list = new ArrayList[n + 1];
         for(int i = 1; i < n + 1; i++) {
             list[i] = new ArrayList<>();
         }
         
         st = new StringTokenizer(br.readLine());
         for(int i = 1; i < n + 1; i++) {
             int N = Integer.parseInt(st.nextToken());
             if(N != -1) {
                 list[N].add(i);
             }
         }
         
         iw = new int[n + 1];
         for(int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine());
             int ii = Integer.parseInt(st.nextToken());
             int w = Integer.parseInt(st.nextToken());
             
             iw[ii] += w;
         }
         dfs(1);
         StringBuilder sb = new StringBuilder();
         for(int i = 1; i < n + 1; i++) {
             sb.append(iw[i]).append(" ");
         }
         System.out.print(sb.toString().trim());
     }
    
    private static void dfs(int start) {
        for(int next : list[start]) {
            iw[next] += iw[start];
            dfs(next);
        }
    }
}